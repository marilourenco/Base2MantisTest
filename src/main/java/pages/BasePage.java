package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
