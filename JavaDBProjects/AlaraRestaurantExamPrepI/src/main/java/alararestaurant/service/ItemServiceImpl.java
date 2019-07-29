package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.jsons.ItemSeedDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.Constants;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return fileUtil.readFile(Constants.ITEMS_INPUT_JSON_FILE_PATH);
    }

    @Override
    public String importItems(String items) throws IOException {
        StringBuilder sb = new StringBuilder();

        ItemSeedDto[] itemSeedDtos = gson.fromJson(readItemsJsonFile(), ItemSeedDto[].class);

        for (ItemSeedDto dto : itemSeedDtos) {
            Item entity = itemRepository.findItemByName(dto.getName());
            if (entity == null) {
                entity = modelMapper.map(dto, Item.class);
                Category category = categoryRepository.findCategoryByName(dto.getCategory());

                if (category == null) {
                    category = new Category();
                    category.setName(dto.getCategory());

                    if (!validationUtil.isValid(category)) {
                        validationUtil.validate(category).forEach(v -> System.out.println(v.getMessage()));

                        continue;
                    }

                    entity.setCategory(category);

                    if (!validationUtil.isValid(entity)) {
                        validationUtil.validate(entity).forEach(v -> System.out.println(v.getMessage()));

                        continue;
                    }
                    categoryRepository.saveAndFlush(category);
                    sb.append(String.format("Record %s successfully imported.", entity.getName()));
                    itemRepository.saveAndFlush(entity);
                } else {
                    entity.setCategory(category);

                    if (!validationUtil.isValid(entity)) {
                        validationUtil.validate(entity).forEach(v -> System.out.println(v.getMessage()));

                        continue;
                    }
                    sb.append(String.format("Record %s successfully imported.", entity.getName()));
                    itemRepository.saveAndFlush(entity);
                }
            }
        }

        return sb.toString().trim();
    }
}
