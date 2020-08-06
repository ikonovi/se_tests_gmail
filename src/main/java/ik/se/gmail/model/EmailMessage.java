package ik.se.gmail.model;

import java.util.*;
import java.util.stream.Collectors;

public class EmailMessage implements Comparable<EmailMessage>, Cloneable {

    public List<String> recipientEmails;
    public String subject;
    public String body;

    public EmailMessage(List<String> recipientEmails, String subject, String body) {
        this.recipientEmails = recipientEmails;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public int compareTo(EmailMessage o) {
        return subject.compareTo(o.subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailMessage that = (EmailMessage) o;
        return recipientEmails.equals(that.recipientEmails) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientEmails, subject, body);
    }

    @Override
    public EmailMessage clone() {
        EmailMessage clone = null;
        try {
            clone = (EmailMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        clone.recipientEmails = this.recipientEmails.stream().map(s -> s.intern()).collect(Collectors.toList());
        return clone;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmailMessage.class.getSimpleName() + "[", "]")
                .add("recipientEmails=" + recipientEmails)
                .add("subject='" + subject + "'")
                .add("body='" + body + "'")
                .toString();
    }
}
