package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
//import static testing.ui.BandejaEntradaPage.BTN_SALIDA_SEGURA;

public class SalidaSegura implements Task {

    public static SalidaSegura salir() {
        return new SalidaSegura();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>> Entro a SalidaSegura");
        /*
        actor.attemptsTo(
                WaitUntil.the(BTN_SALIDA_SEGURA, isVisible()).forNoMoreThan(5).seconds(),
                Check.whether(BTN_SALIDA_SEGURA.resolveFor(actor).isVisible())
                        .andIfSo(
                                Click.on(BTN_SALIDA_SEGURA)
                       )
        );

         */
    }
}