package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.ejb.UserGroupsBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
        RoleConstants.ADMIN,
        RoleConstants.ASSISTANT,
        RoleConstants.DEPARTAMENT_HEAD,
        RoleConstants.STUDENT
}))
@WebServlet(name = "CheckOut", value = "/CheckOut")
public class CheckOut extends HttpServlet {
    @Inject
    BookBean bookBean;

    @Inject
    UserGroupsBean userGroupsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BookDto book = bookBean.findBookById(Long.parseLong(id));

        request.setAttribute("book", book);

        String principalName = request.getUserPrincipal().getName();

        UserRole userRole = userGroupsBean.findUserRoleByEmail(principalName);

        request.setAttribute("userRole", userRole);

        request.getRequestDispatcher("/WEB-INF/pages/checkOut.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
