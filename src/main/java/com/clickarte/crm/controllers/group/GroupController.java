package com.clickarte.crm.controllers.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.group.CreateGroupCategoryDto;
import com.clickarte.crm.entities.Group;
import com.clickarte.crm.services.GroupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/group")
public class GroupController implements GroupApi {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<DetailGroupDto> create(
            @RequestBody @Valid CreateGroupCategoryDto createGroupCategory,
            UriComponentsBuilder uriComponentsBuilder) {

        var group = groupService.create(createGroupCategory);
        var uri = uriComponentsBuilder.path("/group/{id}").buildAndExpand(group.id()).toUri();
        return ResponseEntity.created(uri).body(group);
    }

    @GetMapping
    public Page<DetailGroupDto> list(Pageable pageable) {
        var response = groupService.list(pageable);
        return response;
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> find(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.find(id));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
