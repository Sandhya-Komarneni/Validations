package com.example.UserInfo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {


  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.matches("^[a-zA-Z ]+$");
  }
}
