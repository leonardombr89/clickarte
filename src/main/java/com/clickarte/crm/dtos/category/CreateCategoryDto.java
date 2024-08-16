package com.clickarte.crm.dtos.category;

import jakarta.validation.constraints.NotEmpty;

public record CreateCategoryDto(@NotEmpty String name, @NotEmpty String description) {

}
