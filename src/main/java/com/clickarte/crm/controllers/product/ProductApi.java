package com.clickarte.crm.controllers.product;


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
import com.clickarte.crm.dtos.product.CreateProductDto;
import com.clickarte.crm.dtos.product.DetailProductDto;
import com.clickarte.crm.dtos.product.ListProductDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/product")
@Tag(name = "Products")
public interface ProductApi {



        @PostMapping
        ResponseEntity<DetailProductDto> create(@RequestBody(required = true,
                        description = "Create a new product",
                        content = @Content(mediaType = "application/json", schema = @Schema(
                                        implementation = CreateProductDto.class))) @org.springframework.web.bind.annotation.RequestBody @Valid CreateProductDto createProduct,
                        UriComponentsBuilder uriComponentsBuilder);


        @DeleteMapping("{id}")
        ResponseEntity<Void> delete(@PathVariable(required = true, name = "id") Long id);

        @GetMapping("{id}")
        ResponseEntity<DetailProductDto> find(@PathVariable(required = true, name = "id") Long id);

        @GetMapping
        Page<ListProductDto> list(Pageable pageable);

}
