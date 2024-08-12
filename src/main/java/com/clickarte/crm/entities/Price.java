package com.clickarte.crm.entities;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "ProductPrices")
public class Price {
        private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        private String intervalQuantity;
        private BigDecimal unitPrice;
        private BigDecimal pricePerSquareMeter;
        private @ManyToOne @JoinColumn(name = "product_id", nullable = false) Product product;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getIntervalQuantity() {
                return intervalQuantity;
        }

        public void setIntervalQuantity(String intervalQuantity) {
                this.intervalQuantity = intervalQuantity;
        }

        public BigDecimal getUnitPrice() {
                return unitPrice;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
                this.unitPrice = unitPrice;
        }

        public BigDecimal getPricePerSquareMeter() {
                return pricePerSquareMeter;
        }

        public void setPricePerSquareMeter(BigDecimal pricePerSquareMeter) {
                this.pricePerSquareMeter = pricePerSquareMeter;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

}
