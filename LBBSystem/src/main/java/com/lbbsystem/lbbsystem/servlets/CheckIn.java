package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.common.BorrowedBookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import com.lbbsystem.lbbsystem.ejb.BorrowedBookBean;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
        RoleConstants.ADMIN,
        RoleConstants.ASSISTANT,
        RoleConstants.DEPARTAMENT_HEAD,
        RoleConstants.STUDENT
}))
@WebServlet(name = "CheckIn", value = "/CheckIn")
public class CheckIn extends HttpServlet {
    @Inject
    BorrowedBookBean borrowedBookBean;
    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/checkIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdParam = request.getParameter("bookId");
        if (bookIdParam == null || bookIdParam.isEmpty()) {
            request.setAttribute("errorMessage", "Book ID is required.");
            request.getRequestDispatcher("/WEB-INF/components/AccountInfoComponents/borrowedBooks.jsp").forward(request, response);
            return;
        }

        Long bookId = Long.parseLong(bookIdParam);
        BookDto book =  bookBean.findBookById(bookId);


        BorrowedBookDto borrowedBook = borrowedBookBean.findBorrowedBookByBookId(bookId);
        if (borrowedBook == null) {
            request.setAttribute("errorMessage", "No borrowed book found with the provided ID.");
            request.getRequestDispatcher("/WEB-INF/components/AccountInfoComponents/borrowedBooks.jsp").forward(request, response);
            return;
        }
        book.setStock(book.getStock()+1);
        bookBean.updateBook(book);
        borrowedBook.setStatus("returned");
        borrowedBook.setReturnDate(new Date());
        borrowedBookBean.updateBorrowedBook(borrowedBook);
        response.sendRedirect(request.getContextPath() + "/AccountInfo");
    }
}
