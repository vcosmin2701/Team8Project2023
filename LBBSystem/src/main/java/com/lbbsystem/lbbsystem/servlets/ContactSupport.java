package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.annotation.security.DeclareRoles;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
  RoleConstants.ASSISTANT,
  RoleConstants.DEPARTAMENT_HEAD,
  RoleConstants.STUDENT
}))
@WebServlet(name = "ContactSupport", value = "/ContactSupport")
public class ContactSupport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/contactSupport.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("successMessage", "Message sent successfully.");
        request.getRequestDispatcher("/WEB-INF/pages/contactSupport.jsp").forward(request, response);
    }
}
