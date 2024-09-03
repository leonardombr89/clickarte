package com.clickarte.crm.dtos.fixPrice;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record CreateFixPriceDto(@NotNull Long id, @NotNull BigDecimal value,
        @NotNull Long priceId) {



}
