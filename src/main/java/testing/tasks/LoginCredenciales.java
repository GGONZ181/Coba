package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.ui.LoginUI.*;

public class LoginCredenciales implements Task {
    private final String usuario;
    private final String clave;
    //private final  boolean cerrarModal;


    public LoginCredenciales(String usuario, String clave){
    // public LoginCredenciales(String usuario, String clave,boolean cerrarModal) {
        this.usuario = usuario;
        this.clave = clave;
       // this.cerrarModal = cerrarModal;
    }

    public static LoginCredenciales correctas() {
        return instrumented(LoginCredenciales.class, "iparada", "Bogota123*");
    }

    public static LoginCredenciales incorrectas(String usuario, String clave) {
        return instrumented(LoginCredenciales.class, usuario, clave);
    }
/*
            public static LoginCredenciales incorrectas(String usuario, String clave) {
                return instrumented(LoginCredenciales.class, usuario, clave,true);
            }

    public static LoginCredenciales conCredencialesYCierreDeModal(String usuario, String clave) {
        return instrumented(LoginCredenciales.class, usuario, clave, true);
    }
*/
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
            );
            Thread.sleep(10000); // Espera 10 segundos

            actor.attemptsTo(
                Click.on(BTN_SALIDA_SEGURA)
            );
            Thread.sleep(10000); // Espera 10 segundos

            actor.attemptsTo(
                    Click.on(BTN_SALIDA_ACEPTAR)
            );
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
