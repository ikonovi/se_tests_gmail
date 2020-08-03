package ik.se.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ik.se.gmail.pages.element.PageElement.*;

public class InboxPage extends AbstractPage {

    private By accountImageBy = By.xpath(inboxPageAccountImage_xpath);
    private By signOutButtonBy = By.xpath(inboxPageSignOutButton_xpath);
    private By messageComposeButtonBy = By.cssSelector(inboxPageMessageComposeButton_css);
    private By messageToTextAreaBy = By.xpath(inboxPageMessageToTextArea_xpath);
    private By messageSubjectBoxBy = By.xpath(inboxPageMessageSubjectBox_xpath);
    private By messageBodyBoxBy = By.cssSelector(inboxPageMessageBodyBox_css);
    private By messageSendButtonBy = By.cssSelector(inboxPageMessageSendButton_css);
    private By messagesTableBy = By.xpath(inboxPageMessagesTable_xpath);

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        waitTitleContains(driver, inboxPageTitle);
    }

    public InboxPage(WebDriver driver, String url) {
        this.driver = driver;
        this.driver.get(url);
        waitTitleContains(driver, inboxPageTitle);
    }

    public SignInChooseAccountPage signOut() {
        WebElement accountImage = waitToBeClickable(driver, accountImageBy);
        accountImage.click();
        WebElement signOutButton = waitToBeClickable(driver, signOutButtonBy);
        signOutButton.click();
        return new SignInChooseAccountPage(driver);
    }

    @Override
    public boolean isLoaded() {
        return waitTitleContains(driver, inboxPageTitle);
    }

    public void sendEmailMessage(List<String> toEmailAddresses, String subject, String body) {
        toEmailAddresses.forEach(emailAddress -> {
            WebElement composeButton = waitToBeClickable(driver, messageComposeButtonBy);
            composeButton.click();
            WebElement toTextArea = waitToBeClickable(driver, messageToTextAreaBy);
            toTextArea.click();
            toTextArea.sendKeys(emailAddress);
            WebElement subjectBox = waitToBeClickable(driver, messageSubjectBoxBy);
            subjectBox.sendKeys(subject);
            WebElement bodyBox = waitToBeClickable(driver, messageBodyBoxBy);
            bodyBox.sendKeys(body);
            WebElement sendButton = waitToBeClickable(driver, messageSendButtonBy);
            sendButton.click();
        });
    }

    public boolean isMessageReceived(String messageSubject) {
        boolean isSubjectPresent = false;
        WebElement table = waitToBeClickable(driver, messagesTableBy);
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        for (WebElement row : tableRows) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                String text = td.getText();
                //System.out.println("data = \"" + text + "\"");
                if (text.contains(messageSubject)) {
                    isSubjectPresent = true;
                    break;
                }
            }
            if (isSubjectPresent) break;
            else continue;
        }
        return isSubjectPresent;
    }
}
