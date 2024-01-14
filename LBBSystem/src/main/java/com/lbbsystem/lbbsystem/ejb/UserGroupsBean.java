package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Stateless
public class UserGroupsBean {
    private static final Logger LOG = Logger.getLogger(UserGroupsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public String[] findAllAdmins() {
        LOG.info("Finding all admins ");
        final UserRole ADMIN_ROLE = UserRole.ADMIN;

        List<String> adminsList = entityManager
                .createQuery("SELECT u.email FROM UserGroup u WHERE u.userGroup = :admin", String.class)
                .setParameter("admin", ADMIN_ROLE)
                .getResultList();

        String[] adminsArray = adminsList.toArray(new String[0]);

        return adminsArray;
    }

    public UserRole findUserRoleByEmail(String email) {
        LOG.info("Finding user role by email: " + email);
        return entityManager
                .createQuery("SELECT u.userGroup FROM UserGroup u WHERE u.email = :email", UserRole.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
