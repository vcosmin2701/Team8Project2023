package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.UserGroupsBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.emailService.ContactSupportEmail;
import com.lbbsystem.lbbsystem.emailService.EmailMessage;
import com.lbbsystem.lbbsystem.emailService.EmailService;
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
import java.security.Principal;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {
        RoleConstants.ASSISTANT,
        RoleConstants.DEPARTAMENT_HEAD,
        RoleConstants.STUDENT
}))
@WebServlet(name = "ContactSupport", value = "/ContactSupport")
public class ContactSupport extends HttpServlet {
    @Inject
    private EmailService emailService;
    @Inject
    UsersBean usersBean;

    @Inject
    UserGroupsBean userGroupsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/contactSupport.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal user = request.getUserPrincipal();
        String userEmail = user.getName();
        UserDto u = usersBean.findUserByEmail(userEmail);
        String message = request.getParameter("message-2");
        EmailMessage emailMessage = new ContactSupportEmail();
        emailMessage.setRecipients(userGroupsBean.findAllAdmins());
        emailMessage.setSubject();
        emailMessage.setContent(u.getFirstName() + " " + u.getLastName(), userEmail, message);
        emailService.sendEmail(emailMessage);
        request.setAttribute("successMessage", "Message sent successfully.");
        request.getRequestDispatcher("/WEB-INF/pages/contactSupport.jsp").forward(request, response);
    }
}
