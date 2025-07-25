package testing.stepdefinitions.commons;


import io.cucumber.java.en.Given;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import static testing.stepdefinitions.hooks.Hooks.ACTOR;

public class StepUrl {
    private static final String PAGE_URL = "pages.url";

    @Given("que el usuario se encuentra en la pagina de Login")
    public void abreLaPagina() {
        ACTOR.attemptsTo(
                Open.browserOn().thePageNamed(PAGE_URL)
        );
    }

}
