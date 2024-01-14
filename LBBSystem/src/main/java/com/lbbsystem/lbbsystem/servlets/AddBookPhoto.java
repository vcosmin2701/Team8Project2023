package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
@MultipartConfig
@WebServlet(name = "AddBookPhoto", value = "/AddBookPhoto")
public class AddBookPhoto extends HttpServlet {
    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId=Long.parseLong(request.getParameter("id"));
        BookDto book=bookBean.findPhotoByBookId(bookId);
        request.setAttribute("book", book);

        request.getRequestDispatcher("WEB-INF/pages/adminPages/addBookPhoto.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId=Long.parseLong(request.getParameter("book_id"));

        Part filePart= request.getPart("file");
        String fileName=filePart.getSubmittedFileName();
        String fileType= filePart.getContentType();
        long fileSize=filePart.getSize();
        byte[] fileContent=new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        bookBean.addPhotoToBook(bookId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath() + "/");
    }
}