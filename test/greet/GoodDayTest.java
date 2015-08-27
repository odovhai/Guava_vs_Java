package greet;


import junit.framework.TestCase;
import org.junit.Assert;

public class GoodDayTest extends TestCase {

    public void testGoodDay() throws Exception {

        Assert.assertEquals("Good Day, World!", GoodDay.greet(1200));
        Assert.assertEquals("Good Day, World!", GoodDay.greet(1324));
        Assert.assertEquals("Good Day, World!", GoodDay.greet(1400));
        Assert.assertEquals("Good Day, World!", GoodDay.greet(1459));


    }

    public void testGoodLunch() {
        Assert.assertEquals("Good Lunch, World!", GoodDay.greet(1330));
    }
}