package com.clickarte.crm.dtos.price;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;

public record CreatePriceDto(@NotNull String intervalQuantity, @NotNull BigDecimal unitPrice,
        @NotNull BigDecimal pricePerSquareMeter, @NotNull Long productId) {

}
