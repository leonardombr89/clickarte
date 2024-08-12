package com.clickarte.crm.Product.Category;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import com.clickarte.crm.Product.Category.Group.Group;



@Entity
@Table(name = "Categories")
public record Category(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id, String name,
        String description, @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY) List<Group> groups) {
}
