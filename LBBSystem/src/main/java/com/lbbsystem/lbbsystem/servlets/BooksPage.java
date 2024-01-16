package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "BooksPage", value = "/BooksPage")
public class BooksPage extends HttpServlet {
  @Inject
  BookBean bookBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("createEntity", "Book");
    request.setAttribute("firstColumn", "Book name");
    request.setAttribute("secondColumn", "Stock");
    request.setAttribute("thirdColumn", "Category");
    request.setAttribute("fourColumn", "Author");

    List<BookDto> books = bookBean.findAllBooks();
    request.setAttribute("books", books);
    request.getRequestDispatcher("/WEB-INF/pages/adminPages/booksPage.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
