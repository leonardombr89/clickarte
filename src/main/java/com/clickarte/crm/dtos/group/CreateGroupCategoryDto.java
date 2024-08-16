package com.clickarte.crm.dtos.group;

import jakarta.validation.constraints.NotEmpty;

public record CreateGroupCategoryDto(@NotEmpty String name, @NotEmpty Long categoryId) {


}
