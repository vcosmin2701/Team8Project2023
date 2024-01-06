package com.lbbsystem.lbbsystem.emailService;

import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static com.lbbsystem.lbbsystem.emailService.EmailConfiguration.*;

@Stateless
public class EmailService {
  private static final Logger LOG = Logger.getLogger(EmailService.class.getName());

  public void sendEmail(EmailMessage emailMessage) {
    LOG.info("Sending email to: " + emailMessage.getRecipients());

    Properties properties = setupEmailProperties();
    Session session = Session.getInstance(properties,
      new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(USERNAME, PASSWORD);
        }
      });

    try {
      Message message = createEmailMessage(session, emailMessage);
      Transport.send(message);
      LOG.info("Email sent successfully");
    } catch (MessagingException e) {
      LOG.log(Level.SEVERE, "Error sending email", e);
    }
  }

  private Message createEmailMessage(Session session, EmailMessage emailMessage) throws MessagingException {
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(USERNAME));
    message.setRecipients(Message.RecipientType.TO, convertAddresses(emailMessage.getRecipients()));
    message.setSubject(emailMessage.getSubject());
    message.setContent(emailMessage.getContent(), "text/html; charset=utf-8");
    return message;
  }

  private InternetAddress[] convertAddresses(String[] addresses) {
    return Stream.of(addresses).map(address -> {
      try {
        return new InternetAddress(address, false);
      } catch (AddressException e) {
        LOG.log(Level.SEVERE, "Invalid email address: " + address, e);
        return null;
      }
    }).filter(Objects::nonNull).toArray(InternetAddress[]::new);
  }

  private Properties setupEmailProperties() {
    Properties properties = new Properties();
    properties.put("mail.smtp.host", SMTP_SERVER);
    properties.put("mail.smtp.port", SMTP_PORT);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.ssl.trust", SMTP_SERVER);
    return properties;
  }
}
