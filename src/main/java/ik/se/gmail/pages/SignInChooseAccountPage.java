package ik.se.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ik.se.gmail.pages.element.PageElement.*;

public class SignInChooseAccountPage extends AbstractPage {

    private By accountIdentifierBy = By.xpath(signInChooseAccountProfileIdentifier_xpath);
    private By passwordInputBy = By.xpath(signInChooseAccountPasswordInput_xpath);
    private By passwordNextBy = By.id(signInChooseAccountPasswordNextButton_id);

    private WebDriver driver;

    public SignInChooseAccountPage(WebDriver driver) {
        this.driver = driver;
        waitUrlContains(driver, signInChooseAccountUrlPart);
    }

    public SignInChooseAccountPage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        waitUrlContains(driver, signInChooseAccountUrlPart);
    }

    @Override
    public boolean isLoaded() {
        return waitUrlContains(driver, signInChooseAccountUrlPart);
    }

    public InboxPage signIn(String password){
        WebElement accountProfileIdentifier = waitToBeClickable(driver, accountIdentifierBy);
        accountProfileIdentifier.click();
        // XXX: At this step, Google stops authentication when automation tool is used.
        WebElement passwordInput = waitToBeClickable(driver, passwordInputBy);
        passwordInput.sendKeys(password);
        WebElement passwordNext = waitToBeClickable(driver, passwordNextBy);
        passwordNext.click();
        return new InboxPage(driver);
    }
}
