package com.clickarte.crm.services;

import org.springframework.stereotype.Service;
import com.clickarte.crm.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
