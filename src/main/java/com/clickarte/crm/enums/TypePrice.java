package com.clickarte.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypePrice {

    QUANTITY("Quantidade"), METER("Metro"), FIX("Fixo"), DEMAND("Demanda");

    private final String value;

}
