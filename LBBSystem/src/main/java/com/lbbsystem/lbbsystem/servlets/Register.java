package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.UserRequestsBean;
import com.lbbsystem.lbbsystem.entities.User;
import com.lbbsystem.lbbsystem.utilities.EncryptionUtil;
import com.lbbsystem.lbbsystem.emailService.ActivationEmail;
import com.lbbsystem.lbbsystem.emailService.EmailMessage;
import com.lbbsystem.lbbsystem.emailService.EmailService;
import com.lbbsystem.lbbsystem.utilities.LegitimationNumberGenerator;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
  private static final Logger LOG = Logger.getLogger(Register.class.getName());
  private static final String REGISTER_PAGE = "/WEB-INF/pages/register.jsp";

  @Inject
  private UserRequestsBean userRequestsBean;

  @Inject
  private Validator validator;
  @Inject
  private EncryptionUtil encryptionUtil;
  @Inject
  private EmailService emailService;
  @Inject
  LegitimationNumberGenerator legitimationNumberGenerator;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher(REGISTER_PAGE).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserDto userDto = createUserDto(request);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

    if (!violations.isEmpty()) {
      request.setAttribute("errors", extractErrorMessages(violations));
      request.getRequestDispatcher(REGISTER_PAGE).include(request, response);
      return;
    }

    try {
      processRegistration(emailService, userDto, request);
    } catch (Exception e) {
      LOG.log(Level.SEVERE, "Error processing registration", e);
      request.setAttribute("errorMessage", "An error occurred during registration.");
      request.getRequestDispatcher(REGISTER_PAGE).include(request, response);
      return;
    }

    request.setAttribute("validUser", true);
    request.getRequestDispatcher(REGISTER_PAGE).include(request, response);
  }

  private UserDto createUserDto(HttpServletRequest request) {
    Long legitimationNumber = legitimationNumberGenerator.generateUniqueLegitimationNumber();

    return new UserDto(
            request.getParameter("firstName"),
            request.getParameter("lastName"),
            request.getParameter("email"),
            request.getParameter("password"),
            request.getParameter("confirmPassword"),
            legitimationNumber
    );
  }


  private List<String> extractErrorMessages(Set<ConstraintViolation<UserDto>> violations) {
    List<String> errors = new ArrayList<>();
    for (ConstraintViolation<UserDto> violation : violations) {
      errors.add(violation.getMessage());
    }
    return errors;
  }

  private void processRegistration(EmailService emailService, UserDto userDto, HttpServletRequest request) throws Exception {
    String encryptedEmail = encryptionUtil.encrypt(userDto.getEmail());
    String activationLink = String.format("http://localhost:8080/LBBSystem-1.0-SNAPSHOT/ActivationAccount?email=%s",
            URLEncoder.encode(encryptedEmail, StandardCharsets.UTF_8));

    EmailMessage emailMessage = new ActivationEmail();
    emailMessage.setRecipients(new String[]{userDto.getEmail()});
    emailMessage.setSubject();
    emailMessage.setContent(userDto.getFirstName(), userDto.getLastName(), activationLink);

    emailService.sendEmail(emailMessage);
    userRequestsBean.addRequestUser(userDto);
}
}