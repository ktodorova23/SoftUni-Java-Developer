package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    /* 1.	Books Titles by Age Restriction */
    List<String> getBookTitlesByAgeRestriction(String ageRestriction);

    /* 2.	Golden Books */
    List<String> getGoldenEditionBookTitlesWithCopiesLessThan5000();

    /* 3.	Books by Price */
    List<String> getBooksOutsidePriceRange();

    /* 4.	Not Released Books */
    List<String> getBookTitlesOfAllBooksNotReleasedInGivenYear(String year);

    /* 5.	Books Released Before Date */
    List<String> getBooksReleasedBeforeGivenDate(String date);

    /* 7.	Books Search */
    List<String> getBooksWhoseTitleContainGivenString(String part);

    /* 8.	Book Titles Search */
    List<String> getBookTitlesByAuthorsGivenLastNamePart(String part);

    /* 9.	Count Books */
    int getBookTitlesWithLengthGreaterThanGivenNumberCount(int number);

    /* 11.	Reduced Book */
    List<String> getInfoPerBookByGivenTitle(String title);

     /* 12.	* Increase Book Copies */
     int updateBooksWithReleaseDateAfterWithGivenValue(String date, int copies);

     /* 13.	* Remove Books */
    int deleteBooksWithCopiesLessThanValue(int value);
}
