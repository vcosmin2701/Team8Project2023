package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "AdminPage", value = "/AdminPage")
public class AdminPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/adminPages/adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
