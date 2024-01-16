package com.lbbsystem.lbbsystem.emailService;

import com.lbbsystem.lbbsystem.roles.UserRole;

public class AccountDetailsEmail extends EmailMessage {
    @Override
    public void setRecipients(String[] recipients) {
        if (recipients == null) {
            throw new IllegalArgumentException();
        }
        this.recipients = recipients;
    }

    @Override
    public void setSubject() {
        final String subject = "Welcome to the University Library - Here is your new account!";
        this.subject = subject;
    }

    @Override
    public void setContent(String firstName, String lastName, String validationLink) {

    }

    @Override
    public void setContent(String firstName, String lastName, String email, String password, String legitimationNumber, UserRole role) {
        String content = "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>Your Account Details</title>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; line-height: 1.6; background-color: #f4f4f4; padding: 20px; color: #000; }"
                + ".container { max-width: 600px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); color: #000; }"
                + ".footer { font-size: 0.8em; text-align: center; margin-top: 20px; color: #666; }"
                + "h2, p { color: #000; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class=\"container\">"
                + "<img src=\"https://cdn2.iconfinder.com/data/icons/flat-line-valentine-1/1010/love-book-1024.png\" alt=\"University Library Logo\" style='width: 150px; height: auto; display: block; margin: auto;'>"
                + "<h2>Hey " + firstName + " " + lastName + ",</h2>"
                + "<p>Welcome to the University Library! Here are your account details:</p>"
                + "<p>Email: " + email + "</p>"
                + "<p>Password: " + password + "</p>"
                + "<p>Legitimation Number: " + legitimationNumber + "</p>"
                + "<p>Role: " + role + "</p>"
                + "<p class=\"footer\">Happy Reading!</p>"
                + "</div>"
                + "</body>"
                + "</html>";

        this.content = content;
    }
}
