package org.egorovvs.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {

    private final Properties properties = new Properties();

    private static TestPropManager testPropManager = null;

    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperies();
    }

    public static TestPropManager getTestPropManager() {
        if (testPropManager == null) testPropManager = new TestPropManager();
        return testPropManager;
    }

    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream(new File("src/main/resources/" + System.getProperty("propFile", "applications") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomProperies() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) && !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }

    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }




}
