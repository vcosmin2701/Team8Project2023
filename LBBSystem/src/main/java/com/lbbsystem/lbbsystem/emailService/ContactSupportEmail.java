package com.lbbsystem.lbbsystem.emailService;

public class ContactSupportEmail extends EmailMessage {
    @Override
    public void setRecipients(String[] recipients) {
        if (recipients == null) {
            throw new IllegalArgumentException();
        }
        this.recipients = recipients;
    }

    @Override
    public void setSubject() {
        final String subject = "An user needs your help";
        this.subject = subject;
    }

    @Override
    public void setContent(String userName, String email, String message) {
        String content = "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>Welcome to the University Library</title>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; line-height: 1.6; background-color: #f4f4f4; padding: 20px; color: #000; }"
                + ".container { max-width: 600px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); color: #000; }"
                + ".btn { display: block; width: max-content; background-color: #0056b3; padding: 10px 20px; color: white; text-align: center; text-decoration: none; border-radius: 5px; margin: 20px auto; }"
                + ".footer { font-size: 0.8em; text-align: center; margin-top: 20px; color: #666; }"
                + "h2, p { color: #000; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class=\"container\">"
                + "<img src=\"https://cdn2.iconfinder.com/data/icons/flat-line-valentine-1/1010/love-book-1024.png\" alt=\"University Library Logo\" style='width: 150px; height: auto; display: block; margin: auto;'>"
                + "<h2>Hey admin, </h2> "
                + "<p> User " + userName + " said,</p>"
                + "<p>" + message + "</p>"
                + "<p>Reply to " + email + " to help " + userName + "</p>"
                + "</div>"
                + "</body>"
                + "</html>";
        this.content = content;
    }
}
