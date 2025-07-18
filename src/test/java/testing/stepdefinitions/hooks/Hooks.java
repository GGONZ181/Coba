package testing.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver = Serenity.getDriver();
    public static final Actor ACTOR = Actor.named("Edwar");

    @Before
    public void setUp(Scenario scenario) {
        OnStage.setTheStage(
                new OnlineCast()
        );
        ACTOR.whoCan(
                BrowseTheWeb.with(driver)
        );
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }
}
