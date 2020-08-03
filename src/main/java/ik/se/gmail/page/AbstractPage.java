package ik.se.gmail.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ik.se.gmail.page.element.PageElement.waitTimeOutInSeconds;

public abstract class AbstractPage {

    private final int timeout = Integer.parseInt(waitTimeOutInSeconds);

    public abstract boolean isLoaded();

    public boolean waitTitleContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.titleContains(substring));
    }

    public boolean waitUrlContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.urlContains(substring));
    }

    public WebElement waitToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.elementToBeClickable(by));
    }
}
