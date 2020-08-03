package ik.se.gmail.pages.element;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class PageElement {

    @Inject @Named("waitTimeOutInSeconds") public static String waitTimeOutInSeconds;
    
    // SignIn page
    @Inject @Named("signInPageUrl") public static String signInPageUrl;
    @Inject @Named("signInPageTitle") public static String signInPageTitle;
    @Inject @Named("signInPageEmailInput_xpath") public static String signInPageEmailInput_xpath;
    @Inject @Named("signInPageEmailInputNextButton_id") public static String signInPageEmailInputNextButton_id;
    @Inject @Named("signInPagePasswordInput_xpath") public static String signInPagePasswordInput_xpath;
    @Inject @Named("signInPagePasswordInputNextButton_id") public static String signInPagePasswordInputNextButton_id;


    // Inbox page
    @Inject @Named("inboxPageTitle") public static String inboxPageTitle;
    @Inject @Named("inboxPageUrl") public static String inboxPageUrl;
    public static String inboxPageAccountImage_xpath;
    @Inject
    private static void setInboxPageAccountImage_xpath(
            @Named("inboxPageAccountImage_xpath") String xpath,
            @Named("userEmail") String emailAddress){
        inboxPageAccountImage_xpath = xpath.replace("${emailAddress}", emailAddress);
    }
    @Inject @Named("inboxPageSignOutButton_xpath") public static String inboxPageSignOutButton_xpath;
    @Inject @Named("inboxPageMessageComposeButton_css") public static String inboxPageMessageComposeButton_css;
    @Inject @Named("inboxPageMessageToTextArea_xpath") public static String inboxPageMessageToTextArea_xpath;
    @Inject @Named("inboxPageMessageSubjectBox_xpath") public static String inboxPageMessageSubjectBox_xpath;
    @Inject @Named("inboxPageMessageBodyBox_css") public static String inboxPageMessageBodyBox_css;
    @Inject @Named("inboxPageMessageSendButton_css") public static String inboxPageMessageSendButton_css;
    @Inject @Named("inboxPageMessagesTable_xpath") public static String inboxPageMessagesTable_xpath;


    // SignIn Choose Account page
    @Inject @Named("signInChooseAccountUrlPart") public static String signInChooseAccountUrlPart;
    @Inject @Named("signInChooseAccountTitle") public static String signInChooseAccountTitle;
    @Inject @Named("signInChooseAccountUrl") public static String signInChooseAccountUrl;
    public static String signInChooseAccountProfileIdentifier_xpath;
    @Inject
    private static void setSignInChooseAccountProfileIdentifier_xpath(
            @Named("signInChooseAccountProfileIdentifier_xpath") String xpath,
            @Named("userEmail") String emailAddress){
        signInChooseAccountProfileIdentifier_xpath = xpath.replace("${emailAddress}", emailAddress);
    }
    @Inject @Named("signInChooseAccountPasswordInput_xpath") public static String signInChooseAccountPasswordInput_xpath;
    @Inject @Named("signInChooseAccountPasswordNextButton_id") public static String signInChooseAccountPasswordNextButton_id;


    //@Inject @Named("") public static String;
}