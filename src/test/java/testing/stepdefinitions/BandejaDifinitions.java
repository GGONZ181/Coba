package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
import testing.tasks.FiltrosBandejaEntrada;
import testing.tasks.LoginExitoso;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.ui.LoginPage.MNJ_TITULO_HOME;
import static testing.ui.LoginPage.TITULO_HOME;

public class BandejaDifinitions {


    @When("se selecciona el estado Todas con filtro {string}, filtro {string} y filtro {string} luego se oprime el boton filtrar")
     public void Filtrodesolicitudesportodoslosestados(String identificacion, String tipo_solicitud, String numero) {
        OnStage.theActorInTheSpotlight().attemptsTo(FiltrosBandejaEntrada.Filtrodesolicitudesportodoslosestados());

/*
    @When("el especialista digita su {string} y {string} correcto")
    public void digitarCredenciales(String usuario, String clave) {
        OnStage.withCurrentActor(LoginExitoso.correctas(usuario, clave));

 */

    }

    @Then("debe mostrar los datos que cumplen con los filtros seleccionados")
    // este es el mensaje de cuando ya entra al home
    public void verificaTexto() {OnStage.theActorInTheSpotlight().should(seeThat(TextoQuestion.title(TITULO_HOME), Matchers.equalTo(MNJ_TITULO_HOME)));
        // este es el de comparar el texto cuando ya tiene sesion abierta, pero no encuentra los elementos:
        //public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(MENSAJE_SESION_ABIERTA), Matchers.equalTo(TXT_MNJ_SESION_ABIERTA)));
    }
}
