package com.lbbsystem.lbbsystem.emailService;

public abstract class EmailMessage {
 protected String[] recipients;
 protected String subject;
 protected String content;

  public String[] getRecipients() {
    return recipients;
  }

  public String getSubject() {
    return subject;
  }

  public String getContent() {
    return content;
  }

  public abstract void setRecipients(String[] recipients);

  public abstract void setSubject();

  public abstract void setContent(String firstName, String lastName, String validationLink);
}
