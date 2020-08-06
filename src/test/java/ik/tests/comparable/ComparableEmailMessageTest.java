package ik.tests.comparable;

import ik.se.gmail.model.EmailMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ComparableEmailMessageTest {

    /**
     * The implementor must ensure sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y.
     */
    @Test
    public void testCommutativus() {
        for (int i = 0; i < 25; i++) {
            EmailMessage x = new EmailMessage(Arrays.asList(new String[]{myRandomString()}), myRandomString(), myRandomString());
            EmailMessage y = new EmailMessage(Arrays.asList(new String[]{myRandomString()}), myRandomString(), myRandomString());
            int sgnXY = Integer.signum(x.compareTo(y));
            int sgnYX = Integer.signum(y.compareTo(x));
            Assert.assertEquals(sgnXY == -sgnYX, true);
        }
    }

    /**
     * The implementor must also ensure that the relation is transitive:
     * (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
     */
    @Test
    public void testTransitiveRelation() {
        EmailMessage x = new EmailMessage(
                Arrays.asList(new String[]{"user1@aaa.bb"}), "sublect 1", "body 1");
        EmailMessage y = new EmailMessage(Arrays.asList(
                new String[]{"user1@aaa.bb", "user2@aaa.bb"}), "sublect 1", "body 1");
        EmailMessage z = new EmailMessage(
                Arrays.asList(new String[]{"user1@aaa.bb", "user2@aaa.bb", "user3@aaa.bb"}), "sublect 1", "body 1");

        int sgnXY = Integer.signum(x.compareTo(y));
        //System.out.println("sgn12 = " + sgn12);
        int sgnYZ = Integer.signum(y.compareTo(z));
        //System.out.println("sgn23 = " + sgn23);
        int sgnXZ = Integer.signum(x.compareTo(z));
        //System.out.println("sgn13 = " + sgn13);

        Assert.assertEquals(Integer.signum(sgnXY) == Integer.signum(sgnYZ), true);
        int sgn = Integer.signum(sgnXY);
        Assert.assertEquals(sgn == sgnXZ, true);
    }

    /**
     * The implementor must ensure that x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)),
     * for all z.
     */
    @Test
    public void testXYzero() {
        EmailMessage x = new EmailMessage(
                Arrays.asList(new String[]{"user1@aaa.bb"}), "sublect 1", "body 1");
        EmailMessage y = new EmailMessage(
                Arrays.asList(new String[]{"user1@aaa.bb"}), "sublect 1", "body 1");
        Assert.assertEquals(x.compareTo(y), 0);

        for (int i = 0; i < 25; i++) {
            EmailMessage z = new EmailMessage(Arrays.asList(new String[]{myRandomString()}), myRandomString(), myRandomString());
            int sgnXZ = Integer.signum(x.compareTo(z));
            int sgnYZ = Integer.signum(y.compareTo(z));
            Assert.assertEquals(sgnXZ == sgnYZ, true);
        }
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String myRandomString() {
        StringBuilder builder = new StringBuilder();
        int count = 10;
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
