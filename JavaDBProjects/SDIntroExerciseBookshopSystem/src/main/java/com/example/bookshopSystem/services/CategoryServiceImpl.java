package com.example.bookshopSystem.services;

import com.example.bookshopSystem.models.Category;
import com.example.bookshopSystem.repositories.CategoryRepository;
import com.example.bookshopSystem.services.base.CategoryService;
import com.example.bookshopSystem.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static String CATEGORY_FILE_PATH =
            "E:\\Java\\DB Projects\\JavaDB\\SDIntroExercise\\src\\main\\resources\\files\\categories.txt";

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() != 0) {
            return;
        }

        String[] categories = this.fileUtil.fileContent(CATEGORY_FILE_PATH);

        for (String element : categories) {
            Category category = new Category();
            category.setName(element);

            this.categoryRepository.saveAndFlush(category);
        }
    }
}
