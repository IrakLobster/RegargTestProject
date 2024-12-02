package org.egorovvs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.egorovvs.framework.managers.InitManager;

public class Hooks {

    @Before
    public void before(){
        InitManager.getInitManager().initFramework();
    }

    @After
    public void afterr(){

    }

    @AfterAll
    public static void after(){
        InitManager.quitFramework();
    }
}
