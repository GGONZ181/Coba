package testing.tasks;

import testing.ui.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ResolverSesionAbierta implements Task {

    public static ResolverSesionAbierta siAparece() {
        return instrumented(ResolverSesionAbierta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>> entro a resolver sesion abierta");
        if (LoginPage.BOTON_INGRESAR_AQUI.resolveFor(actor).isPresent()) {
            System.out.println(">>> si encuentra el boton paso por aqui");
            actor.attemptsTo(
                    WaitUntil.the(LoginPage.BOTON_INGRESAR_AQUI, isVisible())
                            .forNoMoreThan(Duration.ofSeconds(10)),
                    Click.on(LoginPage.BOTON_INGRESAR_AQUI)
            );
        }
        System.out.println(">>> ya paso el if");
    }
}
