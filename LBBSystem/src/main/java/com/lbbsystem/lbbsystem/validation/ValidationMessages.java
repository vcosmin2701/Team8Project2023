package com.lbbsystem.lbbsystem.validation;

public class ValidationMessages {
  public final static String NameRegex  = "^[^0-9!?@#$%^&*>()<+=\\[\\]{}:\"'.,/\\\\~/]*$";
  public final static String FirstNameErrorMessage = "FirstName cannot contain numbers.";
  public final static String LastNameErrorMessage = "LastName cannot contain numbers.";
  public final static String FirstNameLengthErrorMessage = "FirstName should be at least 2 characters long.";
  public final static String LastNameLengthErrorMessage = "LastName should be at least 2 characters long.";
  public final static String EmailRegex = "^[a-zA-Z]+\\.[a-zA-Z]+[0-9]*@ulbsibiu\\.ro$";
  public final static String EmailErrorMessage = "Invalid email format.";
  public final static String PasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\\[\\]:;<>,?/~_+\\-=|\\\\]).{8,32}$";
  public final static String PasswordErrorMessage = "Invalid password format";
}
