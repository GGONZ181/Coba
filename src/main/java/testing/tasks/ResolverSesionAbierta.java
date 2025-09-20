package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.LoginPage;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ResolverSesionAbierta implements Task {

    public static ResolverSesionAbierta siAparece() {
        return Tasks.instrumented(ResolverSesionAbierta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        /*
        if (LoginPage.MENSAJE_SESION_ABIERTA.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(LoginPage.BOTON_ABRIR_AQUI)

         */

        if (LoginPage.BOTON_ABRIR_AQUI.resolveFor(actor).isPresent()) {
            actor.attemptsTo(
                   WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isVisible()).forNoMoreThan(Duration.ofSeconds(100)),
                    Click.on(LoginPage.BOTON_ABRIR_AQUI));
            /*
            if (LoginPage.MENSAJE_SESION_ABIERTA.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(LoginPage.BOTON_ABRIR_AQUI)

                );

            }
            */
        }
    }
}

