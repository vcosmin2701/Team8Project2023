package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {
  @Inject
  BookBean bookBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/components/AdminPageComponents/addBook.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String category = request.getParameter("category");
    int stock = Integer.parseInt(request.getParameter("stock"));
    String isbn = request.getParameter("isbn");
    Part filePart = request.getPart("file");
    String fileName = filePart.getSubmittedFileName();
    String fileType = filePart.getContentType();
    long fileSize = filePart.getSize();
    byte[] fileContent = new byte[(int) fileSize];
    filePart.getInputStream().read(fileContent);

    BookDto bookDto = new BookDto(null, title, author, category, stock, isbn);
    Long id = bookBean.addBook(bookDto);
    bookBean.addPhotoToBook(id, fileName, fileType, fileContent);

    response.sendRedirect(request.getContextPath() + "/BooksPage");
  }
}
