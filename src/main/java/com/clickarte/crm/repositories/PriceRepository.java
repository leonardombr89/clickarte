package com.clickarte.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.clickarte.crm.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
