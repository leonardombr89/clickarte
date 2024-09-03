package com.clickarte.crm.dtos.fixPrice;

import java.math.BigDecimal;

import com.clickarte.crm.dtos.price.DetailPriceDto;

public record DetailFixPriceDto(Long id, BigDecimal value, DetailPriceDto price) {

}
