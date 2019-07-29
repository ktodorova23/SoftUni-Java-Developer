package com.example.bookshopSystem.services;

import com.example.bookshopSystem.enums.AgeRestriction;
import com.example.bookshopSystem.enums.EditionType;
import com.example.bookshopSystem.models.Author;
import com.example.bookshopSystem.models.Book;
import com.example.bookshopSystem.models.Category;
import com.example.bookshopSystem.repositories.AuthorRepository;
import com.example.bookshopSystem.repositories.BookRepository;
import com.example.bookshopSystem.repositories.CategoryRepository;
import com.example.bookshopSystem.services.base.BookService;
import com.example.bookshopSystem.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final static String BOOKS_FILE_PATH =
            "E:\\Java\\DB Projects\\JavaDB\\SDIntroExercise\\src\\main\\resources\\files\\books.txt";

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

        String[] books = this.fileUtil.fileContent(BOOKS_FILE_PATH);

        for (String element : books) {
            String[] params = element.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.randomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(params[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            book.setCopies(Integer.parseInt(params[2]));

            BigDecimal price = new BigDecimal(params[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();

            for (int i = 5; i < params.length; i++) {
                title.append(params[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            book.setCategories(this.randomCategories());

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> findAllTitles() {

        LocalDate releaseDate = LocalDate.parse("31/12/2000", DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository
                .findAllByReleaseDateAfter(releaseDate)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthors() {
        LocalDate releaseDate = LocalDate.parse("01/01/1990", DateTimeFormatter.ofPattern("d/M/yyyy"));
        return this.bookRepository.findAllByReleaseDateBefore(releaseDate)
                .stream()
                .map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksByAuthor() {
        Author author = this.authorRepository.findAllByFirstNameAndLastName("George", "Powell");
        return this.bookRepository
                .findAllByAuthorOrderByReleaseDateDescTitleAsc(author)
                .stream()
                .map(b -> String.format("%s %s %d", b.getTitle(), b.getReleaseDate(),
                        b.getCopies()))
                .collect(Collectors.toList());
    }

    private Author randomAuthor(){
        Random random = new Random();

        int id = random.nextInt((int) this.authorRepository.count()) + 1;

        return this.authorRepository.getOne(id);
    }

    private Category randomCategory() {
        Random random = new Random();

        int id = random.nextInt((int) this.categoryRepository.count()) + 1;

        return this.categoryRepository.getOne(id);
    }

    private Set<Category> randomCategories() {
        Set<Category> categories = new HashSet<>();

        Random random = new Random();
        int index = random.nextInt((int) this.categoryRepository.count()) + 1;

        for (int i = 0; i < index; i++) {
            categories.add(this.randomCategory());
        }

        return categories;
    }
}
