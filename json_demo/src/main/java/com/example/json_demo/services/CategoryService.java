package com.example.json_demo.services;

import com.example.json_demo.model.Entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;
    Set<Category> findRandomCategories();
}
