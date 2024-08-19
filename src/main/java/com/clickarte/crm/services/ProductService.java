package com.clickarte.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clickarte.crm.dtos.product.CreateProductDto;
import com.clickarte.crm.dtos.product.DetailProductDto;
import com.clickarte.crm.dtos.product.ListProductDto;
import com.clickarte.crm.entities.Product;
import com.clickarte.crm.repositories.ProductRepository;
import com.clickarte.crm.utils.converters.ProductConverter;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final GroupService groupService;

    public ProductService(ProductRepository productRepository, GroupService groupService) {
        this.productRepository = productRepository;
        this.groupService = groupService;
    }

    @Transactional
    public DetailProductDto create(CreateProductDto createProduct) {

        var group = groupService.find(createProduct.groupId());

        var product = ProductConverter.createProductDtoToProduct(createProduct, group);

        this.productRepository.save(product);


        return ProductConverter.productToResponseCreatedProductDto(product);
    }

    @Transactional(readOnly = true)
    public DetailProductDto findById(Long id) {
        var product = this.productRepository.findById(id).orElseThrow();

        return ProductConverter.productToResponseCreatedProductDto(product);
    }


    @Transactional
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }


    public Page<ListProductDto> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable)
                .map(product -> ProductConverter.productToListProductDto(product));
    }

}
