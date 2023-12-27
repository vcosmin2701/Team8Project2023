package com.lbbsystem.lbbsystem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BorrowedBooks", value = "/BorrowedBooks")
public class BorrowedBooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "Loan");
        request.setAttribute("firstColumn", "User name");
        request.setAttribute("secondColumn", "Book");
        request.setAttribute("thirdColumn", "Period of loan");
        request.setAttribute("fourColumn", "Status");
        request.getRequestDispatcher("/WEB-INF/pages/adminPages/borrowedBooks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
