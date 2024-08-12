package com.clickarte.crm.Product;

import java.util.List;
import com.clickarte.crm.Product.Category.Group.Group;
import com.clickarte.crm.Product.Price.Price;
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
public record Product(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id, String size,
                String typeOfFinish, String typeOfPrice,
                @ManyToOne @JoinColumn(name = "group_id", nullable = false) Group group,
                @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
                                fetch = FetchType.LAZY) List<Price> prices) {

}
