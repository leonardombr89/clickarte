package com.clickarte.crm.Product.Price;

import java.math.BigDecimal;
import com.clickarte.crm.Product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "ProductPrices")
public record Price(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        String intervalQuantity, BigDecimal unitPrice, BigDecimal pricePerSquareMeter,
        @ManyToOne @JoinColumn(name = "product_id", nullable = false) Product product) {

}
