package com.clickarte.crm.utils.converters;

import com.clickarte.crm.dtos.product.CreateProductDto;
import com.clickarte.crm.dtos.product.DetailProductDto;
import com.clickarte.crm.dtos.product.ListProductDto;
import com.clickarte.crm.entities.Group;
import com.clickarte.crm.entities.Product;

public class ProductConverter {

    public static final Product createProductDtoToProduct(CreateProductDto createProduct,
            Group group) {
        var newProduct = new Product();

        newProduct.setSize(createProduct.size());
        newProduct.setTypeOfPrice(createProduct.typeOfPrice());
        newProduct.setTypeOfFinish(createProduct.typeOfFinish());
        newProduct.setGroup(group);
        return newProduct;
    }

    public static final DetailProductDto productToResponseCreatedProductDto(Product product) {
        return new DetailProductDto(product.getId(), product.getSize(), product.getTypeOfFinish(),
                product.getTypeOfPrice(), GroupConverter.groupToDetailGroupDto(product.getGroup()));
    }

    public static final ListProductDto productToListProductDto(Product product) {
        return new ListProductDto(product.getId(), product.getSize(), product.getTypeOfFinish(),
                product.getTypeOfPrice(), product.getGroup().getId());
    }

}
