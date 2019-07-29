package com.example.bookshopSystem.controllers;

import com.example.bookshopSystem.services.base.AuthorService;
import com.example.bookshopSystem.services.base.BookService;
import com.example.bookshopSystem.services.base.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public AppController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

//        this.allBooks();
//        this.allAuthors();
//        this.allAuthorsOrdered();
        this.booksOfAnAuthorOrdered();
    }

    private void allBooks() {
        this.bookService.findAllTitles()
                .forEach(System.out::println);
    }

    private void allAuthors() {
        this.bookService.findAllAuthors()
                .forEach(System.out::println);
    }

    private void allAuthorsOrdered() {
        this.authorService
                .allAuthorsOrderedByBooksCount()
                .forEach(a -> System.out.println(String.format("%s %s %d",
                        a.getFirstName(),
                        a.getLastName(),
                        a.getBooks().size())));
    }

    private void booksOfAnAuthorOrdered() {
        this.bookService
                .booksByAuthor()
                .forEach(System.out::println);
    }
}
