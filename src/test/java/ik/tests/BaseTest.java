package ik.tests;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ik.se.browser.Chrome;
import ik.config.WebDriverModule;
import ik.config.TestConfigModule;
import ik.config.PageElementModule;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;

import java.util.logging.Logger;

@Guice(modules = {WebDriverModule.class, TestConfigModule.class, PageElementModule.class})
public class BaseTest {

    @Inject @Chrome
    protected WebDriver driver;

    @Inject
    protected Logger logger;

    @BeforeClass
    public void baseSetUp(ITestContext ctx) {
        ctx.setAttribute("myAttr1", "My attribute from test context.");
        logger.info("BaseTest#baseSetUp()");
    }

    @AfterClass(alwaysRun = true, enabled = true)
    public void baseTearDown() {
        driver.quit();
        logger.info("BaseTest#baseTearDown()");
    }
}