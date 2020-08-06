package ik.tests.cloneable;

import ik.se.gmail.model.EmailMessage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CloneableEmailMessageTest {

    private EmailMessage messageOrig;
    private EmailMessage messageClone;

    @BeforeClass
    public void beforeClass() {
        List<String> recipients = new ArrayList<>();
        recipients.add("www1@mail.com");
        recipients.add("www2@mail.com");
        messageOrig = new EmailMessage(recipients, "subject", "body");
        messageClone = messageOrig.clone();
    }

    @Test
    public void testObjectsReference() {
        Assert.assertEquals(messageClone != messageOrig, true);
    }

    @Test
    public void testObjectsClass() {
        Assert.assertEquals(messageOrig.getClass() == messageClone.getClass(), true);
    }

    @Test
    public void testObjectsEquals() {
        Assert.assertEquals(messageClone.equals(messageOrig), true);
    }
}
