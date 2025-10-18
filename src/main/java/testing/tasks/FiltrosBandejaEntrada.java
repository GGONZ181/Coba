package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static testing.ui.BandejaEntradaPage.*;
import static testing.ui.LoginPage.*;
import static testing.ui.LoginPage.BOTON_INICIAR_AQUI;
import static testing.ui.BandejaEntradaPage.BTN_SALIDA_SEGURA;

public class FiltrosBandejaEntrada  implements Task {

    private final String identificacion;
    private final String tipo_solicitud;
    private final String numero;
    //private final  boolean cerrarModal;


    public FiltrosBandejaEntrada(String identificacion, String tipo_solicitud, String numero) {
        this.identificacion = identificacion;
        this.tipo_solicitud = tipo_solicitud;
        this.numero = numero;

    }


    public static FiltrosBandejaEntrada Filtrodesolicitudesportodoslosestados() {
        return instrumented(FiltrosBandejaEntrada.class, "Todas", "Todas","Vacio");
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on( BTN_SALIDA_SEGURA)
                    //WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isClickable()).forNoMoreThan(20).seconds(),

                    //Click.on(BOTON_ABRIR_AQUI)
                    // <<--- Aquí resuelves el modal si aparece (sin explotar si no aparece)
                    //ResolverSesionAbierta.siAparece(),
                    // Espera a que cargue el home (o el elemento que indique login exitoso)
                    //  WaitUntil.the(HomePage.HOME_INDICATOR, isVisible()).forNoMoreThan(30).seconds()

            );
            System.out.println(">>> presiono ingresar");
            Thread.sleep(10000); // Espera 10 segundos

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
