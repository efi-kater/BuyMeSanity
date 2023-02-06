package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PurchaseCompletePage extends BasePage {

    private WebDriver driver;
    public PurchaseCompletePage() {
        driver=DriverSingleton.getDriverInstance();
            }


    private By purchaseGiftLabel = By.tagName("h1");
    private By toSomeoneElseBtn = By.cssSelector("div[gtm='למישהו אחר']");
    private By toTb = By.tagName("input");
    private By wishTa = By.tagName("textarea");
    private By eventDd = By.cssSelector("span[alt='לאיזה אירוע?']");

    private By bDSelect = By.cssSelector("li[value='10']");

    private By continueBtn = By.cssSelector("button[gtm='המשך']");
    private By nowRb = By.cssSelector("div[gtm='עכשיו']");
    private By smsBtn = By.cssSelector("path[class='circle']");
    private By smsTb = By.cssSelector("input[id='sms']");
    private By fromTb = By.cssSelector("input[placeholder='שם שולח המתנה']");

    public String getPurchaseGiftLabel() {
        return super.getWebElement(purchaseGiftLabel).getText();
    }
    public void clickToSomeoneElseBtn(){
        super.clickElement(toSomeoneElseBtn);
    }

    public void clickSmsBtn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smsBtn));
        super.clickElement(smsBtn);
    }

    public void clickNowRb(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nowRb));
        super.clickElement(nowRb);
    }
    public void clickBDSelect(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(bDSelect));
        super.clickElement(bDSelect);
    }
    public void clickEventDd(){
        super.clickElement(eventDd);
    }

    public void clickContinueBtn(){
        super.clickElement(continueBtn);
    }

    public void setToTb(String name){
        super.sendKeysToElement(RelativeLocator.with(toTb).below(toSomeoneElseBtn),name);
    }

    public void setSmsTb(String sms){
        super.sendKeysToElement(smsTb,sms);
    }

    public String getToTb(){
        return super.getWebElement(RelativeLocator.with(toTb).below(toSomeoneElseBtn)).getAttribute("value");
    }

    public String getFromTb(){
        return super.getWebElement(fromTb).getAttribute("value");
    }

    public void setWishTa(String wish){
        super.sendKeysToElement(wishTa,wish);
    }
}
