package org.egorovvs.framework.steps;

import io.cucumber.java.ru.И;
import org.egorovvs.framework.managers.InitManager;
import org.egorovvs.framework.managers.PageManager;

public class ThematicPageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^выбираем (.*) цену товара (.*)$")
    public void setPrice(String minMax, String price){
        pageManager.getThematicPage().setPrice(minMax, price);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^выбираем производителя (.*)$")
    public void setCheckBox(String param){
        pageManager.getThematicPage().setCheckBox(param);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^проверяем, что в поисковой выдаче не более (.*) товаров$")
    public void checkProductsOnThePage(String productOnThePage){
        pageManager.getThematicPage().checkProductsOnThePage(productOnThePage);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^сохраняем наименование товара с позицией (.*)$")
    public void getProductName(int positionProductsOnPage){
        pageManager.getThematicPage().getProductName(positionProductsOnPage);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^вводим сохраненный товар в строку поиска и выполняем поиск$")
    public void findSaveProduct(){
        pageManager.getThematicPage().findSaveProduct();
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^проверяем, что в поисковой выдаче найден (.*) товар$")
    public void checkCountProduct(int count){
        pageManager.getThematicPage().checkCountProduct(count);
        pageManager.getHomePage().saveAllureScreenshot();
    }

    @И("^проверяем, что наименование товара соответствует сохраненному значению$")
    public void doesTheNameMatch(){
        pageManager.getThematicPage().doesTheNameMatch();
        pageManager.getHomePage().saveAllureScreenshot();
    }
}
