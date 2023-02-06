import PagesUtils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SanityTests {
    private static WebDriver driver;

    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    private String timeNow = "/Users/efikater/Downloads/IdeaProjects-main/BuyMeSanity/src/Output" + String.valueOf(System.currentTimeMillis());


    public SanityTests() {
    }

    @BeforeClass
    public void init() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("/Users/efikater/Downloads/IdeaProjects-main/BuyMeSanity/src/Output/Report.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");

        // log results
        test.log(Status.INFO, "@Before class");
        driver = DriverSingleton.getDriverInstance();
        driver.get(DriverSingleton.getData("site"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void registrationFlow()  {
            HomePage homePage = new HomePage();
        try {
            homePage.clickSigninBtn();
            test.info("Clicked Signin/Register button");
            homePage.clickRegisterLinkBtn();
            test.info("Clicked register link");
            String name = "Efi";
            homePage.setRegisterFirstNameTb(name);
            test.info("sent keys to name tb");
            assertEquals(homePage.getRegisterFirstNameTb(),name);
            test.pass("name equals expected name");
            String registerMail = generateRandomEmail();
            homePage.setRegisterMailTb(registerMail);
            test.info("sent keys to email tb");
            assertEquals(homePage.getRegisterMailTb(),registerMail);
            test.pass("email equals expected email");
            String registerPw = "Aa123456!";
            homePage.setRegisterPwTb(registerPw);
            test.info("sent keys to password tb");
            assertEquals(homePage.getRegisterPwTb(),registerPw);
            test.info("password equals to expected password");
            homePage.setRegisterSecondPwTb(registerPw);
            test.info("sent keys to confirm password tb");
            assertEquals(homePage.getRegisterSecondPwTb(),registerPw);
            test.info("password equals to expected password");
            homePage.clickRegisterAgreenemtRb();
            test.info("clicked on agreement rb");
            homePage.clickRegisterBtn();
            test.info("clicked on register button");
            assertTrue(homePage.isSingedIn());
            test.info("verified user is now logged in");
            test.pass("registration test passed");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
}


    @Test (dependsOnMethods = { "registrationFlow" })
    public void presentSearch()  {
        driver.get(DriverSingleton.getData("site"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage();
        try {
            homePage.clickAmountDd();
            test.info("Clicked amount dd");
            homePage.clickAmountOption99_199();
            test.info("Clicked 100-199");
            homePage.clickRegionDd();
            test.info("clicked on region dd");
            homePage.clickRegionTelAviv();
            test.info("clicked on Tel Aviv region");
            homePage.clickCategoryDd();
            test.info("clicked category");
            homePage.clickFavGifts_2023();
            test.info("clicked on fav presents for 2023");
            try {
                homePage.clickSearchBtn();
                test.info("clicked on search button");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                assertEquals(driver.getCurrentUrl(), Constants.SEARCH_RESULTS);
                test.pass("present search test passed");
            }
            catch (NoSuchElementException e){
                e.printStackTrace();}
            catch (ElementClickInterceptedException e) {
                e.printStackTrace();
            }

        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test (dependsOnMethods = { "presentSearch" })
    public void categoryGiftSelection(){
        driver.get(DriverSingleton.getData("site"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage();
        try {
            homePage.clickBestGiftCard();
            test.info("clicked on best gifts 2023");
            WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
            webDriverWait.until(ExpectedConditions.urlContains(Constants.BEST_GIFTS_PAGE));
            assertEquals(driver.getCurrentUrl(),Constants.BEST_GIFTS_PAGE);
            test.info("verified new page");
            CategoryPage categoryPage = new CategoryPage();
            categoryPage.clickTaizuCard();
            test.info("click on Taizu gift card");
            webDriverWait.until(ExpectedConditions.urlContains(Constants.TAIZU_GIFT_PAGE));
            test.info("verified new page");
            GiftSelectPage giftSelectPage = new GiftSelectPage();
            giftSelectPage.setEnterAmountTb("100");
            test.info("sent keys to amount tb");
            giftSelectPage.clickSelectBtn();
            test.info("clicked on a select btn");
            webDriverWait.until(ExpectedConditions.urlContains(Constants.PURCHASE_COMPLETE_Page));
            test.info("verified new page");
            PurchaseCompletePage purchaseCompletePage = new PurchaseCompletePage();
            assertEquals(purchaseCompletePage.getPurchaseGiftLabel(),"רכישת מתנה");
            test.info("verified header");
            test.pass("category gift selection test passed");
        } catch (NoSuchElementException e){
        e.printStackTrace();
        test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
    }

    }

    @Test (dependsOnMethods = { "categoryGiftSelection" })
    public void sendPresent(){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
            PurchaseCompletePage purchaseCompletePage = new PurchaseCompletePage();
            purchaseCompletePage.clickToSomeoneElseBtn();
            test.info("clicked on someone else");
            purchaseCompletePage.setToTb("Efi");
            test.info("sent keys to recipient");
            assertEquals(purchaseCompletePage.getToTb(),"Efi");
            purchaseCompletePage.clickEventDd();
            test.info("click on event dd");
            purchaseCompletePage.clickBDSelect();
            test.info("clicked on bd selection");
            purchaseCompletePage.setWishTa("congrats");
            test.info("sent keys to wish ta");
            purchaseCompletePage.clickContinueBtn();
            test.info("clicked continue");
            webDriverWait.until(ExpectedConditions.urlContains("https://buyme.co.il/money/348972?price=100&step=2"));
            test.info("verified new page");
            purchaseCompletePage.clickNowRb();
            test.info("clicked on now rb");
            purchaseCompletePage.clickSmsBtn();
            test.info("clicked on sms button");
            purchaseCompletePage.setSmsTb("0549253835");
            test.info("sent keys to sms tb");
            assertEquals(purchaseCompletePage.getFromTb(),"Efi ");
            test.info("verified sender");
            test.pass("test send present passed");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }


    }

    @AfterClass
    public void tearDown(){
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
    }

    private String generateRandomEmail() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder user = new StringBuilder();
        Random rnd = new Random();
        while (user.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * str.length());
            user.append(str.charAt(index));
        }
        String mail = user+"@at.com";
        return mail;

    } // generates a random string for email address and returns it

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
