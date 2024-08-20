package com.clickarte.crm.controllers.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.product.CreateProductDto;
import com.clickarte.crm.dtos.product.DetailProductDto;
import com.clickarte.crm.dtos.product.ListProductDto;
import com.clickarte.crm.services.ProductService;
import com.clickarte.crm.utils.ControllerUtil;
import com.clickarte.crm.utils.constantes.ApiPaths;

@RestController
public class ProductController implements ProductApi {


    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<DetailProductDto> create(CreateProductDto createProduct,
            UriComponentsBuilder uriComponentsBuilder) {

        var product = productService.create(createProduct);
        var uri = ControllerUtil.getUri(uriComponentsBuilder, ApiPaths.PRODUCT_BY_ID, product.Id());
        return ResponseEntity.created(uri).body(product);

    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<DetailProductDto> find(Long id) {
        return ResponseEntity.ok(productService.findById(id));

    }

    @Override
    public Page<ListProductDto> list(Pageable pageable) {
        return productService.findAll(pageable);
    }
}
