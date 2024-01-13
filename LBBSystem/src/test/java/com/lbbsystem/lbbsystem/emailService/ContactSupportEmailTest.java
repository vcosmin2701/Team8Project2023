package com.lbbsystem.lbbsystem.emailService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ContactSupportEmailTest {
    private ContactSupportEmail contactSupportEmail;

    @BeforeEach
    void setUp() {
        contactSupportEmail = new ContactSupportEmail();
    }

    @Test
    @DisplayName("Test setRecipients with valid recipients")
    void testSetRecipients() {
        // Arrange
        String[] validRecipients = {"support@example.com", "admin@example.com"};

        // Act
        contactSupportEmail.setRecipients(validRecipients);

        // Assert
        assertArrayEquals(validRecipients, contactSupportEmail.getRecipients());
    }

    @Test
    @DisplayName("Test setRecipients with null recipients")
    void testSetRecipientsWithNull() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> contactSupportEmail.setRecipients(null));
    }

    @Test
    @DisplayName("Test setSubject")
    void testSetSubject() {
        // Act
        contactSupportEmail.setSubject();

        // Assert
        assertEquals("An user needs your help", contactSupportEmail.getSubject());
    }

    @Test
    @DisplayName("Test setContent")
    void testSetContent() {
        // Arrange
        String userName = "John Doe";
        String email = "john.doe@example.com";
        String message = "This is a test message.";

        // Act
        ContactSupportEmail contactSupportEmail = new ContactSupportEmail();
        contactSupportEmail.setContent(userName, email, message);

        // Assert
        String expectedContent = "<!DOCTYPE html>"
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

        assertEquals(expectedContent, contactSupportEmail.getContent());
    }

}