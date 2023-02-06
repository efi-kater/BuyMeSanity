package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    public void clickElement(By locator)  {
        getWebElement(locator).click();
    }//click on element

    public void sendKeysToElement(By locator, String text)  {
        getWebElement(locator).sendKeys(text);
    }//send keys to element

    protected WebElement getWebElement(By locator)  {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }// get web element
}
