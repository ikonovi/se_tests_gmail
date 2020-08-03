package ik.config;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import ik.se.browser.Chrome;
import ik.se.browser.ChromeDriverFactory;
import ik.se.browser.ChromeDriverProvider;
import ik.se.browser.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriverFactory.class)
                .annotatedWith(Chrome.class)
                .to(ChromeDriverFactory.class)
                .in(Scopes.SINGLETON);
        bind(WebDriver.class)
                .annotatedWith(Chrome.class)
                .toProvider(ChromeDriverProvider.class)
                .in(Scopes.SINGLETON);
    }
}
