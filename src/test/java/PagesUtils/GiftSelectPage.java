package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GiftSelectPage extends BasePage {

    private WebDriver driver;
    public GiftSelectPage() {
        driver=DriverSingleton.getDriverInstance();
            }

    private By enterAmountTb = By.cssSelector("input[placeholder='הכנס סכום']");
    private By SelectBtn = By.cssSelector("button[type='submit']");


    public void setEnterAmountTb(String amount){
        super.sendKeysToElement(enterAmountTb, amount);
    }//send keys to amount text box

    public void clickSelectBtn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(enterAmountTb));
        super.clickElement(SelectBtn);
    } // click select button





}
