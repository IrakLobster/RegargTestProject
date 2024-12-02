package org.egorovvs.framework.page;

import org.egorovvs.framework.managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'NavigationBar_burgerButton')]")
    private WebElement catalog;

    @FindBy(xpath = "//div[@class='Catalog_mainCategoryName__xzGxz']")
    private List<WebElement> catalogElement;

    @FindBy(xpath = "//a[@class='Category_subTitle__TFxrn link_black']/span[@itemprop='name']")
    private List<WebElement> chapters;


    public void clickCatalog(){
        catalog.click();
    }

    public void coiceCatalogElement(String element){
        for (WebElement elements : catalogElement){
            if(elements.getText().equals(element)){
                new Actions(DriverManager.getDriverManager().getDriver()).moveToElement(elements).perform();
                return;
            }
        }
    }

    public void coiceChapter(String chapter){
        for(WebElement elements : chapters){
            if(elements.getText().equals(chapter)){
                elements.click();
                return;
            }
        }
    }
}
