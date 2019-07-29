package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();

        /* 1.	Books Titles by Age Restriction */
//        this.getAndPrintBookTitlesByAgeRestriction(reader);
        /* 2.	Golden Books */
//        this.getAndPrintGoldenBooksTitles();
        /* 3.	Books by Price */
//        this.getAndPrintBookTitleAndPricesOutsideRange();
        /* 4.	Not Released Books */
//        this.getBookTitleByReleaseDateDifferentThan(reader);
        /* 5.	Books Released Before Date */
//        this.getBooksReleaseBeforeGivenDate(reader);
        /* 6.	Authors Search */
//        this.getAuthorWhoseNamesEndWithGivenPart(reader);
        /* 7.	Books Search */
//        this.getAndPrintAllBooksWhoseTitleContainsGivenString(reader);
        /* 8.	Book Titles Search */
//        this.getAndPrintBookTitlesByAuthorLastNameContaining(reader);
        /* 9.	Count Books */
//        this.getCountOfBookTitlesLongerThanGivenNumber(reader);
        /* 10.	Total Book Copies */
//        this.getAuthorsWithTotalCopies();
        /* 11.	Reduced Book */
//        this.getInfoByBookTitle(reader);
        /* 12.	* Increase Book Copies */
//        this.updateBooksReleasedAfter(reader);
        /* 13.	* Remove Books */
//        this.deleteBooksWithCopiesLessThanInput(reader);
        /* 14.	* Stored Procedure */
        this.getWrittenBooksCountByAuthor(reader);
    }

    /* 1.	Books Titles by Age Restriction */
    private void getAndPrintBookTitlesByAgeRestriction(BufferedReader reader) throws IOException {
        String ageRestriction = reader.readLine();

        this.bookService
                .getBookTitlesByAgeRestriction(ageRestriction)
        .forEach(System.out::println);
    }

    /* 2.	Golden Books */
    private void getAndPrintGoldenBooksTitles() {
        this.bookService
                .getGoldenEditionBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    /* 3.	Books by Price */
    private void getAndPrintBookTitleAndPricesOutsideRange() {
        this.bookService
                .getBooksOutsidePriceRange()
                .forEach(System.out::println);
    }

    /* 4.	Not Released Books */
    private void getBookTitleByReleaseDateDifferentThan(BufferedReader reader) throws IOException {
        String year = reader.readLine();

        this.bookService
                .getBookTitlesOfAllBooksNotReleasedInGivenYear(year)
                .forEach(System.out::println);
    }

    /* 5.	Books Released Before Date */
    private void getBooksReleaseBeforeGivenDate(BufferedReader reader) throws IOException {
        String dateString = reader.readLine();

        this.bookService
                .getBooksReleasedBeforeGivenDate(dateString)
                .forEach(System.out::println);
    }

    /*  6.	Authors Search */
    private void getAuthorWhoseNamesEndWithGivenPart(BufferedReader reader) throws IOException {
        String part = reader.readLine();

        this.authorService
                .getAllAuthorsWhoseFirstNameEndsWithGivenString(part)
                .forEach(System.out::println);
    }

    /* 7.	Books Search */
    private void getAndPrintAllBooksWhoseTitleContainsGivenString(BufferedReader reader) throws IOException {
        String part = reader.readLine();

        this.bookService
                .getBooksWhoseTitleContainGivenString(part)
                .forEach(System.out::println);
    }

    /* 8.	Book Titles Search */
    private void getAndPrintBookTitlesByAuthorLastNameContaining(BufferedReader reader) throws IOException {
        String part = reader.readLine();
        this.bookService
                .getBookTitlesByAuthorsGivenLastNamePart(part)
                .forEach(System.out::println);
    }

    /* 9.	Count Books */
    private void getCountOfBookTitlesLongerThanGivenNumber(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());

        int countBooks = this.bookService
                .getBookTitlesWithLengthGreaterThanGivenNumberCount(length);

        System.out.println(String.format("There are %d books with longer title than %d symbols",
                countBooks,
                length));
    }

    /* 10.	Total Book Copies */
    private void getAuthorsWithTotalCopies() {
        this.authorService
                .getAllAuthorsOrderedDescByBooksCopies()
                .forEach(System.out::println);
    }

    /* 11.	Reduced Book */
    private void getInfoByBookTitle(BufferedReader reader) throws IOException {
        String title = reader.readLine();

        this.bookService
                .getInfoPerBookByGivenTitle(title)
                .forEach(System.out::println);
    }

    /* 12.	* Increase Book Copies */
    public void updateBooksReleasedAfter(BufferedReader reader) throws IOException, ParseException {
        String dateString = reader.readLine();
        int copiesToAdd = Integer.parseInt(reader.readLine());

        String hyphenedDate = dateString.replaceAll(" ", "-");

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format1.parse(hyphenedDate);
        String formattedDateString = format2.format(date);

        System.out.println(this.bookService.updateBooksWithReleaseDateAfterWithGivenValue(formattedDateString, copiesToAdd));
    }

    /* 13.	* Remove Books */
    public void deleteBooksWithCopiesLessThanInput(BufferedReader reader) throws IOException {
        int value = Integer.parseInt(reader.readLine());

        System.out.println(this.bookService.deleteBooksWithCopiesLessThanValue(value));
    }

    /* 14.	* Stored Procedure */
    public void getWrittenBooksCountByAuthor(BufferedReader reader) throws IOException {
        String name = reader.readLine();

        BigInteger count = this.authorService.getBooksCountByAuthor(name);

        System.out.println(String.format("%s has written %d books",
                name, count));
    }
}
