package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteBook", value = "/DeleteBook")
public class DeleteBook extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        if(bookId != null) {
            bookBean.deleteBook(Long.parseLong(bookId));
        }
        response.sendRedirect(request.getContextPath()+"/BooksPage");
    }
}