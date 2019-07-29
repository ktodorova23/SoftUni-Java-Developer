package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final static String AUTHORS_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\SDAdvancedQueryingExercise\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, EntityManager entityManager, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.entityManager = entityManager;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);
        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    /* 6.	Authors Search */
    @Override
    public List<String> getAllAuthorsWhoseFirstNameEndsWithGivenString(String part) {
        return this.authorRepository
                .findAllByFirstNameEndingWith(part)
                .stream()
                .map(author -> String.format("%s %s",
                        author.getFirstName(),
                        author.getLastName()))
                .collect(Collectors.toList());
    }

    /* 10.	Total Book Copies */
    @Override
    public List<String> getAllAuthorsOrderedDescByBooksCopies() {
        return this.authorRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(a -> a.getBooks().stream().mapToInt(Book::getCopies).sum(), Comparator.reverseOrder()))
                .map(a -> String.format("%s %s", a.getFullName(), a.getBooks().stream().mapToInt(Book::getCopies).sum()))
                .collect(Collectors.toList());
    }

    /* 14.	* Stored Procedure */
    @Override
    public BigInteger getBooksCountByAuthor(String name) {
        try {
            Object count = this.entityManager
                    .createNamedStoredProcedureQuery("getBookCountByAuthorName")
                    .setParameter("full_name", name)
                    .getSingleResult();

            return (BigInteger) count;
        } catch (NoResultException nre) {
            return BigInteger.ZERO;
        }
    }
}
