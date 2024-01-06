package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.entities.UserRequest;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class UserRequestsBean {
  private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
  @Inject
  UsersBean usersBean;

  @Inject
  PasswordBean passwordBean;

  @PersistenceContext
  EntityManager entityManager;

  public void addRequestUser(UserDto userDto) {
    LOG.info("Adding user request for email: " + userDto.getEmail());

    UserRequest userRequest = convertToUserRequest(userDto);
    entityManager.persist(userRequest);
  }

  public Optional<UserRequest> findUserRequestByEmail(String email) {
    LOG.info("Finding user request by email: " + email);
    return entityManager
      .createQuery("SELECT u FROM UserRequest u WHERE u.email = :email", UserRequest.class)
      .setParameter("email", email)
      .getResultStream()
      .findFirst();
  }

  public boolean activateUser(String email) {
    LOG.info("Activating user for email: " + email);

    Optional<UserRequest> userRequestOptional = findUserRequestByEmail(email);
    return userRequestOptional
      .filter(userRequest -> !userRequest.getIsActivated())
      .map(userRequest -> {
        userRequest.setIsActivated(true);
        usersBean.addUser(convertToUserDto(userRequest));
        return true;
      })
      .orElseThrow(IllegalArgumentException::new);
  }

  private UserRequest convertToUserRequest(UserDto userDto) {
    UserRequest userRequest = new UserRequest();
    userRequest.setFirstName(userDto.getFirstName());
    userRequest.setLastName(userDto.getLastName());
    userRequest.setEmail(userDto.getEmail());
    userRequest.setPassword(passwordBean.convertToSha256(userDto.getPassword()));
    return userRequest;
  }

  private UserDto convertToUserDto(UserRequest userRequest) {
    return new UserDto(
      userRequest.getFirstName(),
      userRequest.getLastName(),
      userRequest.getEmail(),
      userRequest.getPassword(),
      userRequest.getPassword());

  }
}
