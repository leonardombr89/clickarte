package com.clickarte.crm.dtos.meterPrice;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;

public record CreateMeterPriceDto(@NotEmpty String type, @NotEmpty BigDecimal value,
        @NotEmpty BigDecimal maxValue, @NotEmpty BigDecimal minValue,
        @NotEmpty BigDecimal maxHeight, @NotEmpty BigDecimal maxWidth) {
}
