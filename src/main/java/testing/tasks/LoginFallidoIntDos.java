package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.ui.LoginPage.*;

public class LoginFallidoIntDos implements Task {
    private final String usuario;
    private final String clave;
    //private final  boolean cerrarModal;

    public LoginFallidoIntDos(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }

    public static LoginFallidoIntDos incorrecto(String usuario, String clave) {
                return instrumented(LoginFallidoIntDos.class, usuario, clave);
            }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR),

                    /// /TIT_USUARIO_CLAVE_INCORRECTO
                    //WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isClickable()).forNoMoreThan(20).seconds(),
                    WaitUntil.the(LoginPage.TITULO_USUARIO_CLAVE_INCORRECTO2, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_ENTENDIDO),
                    Click.on(BTN_INGRESAR)
            );
            System.out.println(">>> presionó ingresar EN LOGIN FALLIDO1: " + MSJ_USUARIO_CLAVE_INCORRECTO2);
            Thread.sleep(10000); // Espera 10 segundos


           /* actor.attemptsTo(
                Click.on(BTN_SALIDA_SEGURA)
            );
            Thread.sleep(10000); // Espera 10 segundos

            actor.attemptsTo(
                    Click.on(BTN_SALIDA_ACEPTAR)

            );
            */
/*
// espera explicita con wait
//espera explícita con la clase Wait, puedes hacerlo con la tarea WaitUntil, que es parte del paquete net.serenitybdd.screenplay.waits.
        WaitUntil.the(BTN_SALIDA_SEGURA, isVisible()).forNoMoreThan(10).seconds(),
        Click.on(BTN_SALIDA_SEGURA),

        WaitUntil.the(BTN_SALIDA_ACEPTAR, isEnabled()).forNoMoreThan(10).seconds(),
        Click.on(BTN_SALIDA_ACEPTAR)

*/
/*
        if (cerrarModal) {
            actor.attemptsTo(
                    WaitUntil.the(BOTON_ENTENDIDO, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(BOTON_ENTENDIDO)
            );

        };
*/

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
