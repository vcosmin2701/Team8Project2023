package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserGroup {
  private Long id;

  private String email;

  private String userGroup;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(String userGroup) {
    this.userGroup = userGroup;
  }
}
