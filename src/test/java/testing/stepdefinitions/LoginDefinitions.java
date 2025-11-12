package testing.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import testing.questions.TextoQuestion;
<<<<<<< HEAD
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

    //Segundo escenario @LoginIncorrecto1
    @When("el especialista digita el {string} y la {string}")

    public void elEspecialistaDigitaElYLa(String usuario, String contrasena) {

    public void digitarCredencialesIncorrectas(String usuario, String clave) {
            System.out.println(">>> Ejecutando login con usuario incorrecto: " + usuario + " y/o claveincorrecta");
            OnStage.theActorInTheSpotlight().attemptsTo(
                    LoginFallido.incorrecto(usuario, clave));

    }

    @Then("valida mensaje de error intento uno")
    public void validaMensajeDeErrorIntentoUno() {

   }

        // este es el mensaje: "Usuario o contraseña incorrecta
                               // Te quedan 2 intentos de ingreso o se bloqueará el usuario."
            OnStage.theActorInTheSpotlight().should(
                    seeThat(TextoQuestion.title(MSJ_USUARIO_CLAVE_INCORRECTO1), Matchers.equalTo(MNJ_LOGININCORRECTO1)
            ));
        //Actor actor = null;
        //actor.attemptsTo(Click.on(BTN_ENTENDIDO));


            // este es el de comparar el texto cuando ya tiene sesion abierta, pero no encuentra los elementos:
            //public void verificaTexto() {ACTOR.should(seeThat(TextoQuestion.title(MENSAJE_SESION_ABIERTA), Matchers.equalTo(TXT_MNJ_SESION_ABIERTA)));

        }


    //Tercer Escenario @LoginIncorrecto2
    @When("el especialista digita el usuario {string} y la contraseña {string} incorrecta por segunda vez")
    public void digitarCredencialesIncorrectasDos(String usuario, String clave) {
        System.out.println(">>> Ejecutando login con usuario incorrecto2: " + usuario + " y/o claveincorrecta");
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginFallidoIntDos.incorrecto(usuario, clave));
       // ACTOR.attemptsTo(LoginFallido.incorrecto(usuario,clave));
    }

    @Then("muestra mensaje Te quedan 1 intentos de ingreso o se bloqueará el usuario")
    public void validaMensajeDeErrorIntentoDos() {
        // este es el mensaje: "Usuario o contraseña incorrecta
        //Te quedan 2 intentos de ingreso o se bloqueará el usuario."
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextoQuestion.title(MSJ_USUARIO_CLAVE_INCORRECTO2), Matchers.equalTo(MNJ_LOGININCORRECTO2)
                ));
    }

    //Cuarto Escenario @LoginIncorrecto3 //Excediste el número de intentos
    @When("el especialista digita el usuario {string} y la contraseña {string} incorrecta por tercera vez")
    public void digitarCredencialesIncorrectasTres(String usuario, String clave) {
        System.out.println(">>> Ejecutando login con usuario incorrecto3: " + usuario + " y/o claveincorrecta");
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginFallidoIntTres.incorrecto(usuario, clave));
                   // OnStage.theActorInTheSpotlight().attemptsTo(
                     //       LoginFallidoIntTres.incorrecto(usuario, clave));
                   // ACTOR.attemptsTo(LoginFallido.incorrecto(usuario,clave));
    }

    @Then("muestra mensaje Excediste el número de intentos")
    public void validaMensajeDeErrorIntentoTres() {
        // este es el mensaje: "Usuario o contraseña incorrecta
        //Te quedan 2 intentos de ingreso o se bloqueará el usuario."
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextoQuestion.title(MSJ_BLOQUEO_USUARIO), Matchers.equalTo(MNJ_LOGININCORRECTO3)
                ));
    }

    //Quinto Escenario@LoginBtnDesbloqueoVirtual // Boton Desbloqueo Virtual
    @When("el especialista digita el usuario {string} y la contraseña {string} incorrecta por tercera vez y presiona boton Desbloqueo virtual")
    public void digitarCredencialesIncorrectasBloqueo(String usuario, String clave) {
        System.out.println(">>> Ejecutando login con usuario para Desbloqueo Virtual ");
        OnStage.theActorInTheSpotlight().attemptsTo(
                DesbloqueoUsuario.pagdesbloqueo(usuario, clave));
    }

    @Then("redireccion a pagina del banco de Desbloqueos y reinicios")
    public void validaMensajeDeDesbloqueos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TextoQuestion.title(TITULO_DESBLOQUEO_VIRTUAL), Matchers.equalTo(MNJ_DESBLOQUEO)
                ));

    }
}
