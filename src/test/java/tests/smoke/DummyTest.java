package tests.smoke;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DummyTest extends BaseTest {

    @Test
    public void homePageSmokeTest() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.getPageTitle().length() > 0);
        Assert.assertTrue(home.isHeaderDisplayed());
    }
}
