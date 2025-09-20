package testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class LoginPage {

    public static final Target TXT_USUARIO = Target.the("campo usuario")
            .located(ByShadow.cssSelector(
                    "input[placeholder='Ingresa el usuario']",        // Selector interno final
                    "sp-ml-xcenter-login-form",                             // Shadow host nivel 1 el de mas afuera
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

    public static final String TXT_MNJ_SESION_ABIERTA = "Deseas ingresar al portal COBA desde esta ventana?";

    /// //
    ///  encuentra el shadow
   // public static final Target ECT_SHADOW = Target.the("boton ingresar")
     //       .locatedBy("//*[@id='bodyd']/app-root/pqrpn-login/sp-ml-modal[5]");

    ///



    public static final Target MENSAJE_SESION_ABIERTA = Target.the("mensaje de sesión abierta")
                .located(ByShadow.cssSelector(
                        "//*[@id='modal']/div/div[2]",        // Selector interno final
                        "//*[@id='bodyd']/app-root/pqrpn-login/sp-ml-modal[5]"               // Shadow host nivel 1
                        // Deseas ingresar al portal COBA desde esta ventana?
                ));

    public static final Target BOTON_ABRIR_AQUI = Target.the("Abrir aqui")
            .located(ByShadow.cssSelector(
                    "//*[@id='modal']/div/div[2]",        // Selector interno final
                    "//*[@id='bodyd']/app-root/pqrpn-login/sp-ml-modal[5]"               // Shadow host nivel 1 mas externo
            ));

    public static final Target TITULO_HOME = Target.the("titulo").
            locatedBy("//body//app-root//div[@class='title-home']//div//div[1]");
    public static final String MNJ_TITULO_HOME = "Puedes observar el estado de las solicitudes realizadas en los últimos 3 meses";


    public static final Target ERROR1 = Target.the("Mensaje error")
            .located(ByShadow.cssSelector(
                    "slot[name='content']",    // Selector interno final
                    "sp-ml-modal:nth-of-type(4)"     // Shadow host (cuarto en orden)
            ));
    public static final String MNJ_ERROR1 = "Te quedan 2 intentos de ingreso o se bloqueará el usuario.";


    public static final Target ERROR2 = Target.the("Mensaje error")
            .located(ByShadow.cssSelector(
                    "slot[name='content']",    // Selector interno final
                    "sp-ml-modal:nth-of-type(4)"     // Shadow host (cuarto en orden)
            ));

    public static final String MNJ_ERROR2 = "Te queda 1 intento de ingreso o se bloqueará el usuario.";

    public static final Target BOTON_ENTENDIDO = Target.the("Botón Entendido ")
            .located(ByShadow.cssSelector(
                    "button", //#\\30 [normalize-space()='Entendido']",               // Selector interno final
                    "sp-ml-modal:nth-of-type(4)"  // Shadow host (cuarto en orden)
            ));





    public static final Target BTN_SALIDA_SEGURA = Target.the("boton Salida Segura")
            .located(ByShadow.cssSelector(
                    "button",
                    "sp-ml-header"
            ));
    public static final Target BTN_SALIDA_ACEPTAR = Target.the("boton Aceptar Salida Segura")
            .located(ByShadow.cssSelector(
                    "#\\30", //"button:nth-of-type(1)",             // Selector interno final
                      "sp-ml-modal:nth-of-type(1)"  // Shadow nivel 1
                    //"(//sp-ml-modal)[1]"
            ));

}
