package com.clickarte.crm.controllers.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.clickarte.crm.dtos.group.CreateGroupCategoryDto;
import com.clickarte.crm.dtos.group.DetailGroupDto;
import com.clickarte.crm.entities.Group;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/group")
@Tag(name = "Groups")
public interface GroupApi {

        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Group created",
                                        content = @Content(mediaType = "application/json")),
                        @ApiResponse(responseCode = "400", description = "Validation error",
                                        content = @Content),
                        @ApiResponse(responseCode = "500", description = "Internal server error",
                                        content = @Content)})
        @PostMapping
        ResponseEntity<DetailGroupDto> create(@RequestBody(description = "Create a new group",
                        content = @Content(mediaType = "application/json", schema = @Schema(
                                        implementation = CreateGroupCategoryDto.class)),
                        required = true) @Valid CreateGroupCategoryDto createGroupCategory,
                        UriComponentsBuilder uriComponentsBuilder);


        @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Groups listed",
                        content = @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = DetailGroupDto[].class))),
                        @ApiResponse(responseCode = "400", description = "Validation error",
                                        content = @Content),
                        @ApiResponse(responseCode = "500", description = "Internal server error",
                                        content = @Content)})
        @GetMapping("{id}")
        ResponseEntity<Group> find(@PathVariable(name = "id", required = true) Long id);


        @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Group deleted"),
                        @ApiResponse(responseCode = "400", description = "Validation error",
                                        content = @Content),
                        @ApiResponse(responseCode = "500", description = "Internal server error",
                                        content = @Content)})

        @DeleteMapping("{id}")
        ResponseEntity<Void> delete(@PathVariable(name = "id", required = true) Long id);

        @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Groups listed",
                        content = @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = DetailGroupDto.class))),
                        @ApiResponse(responseCode = "400", description = "Validation error",
                                        content = @Content),
                        @ApiResponse(responseCode = "500", description = "Internal server error",
                                        content = @Content)})
        @GetMapping
        Page<DetailGroupDto> list(Pageable pageable);

}
