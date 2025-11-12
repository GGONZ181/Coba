package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;

import testing.tasks.LoginExitoso;
import testing.tasks.SalidaSegura;

import testing.tasks.*;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.ui.LoginPage.*;

public class LoginDefinitions {

    // Primer escenario Logueo Exitoso
    @When("el especialista digita su {string} y {string} correcto")
    public void digitarCredenciales(String usuario, String clave) {
        //System.out.println(">>> Ejecutando login con usuario: " + usuario);
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginExitoso.correctas(usuario, clave));
    }

    @Then("valida el texto de la pagina")
    // este es el mensaje de cuando ya entra al home
    public void verificaTexto() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextoQuestion.title(TITULO_HOME), Matchers.equalTo(MNJ_TITULO_HOME))
        );

        // Ejecuta la tarea de salida segura después de validar el título
        OnStage.theActorInTheSpotlight().attemptsTo(
                SalidaSegura.salir()
        );

    }
}
