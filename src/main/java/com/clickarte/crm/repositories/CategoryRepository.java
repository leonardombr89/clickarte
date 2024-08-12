package com.clickarte.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clickarte.crm.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
