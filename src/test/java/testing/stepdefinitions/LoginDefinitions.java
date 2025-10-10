package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
import testing.tasks.LoginExitoso;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.stepdefinitions.hooks.Hooks.ACTOR;
import static testing.ui.LoginPage.*;

public class LoginDefinitions {
    // Primer escenario

    @When("el especialista digita su {string} y {string} correcto")
    public void digitarCredenciales(String usuario, String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginExitoso.correctas(usuario, clave));





/*
    @When("el especialista digita su {string} y {string} correcto")
    public void digitarCredenciales(String usuario, String clave) {
        OnStage.withCurrentActor(LoginExitoso.correctas(usuario, clave));

 */

        /*
        LA FORMA INICIAL COMO LO TENIA
            @When("el especialista digita su usuario y contraseña correcto")
    public void digitarCredenciales() {
        ACTOR.attemptsTo(LoginExitoso.correctas());
    }

    @Then("valida el texto de la pagina")
    // este es el mensaje de cuando ya entra al home
    public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(TITULO_HOME), Matchers.equalTo(MNJ_TITULO_HOME)));
    // este es el de comparar el texto cuando ya tiene sesion abierta, pero no encuentra los elementos:
    // public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(MENSAJE_SESION_ABIERTA), Matchers.equalTo(TXT_MNJ_SESION_ABIERTA)));
    }

         */

    }

    @Then("valida el texto de la pagina")
    // este es el mensaje de cuando ya entra al home
    public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(TITULO_HOME), Matchers.equalTo(MNJ_TITULO_HOME)));
    // este es el de comparar el texto cuando ya tiene sesion abierta, pero no encuentra los elementos:
     //public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(MENSAJE_SESION_ABIERTA), Matchers.equalTo(TXT_MNJ_SESION_ABIERTA)));
    }

    //Segundo escenario @LoginIncorrecto1
    @When("el especialista digita el {string} y la {string}")
    public void elEspecialistaDigitaElYLa(String usuario, String contrasena) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("valida mensaje de error intento uno")
    public void validaMensajeDeErrorIntentoUno() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

/*
    //TERCER FEATURE @LoginIncorrecto2
    @When("el especialista digita el usuario {string} y la contraseña {string} por segunda vez")
    public void digitarCredencialesIncorrectasDos(String usuario, String clave) {
        ACTOR.attemptsTo(LoginFallido.incorrecto(usuario,clave));
    }

    @Then("muestra mensaje: Te quedan 1 intentos de ingreso o se bloqueará el usuario")
    public void verificaMensajeErrorDOS() {
        ACTOR.should(seeThat(TextoQuestion.title(ERROR2), Matchers.equalTo(MNJ_ERROR2))
        );
    }
    //CUARTO FEATURE @LoginIncorrecto2
    @When("el especialista digita el usuario {string} y la contraseña {string} por segunda vez")
    public void digitarCredencialesIncorrectasDOSDOS(String usuario, String clave) {
        ACTOR.attemptsTo(LoginFallido.incorrecto(usuario,clave));
    }

    @Then("muestra mensaje: Te quedan 1 intentos de ingreso o se bloqueará el usuario")
    public void verificaMensajeError() {
        ACTOR.should(
                seeThat(TextoQuestion.title(ERROR2), Matchers.equalTo(MNJ_ERROR2))
        );
    }
*/
}
