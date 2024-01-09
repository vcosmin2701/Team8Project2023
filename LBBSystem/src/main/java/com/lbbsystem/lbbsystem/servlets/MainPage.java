package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
  RoleConstants.ADMIN,
  RoleConstants.ASSISTANT,
  RoleConstants.DEPARTAMENT_HEAD,
  RoleConstants.STUDENT
}))
@WebServlet(name = "MainPage", value = "/MainPage")
public class MainPage extends HttpServlet {
  @Inject
  BookBean bookBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<BookDto> books = bookBean.findAllBooks();
    request.setAttribute("books", books);
    request.getRequestDispatcher("/WEB-INF/pages/mainPage.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
