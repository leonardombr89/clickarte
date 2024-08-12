package com.clickarte.crm.Product.Category;

import org.springframework.data.repository.CrudRepository;
import com.clickarte.crm.Product.Product;

public interface CategoryRepository extends CrudRepository<Product, Long> {

}
