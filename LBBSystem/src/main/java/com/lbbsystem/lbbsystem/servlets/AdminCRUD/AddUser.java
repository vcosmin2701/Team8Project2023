package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.PasswordBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.emailService.AccountDetailsEmail;
import com.lbbsystem.lbbsystem.emailService.EmailMessage;
import com.lbbsystem.lbbsystem.emailService.EmailService;
import com.lbbsystem.lbbsystem.roles.UserRole;
import com.lbbsystem.lbbsystem.utilities.LegitimationNumberGenerator;
import com.lbbsystem.lbbsystem.utilities.PasswordGenerator;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    @Inject
    UsersBean usersBean;
    @Inject
    EmailService emailService;
    @Inject
    PasswordGenerator passwordGenerator;
    @Inject
    LegitimationNumberGenerator legitimationNumberGenerator;
    @Inject
    PasswordBean passwordBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long legitimationNumber = legitimationNumberGenerator.generateUniqueLegitimationNumber();
        String password = passwordGenerator.generatePassword(10);

        request.setAttribute("legitimationNumber", legitimationNumber);
        request.setAttribute("password", password);
        request.getRequestDispatcher("/WEB-INF/components/AdminPageComponents/addUserPopup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        UserRole role = UserRole.valueOf(request.getParameter("role"));

        Long legitimationNumber = legitimationNumberGenerator.generateUniqueLegitimationNumber();
        String password = passwordGenerator.generatePassword(10);

        String hashedPassword = passwordBean.convertToSha256(password);

        UserDto userDto = new UserDto(firstName, lastName, email, hashedPassword, hashedPassword, legitimationNumber, role);
        usersBean.addUser(userDto, role);

        EmailMessage emailMessage = new AccountDetailsEmail();
        emailMessage.setRecipients(new String[]{email});
        emailMessage.setSubject();
        emailMessage.setContent(firstName, lastName, email, password, legitimationNumber.toString(), role);
        emailService.sendEmail(emailMessage);

        response.sendRedirect(request.getContextPath()+"/AdminUsers");
    }
}