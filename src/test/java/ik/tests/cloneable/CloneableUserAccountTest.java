package ik.tests.cloneable;

import ik.se.gmail.model.UserAccount;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloneableUserAccountTest {

    private UserAccount accOrig;
    private UserAccount accClone;

    @BeforeClass
    public void beforeClass() {
        accOrig = new UserAccount("sss@ccc.vb", "pwd");
        accClone = accOrig.clone();
    }

    @Test
    public void testObjectsReference() {
        Assert.assertEquals(accClone != accOrig, true);
    }

    @Test
    public void testObjectsClass() {
        Assert.assertEquals(accOrig.getClass() == accClone.getClass(), true);
    }

    @Test
    public void testObjectsEquals() {
        Assert.assertEquals(accClone.equals(accOrig), true);
    }
}
