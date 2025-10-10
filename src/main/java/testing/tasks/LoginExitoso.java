package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.LoginPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import java.time.Duration;
//import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
//import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
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

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(usuario).into(TXT_USUARIO),
                    Enter.theValue(clave).into(TXT_CLAVE),
                    Click.on(BTN_INGRESAR),
                    WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isClickable()).forNoMoreThan(20).seconds(),

                    Click.on(BOTON_ABRIR_AQUI)
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

/*
public class LoginExitoso implements Task {
    private final String usuario;
    private final String clave;
    //private final  boolean cerrarModal;


    public LoginExitoso(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                Enter.theValue(this.usuario).into(TXT_USUARIO),
                Enter.theValue(this.clave).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR));
            System.out.println(">>> presiono ingresar");

                    //WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isClickable()).forNoMoreThan(10).seconds(),
                    //Click.on(BOTON_ABRIR_AQUI)
           // actor.attemptsTo(
            //        WaitUntil.the(LoginPage.BOTON_ABRIR_AQUI, isVisible()).forNoMoreThan(10).seconds()
            //);
            //System.out.println(">>> espera para el boton abrir aqui");

            actor.attemptsTo(
                // <<--- Aquí resuelves el modal si aparece (sin explotar si no aparece)
                ResolverSesionAbierta.siAparece());

                // Espera a que cargue el home (o el elemento que indique login exitoso)
                //  WaitUntil.the(HomePage.HOME_INDICATOR, isVisible()).forNoMoreThan(30).seconds()


            Thread.sleep(10000); // Espera 10 segundos

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static LoginExitoso correctas(String usuario, String clave) {
        return instrumented(LoginExitoso.class, usuario, clave);
    }

}
*/