package com.example.bookshopSystem.services;

import com.example.bookshopSystem.models.Author;
import com.example.bookshopSystem.repositories.AuthorRepository;
import com.example.bookshopSystem.services.base.AuthorService;
import com.example.bookshopSystem.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final static String AUTHOR_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\SDIntroExercise\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authors = this.fileUtil.fileContent(AUTHOR_FILE_PATH);

        for (String element : authors) {
            String[] params = element.split("\\s+");
            Author author = new Author();
            author.setFirstName(params[0]);
            author.setLastName(params[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<Author> allAuthorsOrderedByBooksCount() {
        return this.authorRepository
                .findAllOrderedByBooksSize();
    }
}
