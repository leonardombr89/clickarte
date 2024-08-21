package com.clickarte.crm.utils.converters;

import org.springframework.validation.FieldError;
import com.clickarte.crm.dtos.expections.ValidateErrosDataDto;

public class FieldErrorConverter {

    public static final ValidateErrosDataDto fieldErrorToValidateErrosDataDto(
            FieldError fieldError) {
        return new ValidateErrosDataDto(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
