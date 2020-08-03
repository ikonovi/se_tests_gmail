package ik.se.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

public class RawScenario {

    static final String USER_EMAIL = "email@email";
    static final String USER_PWD = "password";
    static final String URL_GGL_GMAIL = "https://gmail.com";
    private static WebDriver driver;

    private static void setupChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "user-data-dir=" + System.getProperty("java.io.tmpdir") + "chrome-dev-profile"
        );
        driver = new ChromeDriver(service, options);
    }

    public static void main(String[] args) throws InterruptedException {
        setupChrome();

        driver.get(URL_GGL_GMAIL);

        /*
        Сценарий 1
        1. Открыть страницу gmail.com, заполнить поле логин, продолжить.
        2. Заполнить поле пароль, продолжить.
        3. Дождаться пока выполнится авторизация и проверить, что Вы находитесь на главной странице почтового сервиса.
         */

        /*

        WebElement emailInput = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']")));
        emailInput.sendKeys(USER_EMAIL);

        WebElement emailNext = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.id("identifierNext")));
        emailNext.click();
>>>>
        WebElement passwordInput = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        passwordInput.sendKeys(USER_PWD);

        WebElement passwordNext = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        passwordNext.click();
        */

        /*
            3. Дождаться пока выполнится авторизация и проверить, что Вы находитесь на главной странице почтового сервиса.
         */
        /*
        boolean isMainPage = new WebDriverWait(driver, 7).until(
                ExpectedConditions.titleContains(USER_EMAIL)
        );
        System.out.println("DEBUG: " + driver.getTitle());
        assertTrue(isMainPage);
        */

        // ----------------------------------------------------------

        /*
        Сценарий 2
        Предусловие:
        Вы авторизованы в почтовом сервисе.

        1. Осуществить выход из почтового сервиса, проверить что Вы на странице авторизации.
         */
/*

        WebElement accountImage = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label,'igar')]/img")));
        accountImage.click();

        WebElement signOutButton = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'Logout')]")));
        signOutButton.click();

        boolean isServiceLoginPage = new WebDriverWait(driver, 7).until(
                ExpectedConditions.urlContains("ServiceLogin/signinchooser")
        );
        assertTrue(isServiceLoginPage);
*/
        // ----------------------------------------------------------

        /*
        Сценарий 3
        Предусловие
        Вы авторизованы в почтовом сервисе.

        1. Написать сообщение (самому себе)
        2. Заполнить обязательные поля (кому, тема, текст)
        3. Отправить сообщение.
        4. Дождаться отображения письма в Вашем почтовом сервисе. Проверить, что письмо получено.

        Постусловие
        Осуществить выход из почтового сервиса.
         */

        //Предусловие: авторизоваться, выбрав идентифкатор
/*

        WebElement profileIdentifier = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='profileIdentifier'][@data-email='"
                        + USER_EMAIL + "']")));
        profileIdentifier.click();

        WebElement passwordInput = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        passwordInput.sendKeys(USER_PWD);

        WebElement passwordNext = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        passwordNext.click();
*/

/*


        // click Compose button
        WebElement composeButton = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".T-I-KE")));
        composeButton.click();

        // form: Recipients
        WebElement recipientsTextarea = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//form[@method='POST']//textarea")));
        recipientsTextarea.click();
        recipientsTextarea.sendKeys(USER_EMAIL);
        // form: Subject
        WebElement subjectBox = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//form[@method='POST']//input[@name='subjectbox']")));
        subjectBox.sendKeys("test subject");
        //form" Body
        WebElement bodyBox = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".Am.Al.editable.LW-avf")));
        bodyBox.sendKeys("test message");

        // form: Send
        WebElement sendButton = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".T-I.J-J5-Ji.aoO")));
        sendButton.click();
*/

/*

        WebElement tableGrid = new WebDriverWait(driver, 7).until(
                ExpectedConditions.elementToBeClickable((By.xpath("//div[3]/div/table/tbody"))));
        boolean isSubjectPresent = false;
        List<WebElement> tableRows = tableGrid.findElements(By.tagName("tr"));
        for (WebElement row : tableRows) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
                for (WebElement td : tds) {
                    if(td.getText().contains("test subject")){
                        isSubjectPresent = true;
                        break;
                    };
                }
            if(isSubjectPresent) break; else continue;
        }
        assertTrue(isSubjectPresent);
*/


        //Thread.sleep(5000);
        //driver.quit();
    }
}
