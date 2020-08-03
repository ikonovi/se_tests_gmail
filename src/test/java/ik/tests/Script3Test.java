package ik.tests;

import ik.se.gmail.pages.InboxPage;
import ik.se.gmail.pages.SignInChooseAccountPage;
import ik.tests.base.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ik.config.TestData.account;
import static ik.config.TestData.message;
import static ik.se.gmail.pages.element.PageElement.inboxPageUrl;
import static ik.se.gmail.pages.element.PageElement.signInChooseAccountUrl;
import static org.testng.Assert.assertTrue;

/**
 * Сценарий 3
 * Предусловие
 * Вы авторизованы в почтовом сервисе.
 * <p>
 * 1. Написать сообщение (самому себе)
 * 2. Заполнить обязательные поля (кому, тема, текст)
 * 3. Отправить сообщение.
 * 4. Дождаться отображения письма в Вашем почтовом сервисе. Проверить, что письмо получено.
 * <p>
 * Постусловие
 * Осуществить выход из почтового сервиса.
 */
public class Script3Test extends BaseTest {

    @BeforeClass
    public void setUp(ITestContext ctx) {
        logger.info("Script3Test#setUp()");
        logger.info((String) ctx.getAttribute("myAttr1"));
        SignInChooseAccountPage signInChooseAccountPage = new SignInChooseAccountPage(driver, signInChooseAccountUrl);
        signInChooseAccountPage.signIn(account.password);
    }

    @Test
    public void testSendMessage() {
        InboxPage inboxPage = new InboxPage(driver, inboxPageUrl);
        logger.info("sendMessage(): To: " + message.recipientEmails + "; Subject: " + message.subject + "; Body: " + message.body);
        inboxPage.sendEmailMessage(message.recipientEmails, message.subject, message.body);
        assertTrue(inboxPage.isMessageReceived(message.subject));
    }

    @AfterClass(alwaysRun = true, enabled = true)
    public void tearDown() {
        logger.info("Script3Test#tearDown()");
        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.signOut();
    }
}
