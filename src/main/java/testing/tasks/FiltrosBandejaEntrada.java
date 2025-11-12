package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.BandejaEntradaPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static testing.ui.BandejaEntradaPage.*;
import static testing.ui.LoginPage.*;

//import static testing.ui.BandejaEntradaPage.BTN_SALIDA_SEGURA;

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

    public static FiltrosBandejaEntrada Filtrodesolicitudesportodoslosestados(String identificacion, String tipo_solicitud, String numero) {
        return instrumented(FiltrosBandejaEntrada.class, identificacion, tipo_solicitud,numero);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(BandejaEntradaPage.CLIC_FILTRO_ESTADO, isClickable()).forNoMoreThan(20).seconds(),
                    Click.on( CLIC_FILTRO_ESTADO),
                    Click.on(OPCION_ESTADO_RECHAZADO),
                    Click.on(CLIC_FILTRO_IDENTIFICACION),
                    Click.on(OPCION_IDENTIFICACION_TODAS),
                    Click.on(CLIC_FILTRO_IDENTIFICACION),
                    Click.on(OPCION_IDENTIFICACION_CEDULA),
                    Click.on(CLIC_FILTRO_IDENTIFICACION),
                    Click.on(OPCION_IDENTIFICACION_CEDULAEXT),
                    Click.on(CLIC_FILTRO_IDENTIFICACION),
                    Click.on(OPCION_IDENTIFICACION_NIT_PN)

                    /// ///////////////

                    // FALTA EL FITLRO DE TIPO SOLICITUD Y PRESIONAR EL BOTON FILTRO

                    /// ///////////////


                    //WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isClickable()).forNoMoreThan(20).seconds(),

                    //Click.on(BOTON_ABRIR_AQUI)
                    // <<--- Aquí resuelves el modal si aparece (sin explotar si no aparece)
                    //ResolverSesionAbierta.siAparece(),
                    // Espera a que cargue el home (o el elemento que indique login exitoso)
                    //  WaitUntil.the(HomePage.HOME_INDICATOR, isVisible()).forNoMoreThan(30).seconds()

                    /* esto es lo que tenia adelantado daniela
                           // Estado
                                    actor.attemptsTo(
                                            WaitUntil.the(CLIC_FILTRO_ESTADO, isClickable()),
                                            Click.on(CLIC_FILTRO_ESTADO)
                                            //,
                                            //Click.on(OPCION_ESTADO_RECHAZADO.of(estado))
                                    );

                                    // Identificación
                                    actor.attemptsTo(
                                            Click.on(FILTRO_IDENTIFICACION),
                                            Click.on(OPCION_IDENTIFICACION.of(identificacion))
                                    );

                                    // Tipo solicitud
                                    actor.attemptsTo(
                                            Click.on(FILTRO_TIPO_SOLICITUD),
                                            Click.on(OPCION_TIPO_SOLICITUD.of(tipoSolicitud))
                                    );

                                    // Número (opcional)
                                    if (!numero.equalsIgnoreCase("Vacio") && !numero.trim().isEmpty()) {
                                        actor.attemptsTo(Enter.theValue(numero).into(FILTRO_NUMERO));
                                    }

                                    // Botón Filtrar
                                    actor.attemptsTo(
                                            Click.on(BOTON_FILTRAR)
                                    );


                     */

            );
            System.out.println(">>> consultó segun filtros");
            Thread.sleep(10000); // Espera 10 segundos

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
