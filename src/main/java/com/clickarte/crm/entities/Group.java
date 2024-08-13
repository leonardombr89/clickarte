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


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GroupCategory")
public class Group {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private @ManyToOne @JoinColumn(name = "category_id", nullable = false) Category category;
    private @OneToMany(mappedBy = "group", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY) List<Product> products;
}
