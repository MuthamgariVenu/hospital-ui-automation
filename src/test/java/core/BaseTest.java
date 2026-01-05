package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected Properties prop = new Properties();

    @BeforeMethod
    public void setUp() throws Exception {

        String env = System.getProperty("env", "qa");

        FileInputStream fis =
                new FileInputStream("src/main/resources/config/" + env + ".properties");
        prop.load(fis);

        String browser = System.getProperty("browser", prop.getProperty("browser"));
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

        DriverFactory.initDriver(browser, headless);

        DriverFactory.getDriver().get(prop.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
