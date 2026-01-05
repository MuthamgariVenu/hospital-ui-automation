package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By headerTitle = By.tagName("h1");

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    // Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(headerTitle).isDisplayed();
    }
}
