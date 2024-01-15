package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.common.BorrowedBookDto;
import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.ejb.BorrowedBookBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.entities.BorrowedBook;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

import java.io.IOException;

@WebServlet(name = "AddBorrowedBook", value = "/AddBorrowedBook")
public class AddBorrowedBook extends HttpServlet {

    @Inject
    UsersBean usersBean;
    @Inject
    BorrowedBookBean borrowedBookBean;
    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdString = request.getParameter("bookId");
        String userLegitimationString = request.getParameter("userLegitimation");

        Long userId=usersBean.findUserIdByLegitimationNumber(Long.parseLong(userLegitimationString));
        Long bookId = Long.parseLong(bookIdString);
        int loanPeriod = Integer.parseInt(request.getParameter("loanPeriodOption"));

        Date borrowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.MONTH, loanPeriod);
        Date returnDate = calendar.getTime();
        
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto(null, bookId, userId, borrowDate, returnDate, "borrowed", loanPeriod);

        borrowedBookBean.addBorrowedBook(borrowedBookDto);
        BookDto book =  bookBean.findBookById(bookId);
        book.setStock(book.getStock()-1);
        bookBean.updateBook(book);


        response.sendRedirect(request.getContextPath() + "/MainPage");


    }
}
