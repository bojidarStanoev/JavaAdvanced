package com.example.json_demo;

import com.example.json_demo.services.CategoryService;
import com.example.json_demo.services.ProductService;
import com.example.json_demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }
    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUser();
        productService.seedProducts();
    }
}
