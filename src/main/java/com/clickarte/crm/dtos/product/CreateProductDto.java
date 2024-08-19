package com.clickarte.crm.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateProductDto(@NotEmpty @NotBlank String size, @NotEmpty String typeOfFinish,
                @NotEmpty @NotEmpty String typeOfPrice, @NotEmpty Long groupId) {

}
