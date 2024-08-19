package com.clickarte.crm.dtos.product;

import com.clickarte.crm.dtos.group.DetailGroupDto;

public record DetailProductDto(Long Id, String size, String typeOfFinish, String typeOfPrice,
                DetailGroupDto group) {

}
