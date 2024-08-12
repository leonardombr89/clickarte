package com.clickarte.crm.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import com.clickarte.crm.dtos.category.CreateCategoryDto;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Category {


    public Category(CreateCategoryDto createCategory) {
        this.description = createCategory.description();
        this.name = createCategory.name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Group> groups;

    @Column(nullable = true)
    private Date createdAt;

    @Column(nullable = true)
    private Date updatedAt;

    @PrePersist
    public void createdAt() {
        createdAt = updatedAt = new Date();
    }

    @PreUpdate
    public void updateAt() {
        this.updatedAt = new Date();
    }


}
