package com.clickarte.crm.dtos.price;

import java.math.BigDecimal;
import com.clickarte.crm.dtos.product.DetailProductDto;

public record DetailPriceDto(Long id, Long productId, String intervalQuantity, BigDecimal unitPrice,
        BigDecimal pricePerSquareMeter, DetailProductDto product) {


}
