package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CategoryPage extends BasePage {

    private WebDriver driver;
    public CategoryPage() {
        driver=DriverSingleton.getDriverInstance();
            }

    private By taizuCard = By.cssSelector("span[class='name bm-subtitle-1']");


    public void clickTaizuCard(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(taizuCard));
        super.clickElement(taizuCard);
    }//click on Taizu gift card






}
