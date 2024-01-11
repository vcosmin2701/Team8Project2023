package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserRequest {
  private Long userId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private boolean isActivated;

  private Long legitimationNumber;

  @Id
  @GeneratedValue
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public Long getLegitimationNumber() {
    return legitimationNumber;
  }

  public void setLegitimationNumber(Long legitimationNumber) {
    this.legitimationNumber = legitimationNumber;
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

  @Basic
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

  public boolean getIsActivated() {
    return isActivated;
  }

  public void setIsActivated(boolean isActivated) {
    this.isActivated = isActivated;
  }
}
