package testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class LoginUI {

    public static final Target TITULO = Target.the("titulo").
            locatedBy("//body//app-root//div[@class='title-home']//div//div[1]");
    public static final String MNJ_TITULO = "Puedes observar el estado de las solicitudes realizadas en los últimos 3 meses";


    public static final Target ERROR1 = Target.the("Mensaje error")
            .located(ByShadow.cssSelector(
                    "slot[name='content']",    // Selector interno
                    "sp-ml-modal:nth-of-type(4)"  // Shadow host (cuarto en orden)
            ));

    public static final String MNJ_ERROR1 = "Te quedan 2 intentos de ingreso o se bloqueará el usuario.";



    public static final Target TXT_USUARIO = Target.the("campo usuario")
            .located(ByShadow.cssSelector(
                "input[placeholder='Ingresa el usuario']",        // Selector interno final
                "sp-ml-xcenter-login-form",                             // Shadow host nivel 1
                    "sp-at-input[id-el='user']"        // Shadow host nivel 2
            ));

    public static final Target TXT_CLAVE = Target.the("campo clave")
            .located(ByShadow.cssSelector(
                    "input[placeholder='Ingresa la contraseña']",
                    "sp-ml-xcenter-login-form",
                    "sp-at-input[id-el='password']"
            ));

    public static final Target BTN_INGRESAR = Target.the("boton ingresar")
            .located(ByShadow.cssSelector(
                    "button",
                    "sp-ml-xcenter-login-form"
            ));
}
