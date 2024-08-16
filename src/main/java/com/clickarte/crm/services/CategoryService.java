package com.clickarte.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.clickarte.crm.dtos.category.CreateCategoryDto;
import com.clickarte.crm.entities.Category;
import com.clickarte.crm.repositories.CategoryRepository;
import com.clickarte.crm.utils.converters.CategoryConverter;
import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category createCategory(CreateCategoryDto createCategoryDto) {
        var createdCategory = CategoryConverter.createCategoryDtoToCategory(createCategoryDto);
        return categoryRepository.save(createdCategory);
    }

    public Category find(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Page<Category> list(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
