package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\SDAdvancedQueryingExercise\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    /* 1.	Books Titles by Age Restriction */
    @Override
    public List<String> getBookTitlesByAgeRestriction(String ageRestriction) {
        return this.bookRepository
                .findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /* 2.	Golden Books */
    @Override
    public List<String> getGoldenEditionBookTitlesWithCopiesLessThan5000() {
        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf("GOLD"), 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /* 3.	Books by Price */
    @Override
    public List<String> getBooksOutsidePriceRange() {
        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal(5), new BigDecimal(40))
                .stream()
                .map(book -> String.format("%s - $%s",
                        book.getTitle(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    /* 4.	Not Released Books */
    @Override
    public List<String> getBookTitlesOfAllBooksNotReleasedInGivenYear(String yearString) {
        Year year = Year.parse(yearString);
        LocalDate lower = year.atMonth(Month.JANUARY).atDay(1);
        LocalDate upper = year.atMonth(Month.DECEMBER).atDay(31);
        return this.bookRepository
                .findAllByReleaseDateLessThanOrReleaseDateGreaterThan(lower, upper)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /* 5.	Books Released Before Date */
    @Override
    public List<String> getBooksReleasedBeforeGivenDate(String dateString) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository
                .findAllByReleaseDateBefore(date)
                .stream()
                .map(book -> String.format("%s %s %s",
                        book.getTitle(),
                        book.getEditionType().toString(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    /* 7.	Books Search */
    @Override
    public List<String> getBooksWhoseTitleContainGivenString(String part) {
        return this.bookRepository
                .findAllByTitleContaining(part)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /* 8.	Book Titles Search */
    @Override
    public List<String> getBookTitlesByAuthorsGivenLastNamePart(String part) {
        List<Author> authors = this.authorRepository
                .findAllByLastNameStartingWith(part);

        return this.bookRepository
                .findAllByAuthorIn(authors)
                .stream()
                .map(b -> String.format("%s (%s %s)",
                        b.getTitle(),
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    /* 9.	Count Books */
    @Override
    public int getBookTitlesWithLengthGreaterThanGivenNumberCount(int number) {
        List<Book> books = this.bookRepository
                .findAllByTitleLongerThanGivenNumber(number);
        return books.size();
    }

    /* 11.	Reduced Book */
    @Override
    public List<String> getInfoPerBookByGivenTitle(String title) {
        return this.bookRepository
                .findAllByTitle(title)
                .stream()
                .map(b -> String.format("%s %s %s %s",
                        b.getTitle(),
                        b.getEditionType().toString(),
                        b.getAgeRestriction().toString(),
                        b.getPrice()))
                .collect(Collectors.toList());
    }

    /* 12.	* Increase Book Copies */
    @Override
    public int updateBooksWithReleaseDateAfterWithGivenValue(String date, int copies) {
        List<Book> books = this.bookRepository
                .findAllByReleaseDateAfter(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        books.forEach(b -> b.setCopies(b.getCopies() + copies));

        this.bookRepository.saveAll(books);

        return books.size() * copies;
    }

    /* 13.	* Remove Books */
    @Override
    public int deleteBooksWithCopiesLessThanValue(int value) {
        List<Book> books = this.bookRepository
                .findAllByCopiesLessThan(value);

        int size = books.size();

        for (Book book : books) {
            if (book != null) {
                book.setCategories(null);
                this.bookRepository.delete(book);
            }
        }
        return size;
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }
}
