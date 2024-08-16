package com.clickarte.crm.controllers.category;

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
import com.clickarte.crm.dtos.category.CreateCategoryDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import com.clickarte.crm.entities.Category;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/category")
@Tag(name = "Category")
public interface CategoryApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error"),})
    @PostMapping
    ResponseEntity<Category> create(@RequestBody @Valid CreateCategoryDto createCategory,
            UriComponentsBuilder uriComponentsBuilder);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of categories",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Category.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping()
    Page<Category> list(Pageable pageable);


    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Category has been found"),
                    @ApiResponse(responseCode = "404", description = "Category not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("{id}")
    ResponseEntity<Category> find(@PathVariable Long id);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "category has been deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "category not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "server error", content = @Content),

    })
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id);

}
