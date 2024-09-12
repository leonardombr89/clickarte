package com.clickarte.crm.utils.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPaths {

    public static final String CATEGORY_BASE_PATH = "category";
    public static final String CATEGORY_BY_ID = CATEGORY_BASE_PATH + "/{id}";

    public static final String GROUP_BASE_PATH = "group";
    public static final String GROUP_BY_ID = GROUP_BASE_PATH + "/{id}";

    public static final String PRODUCT_BASE_PATH = "product";
    public static final String PRODUCT_BY_ID = PRODUCT_BASE_PATH + "/{id}";

    public static final String PRICE_BASE_PATH = "price";
    public static final String PRICE_BY_ID = PRICE_BASE_PATH + "/{id}";

    public static final String FIX_PRICE_BASE_PATH = "fixprice";
    public static final String FIX_PRICE_BY_ID = FIX_PRICE_BASE_PATH + "/{id}";

    public static final String METER_PRICE_BASE_PATH = "meter-prices";
    public static final String METER_PRICE_BY_ID = METER_PRICE_BASE_PATH + "/{id}";



}
