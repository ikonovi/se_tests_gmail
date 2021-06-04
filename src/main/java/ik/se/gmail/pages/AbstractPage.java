package ik.se.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ik.se.gmail.pages.element.PageElement.waitTimeOutInSeconds;

public abstract class AbstractPage {

    private final Duration timeoutDuration = Duration.ofSeconds(
            Integer.parseInt(waitTimeOutInSeconds)
    );

    public abstract boolean isLoaded();

    public boolean waitTitleContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeoutDuration.getSeconds())
                .until(ExpectedConditions.titleContains(substring));
    }

    public boolean waitUrlContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeoutDuration.getSeconds())
                .until(ExpectedConditions.urlContains(substring));
    }

    public WebElement waitToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, timeoutDuration.getSeconds())
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
