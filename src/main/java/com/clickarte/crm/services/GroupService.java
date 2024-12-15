package com.clickarte.crm.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickarte.crm.dtos.group.CreateGroupCategoryDto;
import com.clickarte.crm.dtos.group.DetailGroupDto;
import com.clickarte.crm.entities.Group;
import com.clickarte.crm.repositories.GroupRepository;
import com.clickarte.crm.utils.converters.GroupConverter;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final CategoryService categoryService;

    public GroupService(GroupRepository groupRepository, CategoryService categoryService) {
        this.groupRepository = groupRepository;
        this.categoryService = categoryService;
    }

    @Transactional
    public DetailGroupDto create(CreateGroupCategoryDto createGroupCategory) {
        var category = categoryService.find(createGroupCategory.categoryId());
        var group = GroupConverter.createGroupDtoToGroup(createGroupCategory, category);
        this.groupRepository.save(group);
        var response = GroupConverter.groupToDetailGroupDto(group);
        return response;

    }

    @Transactional(readOnly = true)
    public Group find(Long id) {
        var found = this.groupRepository.findById(id).orElseThrow();
        return found;
    }

    @Transactional()
    public void delete(Long id) {
        this.groupRepository.deleteById(id);
    }

    public Page<DetailGroupDto> list(Pageable pageable) {
        var list = groupRepository.findAll(pageable)
                .map(group -> GroupConverter.groupToDetailGroupDto(group));
        return list;
    }


}


