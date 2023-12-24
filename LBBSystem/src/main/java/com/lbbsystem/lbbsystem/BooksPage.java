package com.lbbsystem.lbbsystem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BooksPage", value = "/BooksPage")
public class BooksPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "Book");
        request.setAttribute("firstColumn", "Item");
        request.setAttribute("secondColumn", "Category");
        request.setAttribute("thirdColumn", "Author");
        request.getRequestDispatcher("/WEB-INF/pages/adminPages/booksPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
