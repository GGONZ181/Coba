package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import static testing.ui.LoginPage.*;


public class LoginExitoso implements Task {
    private final String usuario;
    private final String clave;
    //private final  boolean cerrarModal;


    public LoginExitoso(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static LoginExitoso correctas(String usuario, String clave) {
        return instrumented(LoginExitoso.class,  usuario,  clave);

    }
	



    /* COMO LO TENIA ANTES
        public static LoginExitoso correctas() {
        return instrumented(LoginExitoso.class, "iparada", "Bogota123*");
    }*/
    


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(usuario).into(TXT_USUARIO),
                    Enter.theValue(clave).into(TXT_CLAVE),
                    Click.on(BTN_INGRESAR),

                    ResolverSesionAbierta.siAparece(),
                    WaitUntil.the(LoginPage.MENSAJE_SESION_ABIERTA, isVisible()).forNoMoreThan(30).seconds()

            );
            //System.out.println(">>> presiono ingresar");

                    /*
                            //WaitUntil.the(LoginPage.BOTON_INGRESAR_AQUI, isClickable()).forNoMoreThan(20).seconds(),

                                    //Click.on(BOTON_ABRIR_AQUI)
                            // <<--- Aquí resuelves el modal si aparece (sin explotar si no aparece)
                           // ResolverSesionAbierta.siAparece()
                            // Espera a que cargue el home (o el elemento que indique login exitoso)
                            //  WaitUntil.the(HomePage.HOME_INDICATOR, isVisible()).forNoMoreThan(30).seconds()
                    */

                    // Espera a que desaparezca el modal de carga (si existe)
                    WaitUntil.the(MODAL_ESPERAUN_MOMENTO, isNotVisible()).forNoMoreThan(20).seconds(),

                    // Condicional: si aparece el botón del modal, resolver sesión abierta
                    Check.whether(LoginPage.BOTON_INGRESAR_AQUI.resolveFor(actor).isPresent())
                            .andIfSo(
                                    ResolverSesionAbierta.siAparece()
                            ),

                    // Validar que el texto del Home esté visible (login exitoso)
                    WaitUntil.the(LoginPage.TITULO_HOME, isVisible()).forNoMoreThan(30).seconds()


            );
            System.out.println(">>> presionó ingresar EN LOGIN EXITOSO");

            Thread.sleep(10000); // Espera 10 segundos

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
