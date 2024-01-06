package com.lbbsystem.lbbsystem.servlets;


import com.lbbsystem.lbbsystem.ejb.PasswordBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
  private static final Logger LOG = Logger.getLogger(PasswordBean.class.getName());

  @Inject
  UsersBean usersBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("message", "Email or password incorrect");
    request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
  }
}
