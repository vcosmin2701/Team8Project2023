package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.common.BookLoanDto;
import com.lbbsystem.lbbsystem.ejb.BookLoanBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoanBooks", value = "/LoanBooks")
public class LoanBooks extends HttpServlet {
    @Inject
    BookLoanBean bookLoanBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookLoanDto> loans = bookLoanBean.findAllBookLoans();
        request.setAttribute("loans", loans);
        request.getRequestDispatcher("/WEB-INF/components/AdminPageComponents/loanItemsTable.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}