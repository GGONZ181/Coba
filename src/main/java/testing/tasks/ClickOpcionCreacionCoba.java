package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
//import testing.ui.LoginPage;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.ui.BandejaEntradaPage.OPCION_CREACION_COBA;


public class ClickOpcionCreacionCoba implements Task {

    public static ClickOpcionCreacionCoba clickCreacionCoba() {
        return new ClickOpcionCreacionCoba();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>> Entro a clase  ClickOpcionCreacionCoba");
        actor.attemptsTo(
                WaitUntil.the(OPCION_CREACION_COBA, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(OPCION_CREACION_COBA)
        );
    }
}
