package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/components/AdminPageComponents/addBookPopup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String isbn = request.getParameter("isbn");

        BookDto bookDto = new BookDto(null, title, author, category, stock, isbn);
        bookBean.addBook(bookDto);

        response.sendRedirect(request.getContextPath()+"/BooksPage");
    }
}