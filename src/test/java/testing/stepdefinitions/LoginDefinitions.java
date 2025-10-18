package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
import testing.tasks.LoginExitoso;
import testing.tasks.SalidaSegura;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.ui.LoginPage.*;

public class LoginDefinitions {
    // Primer escenario

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

    //Segundo escenario @LoginIncorrecto1
    @When("el especialista digita el {string} y la {string}")
    public void elEspecialistaDigitaElYLa(String usuario, String contrasena) {
    }

    @Then("valida mensaje de error intento uno")
    public void validaMensajeDeErrorIntentoUno() {
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
