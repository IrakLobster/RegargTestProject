package org.egorovvs.framework.managers;

import org.egorovvs.framework.page.HomePage;
import org.egorovvs.framework.page.ThematicPage;

public class PageManager {

    private static PageManager pageManager;

    private HomePage homePage;

    private ThematicPage thematicPage;

    private PageManager(){

    }

    public static PageManager getPageManager(){
        if(pageManager == null) pageManager = new PageManager();
        return pageManager;
    }

    public HomePage getHomePage(){
        if(homePage == null) homePage = new HomePage();
        return homePage;
    }

    public ThematicPage getThematicPage(){
        if(thematicPage == null) thematicPage = new ThematicPage();
        return thematicPage;
    }
}
