package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
//import net.serenitybdd.screenplay.waits.WaitUntil;

//import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
//import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
//import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.ui.LoginPage.*;



public class LoginExitoso implements Task {
    private final String usuario;
    private final String clave;
    //private final  boolean cerrarModal;


    public LoginExitoso(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }

    public static LoginExitoso correctas() {
        return instrumented(LoginExitoso.class, "iparada", "Bogota123*");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
               //  WaitUntil.the(BOTON_ABRIR_AQUI, isVisible()).forNoMoreThan(Duration.ofSeconds(40)),
               // ResolverSesionAbierta.siAparece()
            );
            Thread.sleep(10000); // Espera 10 segundos

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
