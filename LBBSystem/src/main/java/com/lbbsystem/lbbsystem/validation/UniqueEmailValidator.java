package com.lbbsystem.lbbsystem.validation;

import com.lbbsystem.lbbsystem.ejb.UserRequestsBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
  @Inject
  UserRequestsBean userRequestsBean;

  @Override
  public void initialize(UniqueEmail constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    return userRequestsBean.findUserRequestByEmail(email).isEmpty();
  }
}
