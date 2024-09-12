package com.clickarte.crm.utils.converters;

import com.clickarte.crm.dtos.meterPrice.CreateMeterPriceDto;
import com.clickarte.crm.dtos.meterPrice.DetailMeterPriceDto;
import com.clickarte.crm.entities.MeterPrice;

public class MeterPriceConverter {


    public static MeterPrice CreateMeterPriceDtoToMeterPrice(
            CreateMeterPriceDto createMeterPriceDto) {
        return new MeterPrice(null, createMeterPriceDto.type(), createMeterPriceDto.value(),
                createMeterPriceDto.maxValue(), createMeterPriceDto.minValue(),
                createMeterPriceDto.maxHeight(), createMeterPriceDto.maxWidth());
    }

    public static DetailMeterPriceDto meterPriceToDetailMeterPriceDt(MeterPrice meterPrice) {
        return new DetailMeterPriceDto();
    }
}
