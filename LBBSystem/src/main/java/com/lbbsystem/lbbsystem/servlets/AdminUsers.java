package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "AdminUsers", value = "/AdminUsers")
public class AdminUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "User");
        request.setAttribute("firstColumn", "Full Name");
        request.setAttribute("secondColumn", "SSN");
        request.setAttribute("thirdColumn", "Email");
        request.setAttribute("fourColumn", "Role");
        request.setAttribute("popupName", "addUserPopup");
        request.setAttribute("popupEditName", "editUserPopup");

        request.getRequestDispatcher("/WEB-INF/pages/adminPages/usersPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
