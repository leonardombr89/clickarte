package com.clickarte.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clickarte.crm.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
