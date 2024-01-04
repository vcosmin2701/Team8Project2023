package com.lbbsystem.lbbsystem.servlets;

import com.lbbsystem.lbbsystem.ejb.UserRequestsBean;
import com.lbbsystem.lbbsystem.utilities.EncryptionUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ActivationAccount", value = "/ActivationAccount")
public class ActivationAccount extends HttpServlet {
  private static final String ACTIVATION_MESSAGE_ATTRIBUTE = "activationMessage";
  private static final String EMAIL_PARAMETER = "email";
  private static final String LOGIN_PAGE = "/Login";
  private static final Logger LOGGER = Logger.getLogger(ActivationAccount.class.getName());

  @Inject
  UserRequestsBean userRequestsBean;

  @Inject
  EncryptionUtil encryptionUtil;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String email = request.getParameter(EMAIL_PARAMETER);
      String userEmail = encryptionUtil.decrypt(email);
      String activationMessage = userRequestsBean.activateUser(userEmail) ?
        "Your account has been successfully activated." :
        "Your account is already activated.";
      request.getSession().setAttribute(ACTIVATION_MESSAGE_ATTRIBUTE, activationMessage);
    } catch (IllegalArgumentException exception) {
      request.getSession().setAttribute(ACTIVATION_MESSAGE_ATTRIBUTE, "The email address has not been registered. Please register.");
      LOGGER.log(Level.WARNING, "Email address not registered: ", exception);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error during account activation: ", e);
    } finally {
      response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
