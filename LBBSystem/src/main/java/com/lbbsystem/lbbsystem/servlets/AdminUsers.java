package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.UserGroupsBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "AdminUsers", value = "/AdminUsers")
public class AdminUsers extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Inject
    UserGroupsBean userGroupsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "User");
        request.setAttribute("firstColumn", "Full Name");
        request.setAttribute("secondColumn", "Legitimation Number");
        request.setAttribute("thirdColumn", "Email");
        request.setAttribute("fourColumn", "Role");

        List<UserDto> users = usersBean.findAllUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/pages/adminPages/usersPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
