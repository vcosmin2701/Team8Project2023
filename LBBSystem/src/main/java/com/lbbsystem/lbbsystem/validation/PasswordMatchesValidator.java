package com.lbbsystem.lbbsystem.validation;

import com.lbbsystem.lbbsystem.common.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDto> {
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(UserDto user, ConstraintValidatorContext context) {
    return user.getPassword().equals(user.getConfirmPassword());
  }
}
