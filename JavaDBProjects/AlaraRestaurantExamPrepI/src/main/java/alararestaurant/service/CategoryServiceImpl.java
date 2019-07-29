package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        List<Category> allCategories = categoryRepository.findAll();

        StringBuilder sb = new StringBuilder();

        List<Category> sortedCategories = allCategories.stream().sorted((a, b) -> {
            int result = Integer.compare(b.getItems().size(), a.getItems().size());

            if (result == 0) {
                result = Double.compare(b.getItems().stream().mapToDouble(i -> i.getPrice().doubleValue()).sum(),
                        a.getItems().stream().mapToDouble(i -> i.getPrice().doubleValue()).sum());
            }
            return result;
        }).collect(Collectors.toList());

        for (Category category : sortedCategories) {
            sb.append("Category: ").append(category.getName()).append(System.lineSeparator());
            for (Item item : category.getItems()) {
                sb.append(String.format("--- Item Name: %s%n", item.getName()))
                        .append(String.format("--- Item Price: %s%n%n", item.getPrice()));
            }
        }

        return sb.toString().trim();
    }
}
