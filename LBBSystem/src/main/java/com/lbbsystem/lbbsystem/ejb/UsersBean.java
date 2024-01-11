package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.entities.UserGroup;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
  private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
  @PersistenceContext
  EntityManager entityManager;

  public void addUser(UserDto userDto) {
    LOG.info("addUser");

    User user = convertUserDtoToUser(userDto);
    entityManager.persist(user);
  }

  private void assignGroupToUser(String email) {
    LOG.info("assignGroupToUser");

    UserGroup userGroup = new UserGroup();
    userGroup.setEmail(email);
    entityManager.persist(userGroup);
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

  public UserDto findUserByLegitimationNumber(Long legitimationNumber) {
    Optional<User> userOptional = entityManager
            .createQuery("SELECT u FROM User u WHERE u.legitimationNumber = :legitimationNumber", User.class)
            .setParameter("legitimationNumber", legitimationNumber)
            .getResultStream()
            .findFirst();

    if (userOptional.isPresent()) {
      return convertUserToUserDto(userOptional.get());
    }
    return null;
  }

  private User convertUserDtoToUser(UserDto userDto) {
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setLegitimationNumber(userDto.getLegitimationNumber());

    return user;
  }

  private UserDto convertUserToUserDto(User user) {
    return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPassword(), user.getLegitimationNumber());
}
}