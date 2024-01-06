package com.lbbsystem.lbbsystem.common;

import com.lbbsystem.lbbsystem.validation.PasswordMatches;
import com.lbbsystem.lbbsystem.validation.UniqueEmail;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import static com.lbbsystem.lbbsystem.validation.ValidationMessages.*;

@PasswordMatches
public class UserDto {
  @Size(min = 2, message = FirstNameLengthErrorMessage)
  @Pattern(regexp = NameRegex, message = FirstNameErrorMessage)
  private String firstName;

  @Size(min = 2, message = LastNameLengthErrorMessage)
  @Pattern(regexp = NameRegex, message = LastNameErrorMessage)
  private String lastName;

  @Pattern(regexp = EmailRegex, message = EmailErrorMessage)
  @UniqueEmail
  private String email;

  @Pattern(regexp = PasswordRegex, message = PasswordErrorMessage)
  private String password;

  private String confirmPassword;

  public UserDto(String firstName, String lastName, String email, String password, String confirmPassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
