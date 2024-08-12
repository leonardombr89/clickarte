package com.clickarte.crm.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Products")
public class Product {
        private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        private String size;
        private String typeOfFinish;
        private String typeOfPrice;
        private @ManyToOne @JoinColumn(name = "group_id", nullable = false) Group group;
        private @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
                        fetch = FetchType.LAZY) List<Price> prices;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getSize() {
                return size;
        }

        public void setSize(String size) {
                this.size = size;
        }

        public String getTypeOfFinish() {
                return typeOfFinish;
        }

        public void setTypeOfFinish(String typeOfFinish) {
                this.typeOfFinish = typeOfFinish;
        }

        public String getTypeOfPrice() {
                return typeOfPrice;
        }

        public void setTypeOfPrice(String typeOfPrice) {
                this.typeOfPrice = typeOfPrice;
        }

        public Group getGroup() {
                return group;
        }

        public void setGroup(Group group) {
                this.group = group;
        }

        public List<Price> getPrices() {
                return prices;
        }

        public void setPrices(List<Price> prices) {
                this.prices = prices;
        }

}
