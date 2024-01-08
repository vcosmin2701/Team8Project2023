package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Book", value = "/Book")
public class Book extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> books = bookBean.findAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/WEB-INF/pages/adminPages/booksPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}