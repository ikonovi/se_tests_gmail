package ik.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ik.se.gmail.data.EmailMessage;
import ik.se.gmail.data.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static UserAccount account;
    public static EmailMessage message;

    @Inject
    private static void setUserAccount(@Named("userEmail") String userEmail,
                                       @Named("userPassword") String userPassword) {
        account = new UserAccount(userEmail, userPassword);
    }

    @Inject
    private static void setEmailMessage(@Named("userEmail") String userEmail,
                                        @Named("messageSubject") String messageSubject,
                                        @Named("messageBody") String messageBody) {
        List<String> recipientEmails = new ArrayList<>();
        recipientEmails.add(userEmail.trim());
        message = new EmailMessage(recipientEmails, messageSubject.trim(), messageBody.trim());
    }
}
