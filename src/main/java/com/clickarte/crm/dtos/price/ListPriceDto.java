package com.clickarte.crm.dtos.price;

import java.math.BigDecimal;

public record ListPriceDto(Long id, Long productId, String intervalQuantity, BigDecimal unitPrice,
        BigDecimal pricePerSquareMeter) {

}
