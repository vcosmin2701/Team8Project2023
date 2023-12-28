package com.lbbsystem.lbbsystem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminUsers", value = "/AdminUsers")
public class AdminUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("createEntity", "User");
        request.setAttribute("firstColumn", "Full Name");
        request.setAttribute("secondColumn", "Email");
        request.setAttribute("thirdColumn", "Role");
        request.setAttribute("popupName", "popupAddUser");

        request.getRequestDispatcher("/WEB-INF/pages/adminPages/usersPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
