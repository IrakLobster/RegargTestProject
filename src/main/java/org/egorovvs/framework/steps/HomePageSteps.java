package org.egorovvs.framework.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Allure;
import org.egorovvs.framework.managers.DriverManager;
import org.egorovvs.framework.managers.PageManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomePageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @Когда("^Кликаем на вкладку Каталог$")
    public void clickCatalog(){
        pageManager.getHomePage().clickCatalog();
        pageManager.getHomePage().saveAllureScreenshot();

    }

    @И("^Выбираем категорию (.+)$")
    public void coiceCatalogElement(String element){
        pageManager.getHomePage().coiceCatalogElement(element);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^Выбираем подкатегорию (.+)$")
    public void coiceChapter(String chapter){
        pageManager.getHomePage().coiceChapter(chapter);
        pageManager.getHomePage().saveAllureScreenshot();
    }
}
