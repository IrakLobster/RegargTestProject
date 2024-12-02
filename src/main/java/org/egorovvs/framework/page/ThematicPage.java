package org.egorovvs.framework.page;

import org.egorovvs.framework.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ThematicPage extends BasePage{

    @FindBy(xpath = "//div[@class='rah-static rah-static--height-auto Dropdown_contentWrapper__IqgMi']/div/div/div/div/input[@class='RangeSelector_input__26nqz range-selector-input']")
    private List<WebElement> choicePrice;

    @FindBy(xpath = "//span[@class='PaginationViewChanger_countSetter__count__65Dji']")
    private WebElement productsOnThePage;

    @FindBy(xpath = " //div[@class='CardText_title__7bSbO CardText_listing__6mqXC']")
    private List<WebElement> allProducts;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement findMenu;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/div[1]/div[1]/div[1]/div/h1")
    private WebElement lable;

    private static String productName;

    public void setPrice(String minMax, String price){
        for (WebElement element : choicePrice){
            if(minMax.equals("минимальную")) {
                if (element.getAttribute("name").equals("min")) {
                    element.sendKeys(price);
                }
            }
            else if(minMax.equals("максимальную")) {
                if (element.getAttribute("name").equals("max")) {
                    element.sendKeys(price);
                }
            }
        }

    }

    public void setCheckBox(String param){
        driverManager.getDriver().findElement(By.xpath("//label[@class='Checkbox_fakeCheckbox__BrwB1 Checkbox_red__2iX1_ Checkbox_small___nCE3' and contains(@for,'" + param +"')]/*")).click();
        new WebDriverWait(DriverManager.getDriverManager().getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div[3]/div[2]/div/div/div/div[2]/div/div/span"), param));
    }

    public void checkProductsOnThePage(String productOnThePage){
        scrollToElementJs(productsOnThePage);
        Assertions.assertEquals(productsOnThePage.getText(), "по " + productOnThePage);
    }

    public String getProductName(int positionProductsOnPage){
        productName = allProducts.get(positionProductsOnPage).getText();
        return productName;
    }

    public void findSaveProduct(){
        scrollToElementJs(lable);
        findMenu.sendKeys(getLastFoundProduct() + "\n");
        new WebDriverWait(DriverManager.getDriverManager().getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//div[@class='FilterTags_item__4YpzV FilterTags_item_hideLine__3h_P4']"), productName));
    }

    public String getLastFoundProduct(){
        return productName;
    }

    public void checkCountProduct(int count){
        int a = allProducts.size();
        Assertions.assertEquals(count, a);
    }

    public void doesTheNameMatch(){
        Assertions.assertEquals(productName, getProductName(0));
    }


}
