package greet;


import junit.framework.TestCase;
import org.junit.Assert;

public class GoodDayTest extends TestCase {

    public void testGoodDay() throws Exception {

        Assert.assertEquals("Good day, World", GoodDay.greet(1200));
        Assert.assertEquals("Good day, World", GoodDay.greet(1324));
        Assert.assertEquals("Good day, World", GoodDay.greet(1400));
        Assert.assertEquals("Good day, World", GoodDay.greet(1400));
        Assert.assertEquals("Good evening, World", GoodDay.greet(1600));
    }

    public void testGoodLunch() {
        Assert.assertEquals("Good lunch, World", GoodDay.greet(1330));
    }
}