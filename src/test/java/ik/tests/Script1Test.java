package ik.tests;

import ik.se.gmail.page.InboxPage;
import ik.se.gmail.page.SignInPage;
import org.testng.annotations.Test;

import static ik.config.TestData.account;
import static org.testng.Assert.assertTrue;

/**
 * Сценарий 1
 * 1. Открыть страницу gmail.com, заполнить поле логин, продолжить.
 * 2. Заполнить поле пароль, продолжить.
 * 3. Дождаться пока выполнится авторизация и проверить, что Вы находитесь на главной странице почтового сервиса.
 */
public class Script1Test extends BaseTest {
    @Test
    public void testSignIn() {
        SignInPage signInPage = new SignInPage(driver);
        InboxPage inboxPage = signInPage.signIn(account.emailAddress, account.password);
        assertTrue(inboxPage.isLoaded());
    }
}
