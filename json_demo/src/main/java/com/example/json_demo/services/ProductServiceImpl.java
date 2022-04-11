package com.example.json_demo.services;

import com.example.json_demo.model.Entity.Product;
import com.example.json_demo.model.dto.ProductSeedDto;
import com.example.json_demo.repository.ProductRepository;
import com.example.json_demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {
   private final ProductRepository productRepository;
   private final ModelMapper modelMapper;
   private final ValidationUtil validationUtil;
   private final UserService userService;
   private final Gson gson;
   private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, Gson gson, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.gson = gson;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if(productRepository.count()>0){return;}
        String file= Files.readString(Path.of("src/main/resources/files/products.json"));
        ProductSeedDto [] productSeedDtos = gson.fromJson(file,ProductSeedDto[].class);
        Arrays.stream(productSeedDtos).filter(validationUtil::isValid).map(productSeedDto -> {

            Product product= modelMapper.map(productSeedDto,Product.class);
            product.setSeller(userService.findRandomUser());
            if(product.getPrice().compareTo(BigDecimal.valueOf(500))>0){
                product.setBuyer(userService.findRandomUser());

            }
            product.setCategories(categoryService.findRandomCategories());
            return product;
        }).forEach(productRepository::save);
    }
}
