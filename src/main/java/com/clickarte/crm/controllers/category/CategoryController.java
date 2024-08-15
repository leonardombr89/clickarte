package com.clickarte.crm.controllers.category;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.category.CreateCategoryDto;
import com.clickarte.crm.entities.Category;
import com.clickarte.crm.services.CategoryService;
import com.clickarte.crm.utils.ControllerUtil;
import com.clickarte.crm.utils.constantes.ApiPaths;



@RestController
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public ResponseEntity<Category> create(CreateCategoryDto createCategory,
            UriComponentsBuilder uriComponentsBuilder) {

        var newCategory = categoryService.createCategory(createCategory);
        var uri = ControllerUtil.getUri(uriComponentsBuilder, ApiPaths.CATEGORY_BY_ID, newCategory.getId());
        return ResponseEntity.created(uri).body(newCategory);
    }

    public Page<Category> list(Pageable pageable) {
        return categoryService.list(pageable);
    }


    public ResponseEntity<Category> find(Long id) {
        return ResponseEntity.ok(categoryService.find(id));
    }

    public ResponseEntity<Void> delete(Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
