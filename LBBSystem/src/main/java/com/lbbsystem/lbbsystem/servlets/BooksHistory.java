package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BorrowedBookDto;
import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.BorrowedBookBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import com.lbbsystem.lbbsystem.roles.UserRole;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
        RoleConstants.ADMIN,
        RoleConstants.ASSISTANT,
        RoleConstants.DEPARTAMENT_HEAD,
        RoleConstants.STUDENT
}))
@WebServlet(name = "BooksHistory", value = "/BooksHistory")
public class BooksHistory extends HttpServlet {
    @Inject
    BorrowedBookBean borrowedBookBean;

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String principalName = request.getUserPrincipal().getName();

        UserDto u = usersBean.findUserByEmail(principalName);
        request.setAttribute("user", u);
        Long userId = usersBean.findUserIdByLegitimationNumber(u.getLegitimationNumber());

        List<BorrowedBookDto> borrowedBooksHistory = borrowedBookBean.findReturnedBooksByUserId(userId);
        request.setAttribute("borrowedBooksHistory", borrowedBooksHistory);
        request.getRequestDispatcher("/WEB-INF/pages/booksHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
