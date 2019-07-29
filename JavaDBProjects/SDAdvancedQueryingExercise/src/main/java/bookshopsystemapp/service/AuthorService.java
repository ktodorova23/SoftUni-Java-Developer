package bookshopsystemapp.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<String> getAllAuthorsWhoseFirstNameEndsWithGivenString(String part);

    List<String> getAllAuthorsOrderedDescByBooksCopies();

    BigInteger getBooksCountByAuthor(String name);
}
