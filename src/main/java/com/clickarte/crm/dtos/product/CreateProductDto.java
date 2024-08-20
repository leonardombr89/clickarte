package com.clickarte.crm.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductDto(@NotBlank String size, @NotBlank String typeOfFinish,
                @NotBlank String typeOfPrice, @NotNull Long groupId) {

}
