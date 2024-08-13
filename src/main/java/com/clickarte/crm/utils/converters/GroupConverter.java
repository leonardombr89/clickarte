package com.clickarte.crm.utils.converters;


import com.clickarte.crm.dtos.group.CreateGroupCategoryDto;
import com.clickarte.crm.entities.Category;
import com.clickarte.crm.entities.Group;

public class GroupConverter {

    public static Group createGroupDtoToGroup(CreateGroupCategoryDto createGroupCategoryDto,
            Category category) {
        var group = new Group();
        group.setName(createGroupCategoryDto.name());
        group.setCategory(category);
        return group;

    }
}
