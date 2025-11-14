package testing.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        //features = "src/test/resources/features/search/" ,
        features = "src/test/resources/features/search/Login.feature",
        //features = "src/test/resources/features/search/BandejaEntrada.feature",
        //features = "src/test/resources/features/search/AumentoCupo.feature",
        glue = "testing/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        //,
        //tags = "@LoginExitoso"
        //tags = "@LoginIncorrecto1"
        //tags = "@LoginIncorrecto2"  // "@SolicitudesEstados"  //
        //tags = "@LoginIncorrecto3"
        //tags = "@LoginBtnDesbloqueoVirtual"
 )
public class CucumberTestSuiteTest {}



