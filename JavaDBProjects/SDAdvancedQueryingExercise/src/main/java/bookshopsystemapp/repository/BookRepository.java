package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    /* 1.	Books Titles by Age Restriction */
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    /* 2.	Golden Books */
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    /* 3.	Books by Price */
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    /* 4.	Not Released Books */
    List<Book> findAllByReleaseDateLessThanOrReleaseDateGreaterThan(LocalDate lower, LocalDate upper);

    /* 5.	Books Released Before Date */
    List<Book> findAllByReleaseDateBefore(LocalDate date);

    /* 7.	Books Search */
    List<Book> findAllByTitleContaining(String part);

    /* 8.	Book Titles Search */
    List<Book> findAllByAuthorIn(List<Author> authors);

    /* 9.	Count Books */
    @Query("SELECT b from bookshopsystemapp.domain.entities.Book as b where length(title) > :length")
    List<Book> findAllByTitleLongerThanGivenNumber(@Param(value = "length") int length);

    /* 11.	Reduced Book */
    List<ReducedBook> findAllByTitle(String title);

    /* 12.	* Increase Book Copies */
    List<Book> findAllByReleaseDateAfter(LocalDate date);

    /* 13.	* Remove Books */
    List<Book> findAllByCopiesLessThan(int value);
}
