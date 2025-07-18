package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static testing.ui.LoginUI.*;

public class LoginCredenciales implements Task {
    private final String usuario;
    private final String clave;

    public LoginCredenciales(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static LoginCredenciales correctas() {
        return instrumented(LoginCredenciales.class, "iparada", "Bogota123*");
    }

    public static LoginCredenciales incorrectas(String usuario, String clave) {
        return instrumented(LoginCredenciales.class, usuario, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
        );
        try {
            Thread.sleep(8000); // espera 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
