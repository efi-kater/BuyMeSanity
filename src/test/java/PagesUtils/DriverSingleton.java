package PagesUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;


public class DriverSingleton {
    private static WebDriver driver;
    private static Connection conn;

    public static WebDriver getDriverInstance()  {
        if(driver == null){
            try {
                DbUtils dbUtils = new DbUtils();
                conn = dbUtils.getConnection();
                String browser =dbUtils.getBrowser(conn);
                if(browser.equalsIgnoreCase("Chrome")){
                    System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);//when running the code don't forget to replace the path with your path for chrome driver
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-extensions");
                    driver = new ChromeDriver(options);
                }
            } catch (SQLException e){
                e.printStackTrace();
                String type="";
                try {
                     type = getData();
                    if(type.equals("Chrome")){
                        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);//when running the code don't forget to replace the path with your path for chrome driver
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--disable-extensions");
                        driver = new ChromeDriver(options);
                    }
                } catch (Exception ee){
                    ee.printStackTrace();
                }
                }


            }

        return driver;
    }
    public static String getData() {
            DbUtils dbUtils = new DbUtils();
            String site="";
            try {
                dbUtils.getConnection();
                conn = dbUtils.getConnection();
                site =dbUtils.getSite(conn);
            } catch (SQLException e){
                e.printStackTrace();
                File fXmlFile = new File("/Users/efikater/Downloads/IdeaProjects-main/BuyMeSanity/src/main/resources/data.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder;
                Document doc=null;
                try {
                    dBuilder = dbFactory.newDocumentBuilder();
                    doc= dBuilder.parse(fXmlFile);
                    doc.getDocumentElement().normalize();
                    site =doc.getElementsByTagName("site").item(0).getTextContent();


                } catch (Exception ee){
                    ee.printStackTrace();
                    return site;
                }


            }
            return site;



    }

}
