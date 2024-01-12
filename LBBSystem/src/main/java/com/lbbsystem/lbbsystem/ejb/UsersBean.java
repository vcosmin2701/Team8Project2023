package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.entities.UserGroup;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    @Inject
    UserRequestsBean userRequestBean;

    public void addUser(UserDto userDto, UserRole userRole) {
        LOG.info("addUser");

        User user = convertUserDtoToUser(userDto);
        entityManager.persist(user);
        assignGroupToUser(user.getEmail(), userRole);
        userRequestBean.addRequestUser(userDto, true);

    }

    private void assignGroupToUser(String email, UserRole userRole) {
        LOG.info("assignGroupToUser");

        UserGroup userGroup = new UserGroup();
        userGroup.setEmail(email);
        userGroup.setUserGroup(userRole);
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

    private UserRole findUserRoleByEmail(String email) {
        TypedQuery<UserGroup> typedQuery = entityManager.createQuery("SELECT ug FROM UserGroup ug WHERE ug.email = :email", UserGroup.class)
                .setParameter("email", email);
        UserGroup userGroup = typedQuery.getSingleResult();
        return userGroup != null ? userGroup.getUserGroup() : null;
    }

    private UserDto convertUserToUserDto(User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPassword(), user.getLegitimationNumber());
    }

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = typedQuery.getResultList();
        return convertUsersToDto(users);
    }

    public List<UserDto> findAllUsersWithRole() {
        LOG.info("findAllUsers");
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = typedQuery.getResultList();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserRole role = findUserRoleByEmail(user.getEmail());
            UserDto userDto = new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPassword(), user.getLegitimationNumber(), role);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    private List<UserDto> convertUsersToDto(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPassword(), user.getLegitimationNumber());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
