package ik.se.gmail.data;

import java.util.List;

public class EmailMessage {
    public List<String> recipientEmails;
    public String subject;
    public String body;

    public EmailMessage(List<String> recipientEmails, String subject, String body) {
        this.recipientEmails = recipientEmails;
        this.subject = subject;
        this.body = body;
    }
}
