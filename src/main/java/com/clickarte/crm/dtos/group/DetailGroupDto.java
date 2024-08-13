package com.clickarte.crm.dtos.group;

import com.clickarte.crm.dtos.category.DetailCategoryDto;
import com.clickarte.crm.entities.Group;

public record DetailGroupDto(Long id, String name, DetailCategoryDto category) {

    public DetailGroupDto(Group group) {
        this(group.getId(), group.getName(), new DetailCategoryDto(group.getCategory().getId(),
                group.getCategory().getName(), group.getCategory().getDescription()));
    }

}
