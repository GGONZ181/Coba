package testing.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
import testing.tasks.LoginCredenciales;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.stepdefinitions.hooks.Hooks.ACTOR;
import static testing.ui.LoginUI.*;

public class LoginDefinitions {
    // PRIMER FEATURE
    @When("el especialista digita su usuario y contraseña correcto")
    public void digitarCredenciales() {
        ACTOR.attemptsTo(LoginCredenciales.correctas());
    }

    @Then("valida el texto de la pagina")
    public void verificaTexto() {
        ACTOR.should(
                seeThat(TextoQuestion.title(TITULO), Matchers.equalTo(MNJ_TITULO))
        );
    }

    //SEGUNDO FEATURE
    @When("el especialista digita el usuario {string} y la contraseña {string}")
    public void digitarCredenciales(String usuario, String clave) {
        ACTOR.attemptsTo(
                LoginCredenciales.incorrectas(usuario,clave)
        );
    }

    @Then("valida mensaje de error")
    public void verificaMensajeError() {
        ACTOR.should(
                seeThat(TextoQuestion.title(ERROR1), Matchers.equalTo(MNJ_ERROR1))
        );
    }

}
