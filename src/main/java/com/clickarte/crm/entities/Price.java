package com.clickarte.crm.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductPrices")
public class Price {
        private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        private String intervalQuantity;
        private BigDecimal unitPrice;
        private BigDecimal pricePerSquareMeter;
        private @ManyToOne @JoinColumn(name = "product_id", nullable = false) Product product;


}
