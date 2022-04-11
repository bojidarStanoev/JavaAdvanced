package com.example.json_demo.services;

import com.example.json_demo.model.Entity.Category;
import com.example.json_demo.model.dto.CategorySeedDto;
import com.example.json_demo.repository.CategoryRepository;
import com.example.json_demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.count()>0){return;}
    String file=Files.readString(Path.of("src/main/resources/files/categories.json"));
        CategorySeedDto [] categorySeedDtos = gson.fromJson(file,CategorySeedDto [].class);
        Arrays.stream(categorySeedDtos).filter(validationUtil::isValid).map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categorySet= new HashSet<>();
        int categoryCount= ThreadLocalRandom.current().nextInt(1,3);
        for (int i=0;i<categoryCount;i++){
            long randomId=ThreadLocalRandom.current().nextLong(1,categoryRepository.count()+1);
            categorySet.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categorySet;
    }
}
