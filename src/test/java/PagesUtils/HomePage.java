package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    private WebDriver driver;
    public HomePage() {
        driver=DriverSingleton.getDriverInstance();
            }


    private By myaccountBtn = By.cssSelector("span[class='arrow ember-view bm-icon sm']");
    private By signinBtn = By.cssSelector("li[class='notSigned']");
    private By registerLinkBtn = By.cssSelector("span[class='text-link theme']");

    private By registerFirstNameTb = By.cssSelector("input[placeholder='שם פרטי']");
    private By registerMailTb = By.cssSelector("input[placeholder='מייל']");
    private By registerPwTb = By.cssSelector("input[placeholder='סיסמה']");
    private By registerSecondPwTb = By.cssSelector("input[placeholder='אימות סיסמה']");

    private By registerAgreementRb = By.cssSelector("circle[class='fill']");

    private By registerBtn = By.cssSelector("button[type='submit']");

    private By ammountDd = By.cssSelector("span[title='סכום']");

    private By amountOption100_199 = By.cssSelector("li[value='2']");

    private By regionDd = By.cssSelector("span[title='אזור']");

    private By regionTelAviv = By.cssSelector("li[value='13']");

    private By categoryDd = By.cssSelector("span[title='קטגוריה']");

    private By favGifts_2023 = By.cssSelector("li[value='438']");
    private By presentTypeTb = By.cssSelector("input[placeholder='איזו מתנה תרצו לחפש?']");

    private By searchBtn = By.xpath("/html/body/div[3]/div/header/div[3]/div/div/form/a");

    private By bestGiftCard = By.cssSelector("div[class='product-card-bg']");





    public void clickSigninBtn()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signinBtn));
        super.clickElement(signinBtn);
    } // click sign in button

    public void clickRegisterLinkBtn()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerLinkBtn));
        super.clickElement(registerLinkBtn);
    } //click register link

    public void clickRegisterAgreenemtRb()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerAgreementRb));
        super.clickElement(registerAgreementRb);
    } //click on agreement radio button

    public void clickRegisterBtn()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        super.clickElement(registerBtn);
    } // click register button

    public void setRegisterFirstNameTb(String registerFirstNameTb)  {
        super.sendKeysToElement(this.registerFirstNameTb, registerFirstNameTb);
    } // send keys to name text box

    public String getRegisterFirstNameTb()  {
        String result= super.getWebElement(registerFirstNameTb).getAttribute("value");
        return result;
    } // get the text from the name text box

    public void setRegisterMailTb(String registerMailTb)  {
        super.sendKeysToElement(this.registerMailTb, registerMailTb);
    } // send keys to email text box

    public String getRegisterMailTb()  {
        String result= super.getWebElement(registerMailTb).getAttribute("value");
        return result;
    } // get text from email text box

    public void setRegisterPwTb(String registerPwTb)  {
        super.sendKeysToElement(this.registerPwTb, registerPwTb);
    }//send keys to password text box

    public String getRegisterPwTb()  {
        String result= super.getWebElement(registerPwTb).getAttribute("value");
        return result;
    } // get the value (hidden) from the password

    public void setRegisterSecondPwTb(String registerSecondPwTb) {
        super.sendKeysToElement(this.registerSecondPwTb, registerSecondPwTb);
    } //send keys to password text box

    public String getRegisterSecondPwTb()  {
        String result= super.getWebElement(registerSecondPwTb).getAttribute("value");
        return result;
    }// get the value (hidden) from the password



    public boolean isSingedIn()  {
        boolean result=false;
        result=super.getWebElement(myaccountBtn).isDisplayed();
        return  result;
    } // return boolean about sign in

    public void clickAmountDd()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ammountDd));
        super.clickElement(ammountDd);
    } // click on amount drop down
    public void clickAmountOption100_199()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(amountOption100_199));
        super.clickElement(amountOption100_199);
    } // click on 100-199 option
    public void clickRegionDd()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(regionDd));
        super.clickElement(regionDd);
    } // click on region  drop down
    public void clickRegionTelAviv()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(regionTelAviv));
        super.clickElement(regionTelAviv);
    } // click on tel aviv option
    public void clickCategoryDd()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(categoryDd));
        super.clickElement(categoryDd);
    } // click on category drop down
    public void clickFavGifts_2023()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(favGifts_2023));
        super.clickElement(favGifts_2023);
    } // click on favs for 2023 option
    public void clickSearchBtn()  {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        super.clickElement(RelativeLocator.with(By.tagName("a")).toLeftOf(presentTypeTb));
    } // click on search button

    public void clickBestGiftCard(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(bestGiftCard));
        super.clickElement(bestGiftCard);
    } // click on favs gift for 2023 card


}
