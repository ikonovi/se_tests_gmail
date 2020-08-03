package ik.se.browser;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;

public class ChromeDriverProvider implements Provider<WebDriver> {

    @Inject
    @Chrome
    WebDriverFactory factory;

    @Override
    public WebDriver get() {
        return factory.createWebDriver();
    }
}
