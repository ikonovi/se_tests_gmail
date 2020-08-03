package ik.se.gmail.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ik.se.gmail.page.element.PageElement.*;

public class SignInPage extends AbstractPage {

    private By emailInputBy = By.xpath(signInPageEmailInput_xpath);
    private By emailNextBy = By.id(signInPageEmailInputNextButton_id);
    private By passwordInputBy = By.xpath(signInPagePasswordInput_xpath);
    private By passwordNextBy = By.id(signInPagePasswordInputNextButton_id);

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(signInPageUrl);
        waitTitleContains(driver, signInPageTitle);
    }

    public InboxPage signIn(String emailAddress, String password) {
        WebElement emailInput = waitToBeClickable(driver, emailInputBy);
        emailInput.sendKeys(emailAddress);
        WebElement emailNext = waitToBeClickable(driver, emailNextBy);
        emailNext.click();
        // XXX: At this step, Google stops authentication when automation tool is used.
        WebElement passwordInput = waitToBeClickable(driver, passwordInputBy);
        passwordInput.sendKeys(password);
        WebElement passwordNext = waitToBeClickable(driver, passwordNextBy);
        passwordNext.click();
        return new InboxPage(driver);
    }

    @Override
    public boolean isLoaded() {
        return waitTitleContains(driver, signInPageTitle);
    }
}
