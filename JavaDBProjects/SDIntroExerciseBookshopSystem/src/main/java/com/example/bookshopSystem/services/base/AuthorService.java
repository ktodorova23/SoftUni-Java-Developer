package com.example.bookshopSystem.services.base;

import com.example.bookshopSystem.models.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<Author> allAuthorsOrderedByBooksCount();
}
