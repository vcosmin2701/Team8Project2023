package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.common.BorrowedBookDto;
import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.ejb.BorrowedBookBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.entities.BorrowedBook;
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

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
  RoleConstants.ADMIN,
  RoleConstants.ASSISTANT,
  RoleConstants.DEPARTAMENT_HEAD,
  RoleConstants.STUDENT
}))
@WebServlet(name = "AccountInfo", value = "/AccountInfo")
public class AccountInfo extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Inject
    BorrowedBookBean borrowedBookBean;

    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal user = request.getUserPrincipal();
        String userEmail = user.getName();
        UserDto u = usersBean.findUserByEmail(userEmail);
        request.setAttribute("FirstName", u.getFirstName());
        request.setAttribute("LastName", u.getLastName());
        request.setAttribute("Email",userEmail);
        request.setAttribute("LegitimationNumber",u.getLegitimationNumber());

        request.setAttribute("user", u);
        Long userId= usersBean.findUserIdByLegitimationNumber(u.getLegitimationNumber());
        List<BorrowedBookDto> borrowedBooks = borrowedBookBean.findBorrowedBooksByUserIdAndStatus(userId,"borrowed");
        List<BookDto> books = new ArrayList<>();

        for (BorrowedBookDto borrowedBookDto : borrowedBooks) {
            BookDto book = bookBean.findBookById(borrowedBookDto.getBookId());
            books.add(book);
        }

        request.setAttribute("borrowedBooks", borrowedBooks);
        request.setAttribute("books", books);

        request.getRequestDispatcher("/WEB-INF/pages/accountInfo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
}