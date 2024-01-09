package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Principal;

@WebServlet(name = "AccountInfo", value = "/AccountInfo")
public class AccountInfo extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal user = request.getUserPrincipal();
        String userEmail = user.getName();
        UserDto u = usersBean.findUserByEmail(userEmail);
        request.setAttribute("FirstName", u.getFirstName());
        request.getRequestDispatcher("/WEB-INF/pages/accountInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
}