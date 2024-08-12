package com.clickarte.crm.services;

import org.springframework.stereotype.Service;
import com.clickarte.crm.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
