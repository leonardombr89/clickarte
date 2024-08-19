package com.clickarte.crm.dtos.group;

import com.clickarte.crm.dtos.category.DetailCategoryDto;


public record DetailGroupDto(Long id, String name, DetailCategoryDto category) {


}
