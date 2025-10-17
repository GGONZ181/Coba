package testing.stepdefinitions.commons;


import io.cucumber.java.en.Given;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepUrl {
    private static final String PAGE_URL = "pages.url";

    @Given("que el usuario se encuentra en la pagina de Login")
    public void abreLaPagina() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.browserOn().thePageNamed(PAGE_URL)

        );
    }

}
