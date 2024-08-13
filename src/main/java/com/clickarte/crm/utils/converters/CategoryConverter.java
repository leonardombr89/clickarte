package com.clickarte.crm.utils.converters;

import com.clickarte.crm.dtos.category.CreateCategoryDto;
import com.clickarte.crm.entities.Category;

public class CategoryConverter {


    public static Category createCategoryDtoToCategory(CreateCategoryDto createCategoryDto) {
        var category = new Category();
        category.setName(createCategoryDto.name());
        category.setDescription(createCategoryDto.description());
        return category;
    }
}
