package org.egorovvs.framework.managers;

import java.util.concurrent.TimeUnit;

public class InitManager {

    private static InitManager initManager;

    private static TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private static DriverManager driverManager = DriverManager.getDriverManager();

    private InitManager(){

    }

    public static InitManager getInitManager(){
        if(initManager == null) initManager = new InitManager();
        return initManager;
    }

    public static void initFramework(){
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(testPropManager.getProperty("implicitly.wait")), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(testPropManager.getProperty("page.load.timeout")), TimeUnit.SECONDS);
        driverManager.getDriver().get(testPropManager.getProperty("base.url"));
    }

    public static void quitFramework(){
        driverManager.getDriver().quit();
    }
}
