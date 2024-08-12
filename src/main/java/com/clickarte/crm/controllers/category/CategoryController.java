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
import com.clickarte.crm.entities.Category;
import com.clickarte.crm.services.CategoryService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/category")
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody @Valid CreateCategoryDto createCategory,
            UriComponentsBuilder uriComponentsBuilder) {
        var newCategory = categoryService.createCategory(createCategory);
        var uri = uriComponentsBuilder.path("/category/{id}").buildAndExpand(newCategory.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newCategory);
    }

    @GetMapping()
    public Page<Category> list(Pageable pageable) {
        return categoryService.list(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.find(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
