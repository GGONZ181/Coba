package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
import testing.tasks.ClickOpcionCreacionCoba;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static testing.ui.CreacionCupoPage.MNJ_TITULO_CREACION_CUPO;
import static testing.ui.CreacionCupoPage.TEXTO_CREACION_CUPO;

public class CreacionCupoDefinitions {
/*
    @When("el especialista digita su {string} y {string} correcto y da clic en boton Creacion Coba")
    public void digitarCredenciales(String usuario, String clave) {
        //System.out.println(">>> Ejecutando login con usuario: " + usuario);
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginExitoso.correctas(usuario, clave)
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOpcionCreacionCoba.clickCreacionCoba()
        );

    }
 */
    /*
    @Given("estoy en portal coba")
    public void ingresaPortalCoba(String usuario, String clave) {
    System.out.println(">>> Estoy en portal coba ty voy para creacion");
    /*OnStage.theActorInTheSpotlight().attemptsTo(
            ClickOpcionCreacionCoba.clickCreacionCoba()


    );

}
*/
    @When("de clic en la seccion Creción Coba")
    public void digitarCredenciales(String usuario, String clave) {
        //System.out.println(">>> Ejecutando login con usuario: " + usuario);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOpcionCreacionCoba.clickCreacionCoba()
        );

    }
    @Then("se debe direccionar a esa pantalla y valida el texto de la pantalla")
    // este es el mensaje de cuando ya entra al home
    public void verificaTexto() {OnStage.theActorInTheSpotlight().should(
            seeThat(TextoQuestion.title(TEXTO_CREACION_CUPO), Matchers.equalTo(MNJ_TITULO_CREACION_CUPO)));
        // este es el de comparar el texto cuando ya tiene sesion abierta, pero no encuentra los elementos:
        //public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(MENSAJE_SESION_ABIERTA), Matchers.equalTo(TXT_MNJ_SESION_ABIERTA)));
    }

}
