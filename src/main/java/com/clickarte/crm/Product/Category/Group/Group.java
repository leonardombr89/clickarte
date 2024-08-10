package com.clickarte.crm.Product.Category.Group;


import java.util.List;
import com.clickarte.crm.Product.Product;
import com.clickarte.crm.Product.Category.Category;
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
@Table(name = "GroupCategory")
public record Group(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id, String name,
        @ManyToOne @JoinColumn(name = "category_id", nullable = false) Category category,
        @OneToMany(mappedBy = "group", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY) List<Product> products) {

}
