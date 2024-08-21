package com.clickarte.crm.utils.converters;

import com.clickarte.crm.dtos.price.CreatePriceDto;
import com.clickarte.crm.dtos.price.DetailPriceDto;
import com.clickarte.crm.dtos.price.ListPriceDto;
import com.clickarte.crm.entities.Price;
import com.clickarte.crm.entities.Product;

public class PriceConverter {

    public static final Price createPriceDtoToPrice(CreatePriceDto createPrice, Product product) {
        return new Price(null, createPrice.intervalQuantity(), createPrice.unitPrice(),
                createPrice.pricePerSquareMeter(), product);

    }

    public static final DetailPriceDto priceToDetailPriceDto(Price price) {
        var product = price.getProduct();
        var detailProduct = ProductConverter.productToResponseCreatedProductDto(product);
        var detailPrice =
                new DetailPriceDto(price.getId(), product.getId(), price.getIntervalQuantity(),
                        price.getUnitPrice(), price.getPricePerSquareMeter(), detailProduct);
        return detailPrice;


    }

    public static ListPriceDto priceToListPriceDto(Price price) {
        return new ListPriceDto(price.getId(), price.getProduct().getId(),
                price.getIntervalQuantity(), price.getUnitPrice(), price.getPricePerSquareMeter());

    }
}
