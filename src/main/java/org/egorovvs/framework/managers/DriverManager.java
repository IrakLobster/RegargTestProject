package org.egorovvs.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

<<<<<<< HEAD
    private WebDriver driver;

    private static DriverManager driverManager;

    private TestPropManager testPropManager = TestPropManager.getTestPropManager();
=======
    private  WebDriver driver;

    private static DriverManager driverManager;

    private  TestPropManager testPropManager = TestPropManager.getTestPropManager();
>>>>>>> a2a1b5512e184cdb97a584116b88bb32530a4589

    private DriverManager(){

    }

    public static DriverManager getDriverManager(){
        if(driverManager == null) driverManager = new DriverManager();
        return driverManager;
    }

    public WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", testPropManager.getProperty("path.chrome.driver.windows"));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public  void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
