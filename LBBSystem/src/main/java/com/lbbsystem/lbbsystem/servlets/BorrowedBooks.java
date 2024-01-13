package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.annotation.security.DeclareRoles;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
@WebServlet(name = "BorrowedBooks", value = "/BorrowedBooks")
public class BorrowedBooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "Loan");
        request.setAttribute("firstColumn", "Username");
        request.setAttribute("secondColumn", "Book");
        request.setAttribute("thirdColumn", "Period of loan");
        request.setAttribute("fourColumn", "Status");

        request.getRequestDispatcher("/WEB-INF/pages/adminPages/borrowedBooks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
