import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
<<<<<<< HEAD
=======
import org.junit.platform.suite.api.Suite;

>>>>>>> a2a1b5512e184cdb97a584116b88bb32530a4589
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/resources/scenario")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/scenario/cucumberTest.feature")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class CucumberRunner {
<<<<<<< HEAD
    System.out.ptintln("Goodbye world");
=======
    System.out.println("Hello world and good day");
>>>>>>> a2a1b5512e184cdb97a584116b88bb32530a4589
}
