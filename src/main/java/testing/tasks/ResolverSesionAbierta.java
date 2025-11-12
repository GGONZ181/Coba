package testing.tasks;

import net.serenitybdd.screenplay.conditions.Check;
import testing.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.ui.LoginPage.BOTON_INGRESAR_AQUI;
import static testing.ui.LoginPage.MODAL_SESION_ACTIVA;

public class ResolverSesionAbierta implements Task {

    public static ResolverSesionAbierta siAparece() {
        return new ResolverSesionAbierta();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>> Entro a clase ResolverSesionAbierta");
        actor.attemptsTo(
                WaitUntil.the(MODAL_SESION_ACTIVA, isVisible()).forNoMoreThan(5).seconds(),
                Check.whether(MODAL_SESION_ACTIVA.resolveFor(actor).isVisible())
                        .andIfSo(
                                WaitUntil.the(BOTON_INGRESAR_AQUI, isVisible()).forNoMoreThan(10).seconds(),
                                Click.on(BOTON_INGRESAR_AQUI)
                        )
                /* // Condicional: si aparece el botón del modal, resolver sesión abierta
                    Check.whether(LoginPage.BOTON_INGRESAR_AQUI.resolveFor(actor).isPresent())
                            .andIfSo(
                                    ResolverSesionAbierta.siAparece()
                            ),*/
        );

        System.out.println(">>> entro a resolver sesion abierta, sigue un if");
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
