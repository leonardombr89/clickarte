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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Products")
public class Product {

        private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        private String size;
        private String typeOfFinish;
        private String typeOfPrice;
        private @ManyToOne @JoinColumn(name = "group_id", nullable = false) Group group;
        private @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
                        fetch = FetchType.LAZY) List<Price> prices;

}
