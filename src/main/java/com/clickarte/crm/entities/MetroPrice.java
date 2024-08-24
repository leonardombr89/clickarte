package com.clickarte.crm.entities;

import java.math.BigDecimal;

import com.clickarte.crm.enums.TypeMetro;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Getter
@Setter
public class MetroPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    TypeMetro type;

    BigDecimal price;
    BigDecimal maxPrice;
    BigDecimal maxHeight;
    BigDecimal maxWidth;



}
