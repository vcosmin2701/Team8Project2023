package com.lbbsystem.lbbsystem.servlets.AdminCRUD;

import com.lbbsystem.lbbsystem.common.UserDto;
import com.lbbsystem.lbbsystem.ejb.PasswordBean;
import com.lbbsystem.lbbsystem.ejb.UsersBean;
import com.lbbsystem.lbbsystem.emailService.AccountDetailsEmail;
import com.lbbsystem.lbbsystem.emailService.EmailMessage;
import com.lbbsystem.lbbsystem.emailService.EmailService;
import com.lbbsystem.lbbsystem.roles.RoleConstants;
import com.lbbsystem.lbbsystem.roles.UserRole;
import com.lbbsystem.lbbsystem.utilities.LegitimationNumberGenerator;
import com.lbbsystem.lbbsystem.utilities.PasswordGenerator;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "AddUser", value = "/AddUser")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {RoleConstants.ADMIN}))
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
  @Inject
  Validator validator;

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

    UserDto userDto = new UserDto(firstName, lastName, email, password, password, legitimationNumber, role);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

    if (!violations.isEmpty()) {
      request.setAttribute("errors", extractErrorMessages(violations));
      request.getRequestDispatcher("/WEB-INF/components/AdminPageComponents/addUserPopup.jsp").include(request, response);
      return;
    }
    userDto.setPassword(hashedPassword);
    userDto.setConfirmPassword(hashedPassword);
    usersBean.addUser(userDto, role);

    EmailMessage emailMessage = new AccountDetailsEmail();
    emailMessage.setRecipients(new String[]{email});
    emailMessage.setSubject();
    emailMessage.setContent(firstName, lastName, email, password, legitimationNumber.toString(), role);
    emailService.sendEmail(emailMessage);

    response.sendRedirect(request.getContextPath() + "/AdminUsers");
  }

  private List<String> extractErrorMessages(Set<ConstraintViolation<UserDto>> violations) {
    List<String> errors = new ArrayList<>();
    for (ConstraintViolation<UserDto> violation : violations) {
      errors.add(violation.getMessage());
    }
    return errors;
  }
}
