package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
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
@WebServlet(name = "AccountInfo", value = "/AccountInfo")
public class AccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/accountInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
