package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.entities.User;
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

  private void assignGroupToUser(String email) {
    LOG.info("assignGroupToUser");

    UserGroup userGroup = new UserGroup();
    userGroup.setEmail(email);
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

  public UserDto findUserByEmail(String email) {
    LOG.info("Finding user by email: " + email);
    User user = entityManager
            .createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
            .setParameter("email", email)
            .getResultStream()
            .findFirst().get();

    return convertUserToUserDto(user);
  }

  private UserDto convertUserToUserDto(User user) {
    return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPassword());
}
}