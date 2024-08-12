package com.clickarte.crm.repositories;

import org.springframework.data.repository.CrudRepository;
import com.clickarte.crm.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
