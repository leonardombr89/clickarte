package com.clickarte.crm.utils.converters;

import com.clickarte.crm.dtos.fixPrice.CreateFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.DetailFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.ListFixPriceDto;
import com.clickarte.crm.entities.FixPrice;
import com.clickarte.crm.entities.Price;

public class FixPriceConverter {

    public static final FixPrice createFixPriceDtoToFixPrice(CreateFixPriceDto createFIxPriceDto,
            Price price) {
        return new FixPrice(null, createFIxPriceDto.value(), price);
    }


    public static final DetailFixPriceDto fixPriceToDetailFixPriceDto(FixPrice fixPrice) {
        var price = fixPrice.getPrice();
        var detailPrice = PriceConverter.priceToDetailPriceDto(price);
        return new DetailFixPriceDto(fixPrice.getId(), fixPrice.getValue(), detailPrice);
    }

    public static final ListFixPriceDto fixPriceToListFixPriceDto(FixPrice fixPrice) {
        return new ListFixPriceDto(fixPrice.getId(), fixPrice.getValue(),
                fixPrice.getPrice().getId());
    }
}
