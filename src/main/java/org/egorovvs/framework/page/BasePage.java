package org.egorovvs.framework.page;

import io.qameta.allure.Attachment;
import org.egorovvs.framework.managers.DriverManager;
import org.egorovvs.framework.managers.PageManager;
import org.egorovvs.framework.managers.TestPropManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    protected PageManager pageManager = PageManager.getPageManager();

    protected Actions action = new Actions(driverManager.getDriver());

    protected WebDriverWait webDriverWait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(10));

    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
