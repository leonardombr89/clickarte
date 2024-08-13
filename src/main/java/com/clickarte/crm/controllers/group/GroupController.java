package com.clickarte.crm.controllers.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.group.CreateGroupCategoryDto;
import com.clickarte.crm.dtos.group.DetailGroupDto;
import com.clickarte.crm.entities.Group;
import com.clickarte.crm.services.GroupService;
import com.clickarte.crm.utils.ControllerUtil;


@RestController
public class GroupController implements GroupApi {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public ResponseEntity<DetailGroupDto> create(CreateGroupCategoryDto createGroupCategory,
            UriComponentsBuilder uriComponentsBuilder) {

        var group = groupService.create(createGroupCategory);
        var uri = ControllerUtil.getUri(uriComponentsBuilder, "/group/{id}", group.id());
        return ResponseEntity.created(uri).body(group);
    }

    public Page<DetailGroupDto> list(Pageable pageable) {
        var response = groupService.list(pageable);
        return response;
    }

    public ResponseEntity<Group> find(Long id) {
        return ResponseEntity.ok(groupService.find(id));
    }

    public ResponseEntity<Void> delete(Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
