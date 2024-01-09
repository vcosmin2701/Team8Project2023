package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.entities.UserGroup;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.logging.Logger;

@Stateless
public class UsersBean {
  private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
  @PersistenceContext
  EntityManager entityManager;

  public void addUser(UserDto userDto, UserRole userRole) {
    LOG.info("addUser");

    User user = convertUserDtoToUser(userDto);
    entityManager.persist(user);
    assignGroupToUser(user.getEmail(), userRole);
  }

  private void assignGroupToUser(String email, UserRole userRole) {
    LOG.info("assignGroupToUser");

    UserGroup userGroup = new UserGroup();
    userGroup.setEmail(email);
    userGroup.setUserGroup(userRole);
    entityManager.persist(userGroup);
  }

  private User convertUserDtoToUser(UserDto userDto) {
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());

    return user;
  }
}
