package ik.se.browser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class ChromeDriverFactory implements WebDriverFactory {

    @Inject
    @Named("chromeProfileDirName")
    private String chromeProfileDirName;

    private ChromeDriver driver;

    @Override
    public WebDriver createWebDriver() {
        if (driver == null) {
            ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort().build();
            ChromeOptions options = new ChromeOptions();
            // https://github.com/GoogleChrome/chrome-launcher/blob/master/docs/chrome-flags-for-tools.md
            options.addArguments(
                      "--enable-automation",
                    /*  Added to be able to open Chrome with customised profile.
                        Example:
                        >"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
                            --user-data-dir="C:\Users\Igor\AppData\Local\Temp\chrome-dev-profile" */
                    "user-data-dir=" + System.getProperty("java.io.tmpdir") + chromeProfileDirName
            );
            options.setAcceptInsecureCerts(true);
            //options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            //options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(service, options);
        }
        return driver;
    }
}
