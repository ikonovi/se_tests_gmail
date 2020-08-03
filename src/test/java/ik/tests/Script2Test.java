package ik.tests;

import ik.se.gmail.pages.InboxPage;
import ik.se.gmail.pages.SignInChooseAccountPage;
import ik.tests.base.BaseTest;
import org.testng.annotations.Test;

import static ik.se.gmail.pages.element.PageElement.*;
import static org.testng.Assert.assertTrue;

/**
 * Сценарий 2
 * Предусловие: Вы авторизованы в почтовом сервисе.
 * 1. Осуществить выход из почтового сервиса, проверить что Вы на странице авторизации.
 */
public class Script2Test extends BaseTest {
    @Test
    public void testSignOut() {
        InboxPage inboxPage = new InboxPage(driver, inboxPageUrl);
        SignInChooseAccountPage signInChooseAccountPage = inboxPage.signOut();
        assertTrue(signInChooseAccountPage.isLoaded());
    }
}
