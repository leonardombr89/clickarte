package com.clickarte.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeMetro {
    SQUARE("Quadrado"), LINEAR("Linear");

    private final String value;
}
