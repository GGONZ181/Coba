package testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class LoginPage {

    public static final Target TXT_USUARIO = Target.the("Campo usuario")
            .located(ByShadow.cssSelector(
                    "input[placeholder='Ingresa el usuario']",        // Selector interno final
                    "sp-ml-xcenter-login-form",                             // Shadow host nivel 1 el de mas afuera, el que contiene al otro shadow
                    "sp-at-input[id-el='user']"        // Shadow host nivel 2
            ));

    public static final Target TXT_CLAVE = Target.the("Campo clave")
            .located(ByShadow.cssSelector(
                    "input[placeholder='Ingresa la contraseña']",
                    "sp-ml-xcenter-login-form",
                    "sp-at-input[id-el='password']"
            ));

    public static final Target BTN_INGRESAR = Target.the("Boton ingresar")
            .located(ByShadow.cssSelector(
                    "button",
                    "sp-ml-xcenter-login-form"
            ));

    public static final Target MODAL_ESPERAUN_MOMENTO = Target.the("Espera un momento, por favor") // Puntos de colores que giran
            .locatedBy("//*[@id='bodyd']/app-root/pqrpn-login/sp-ml-loader");

    public static final Target MODAL_SESION_ACTIVA = Target.the("Modal de sesión activa")// Deseas ingresar al portal COBA desde esta ventana?
            .located(ByShadow.cssSelector (
                    ".sp-ml-modal__content__box__sub-title", // selector interno por clase
                    "sp-ml-modal:nth-of-type(5)" // shadow host
            ));

    //public static final String TXT_MNJ_SESION_ABIERTA = "Deseas ingresar al portal COBA desde esta ventana?";
/*
    public static final Target BOTON_INICIAR_AQUI = Target.the("Botón iniciar sesión aquí")
            .located(ByShadow.cssSelector(
                    //"button#1",
                    //"button\\31",
                    //"sp-ml-modal:nth-of-type(5)",
                    ".sp-ml-modal__content__box__options__btn-right",
                    "sp-ml-modal:nth-of-type(5)" // shadow host
            ));
 */
/*
    public static final Target BOTON_REGRESAR = Target.the("botón regresar y no iniciar sesión ")
            .located(ByShadow.cssSelector(
                    "button.sp-ml-modal__content__box__options__btn-left",
                    //"button#0",  //
                    "button\\30",
                    "sp-ml-modal:nth-of-type(5)" // shadow host
            ));
*/

    // este que sigue es como repetido del modal sesion abierta:
    public static final Target MENSAJE_SESION_ABIERTA = Target.the("mensaje de sesión abierta")
            .located(ByShadow.cssSelector(
                    "slot[name='content']",
                    //".sp-ml-modal__content__box__sub-title",
                    //".sp-ml-modal__content__box__title",
                    "sp-ml-modal:nth-of-type(5)"
            ));

// repetido con BOTON_INICIAR_AQUI ??
    public static final Target BOTON_INGRESAR_AQUI = Target.the("Abrir aqui")
            .located(ByShadow.cssSelector(
                            //"#//31 ",
                            "#modal > div > div.sp-ml-modal__content__box__options.btn-none-false > div.sp-ml-modal__content__box__options__btn-right",
                            "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(8)")    // Shadow host nivel 1 mas externo
                    //Boton_ingresar_aqui del modal='Deseas ingresar al portal COBA desde esta ventana?']"
            );


    public static final Target TITULO_HOME = Target.the("titulo").
            locatedBy("//body//app-root//div[@class='title-home']//div//div[1]");
    public static final String MNJ_TITULO_HOME = "Puedes observar el estado de las solicitudes realizadas en los últimos 3 meses";

    public static final Target TITULO_USUARIO_CLAVE_INCORRECTO = Target.the("Mensaje error: Usuario o contraseña incorrecta")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__title",    // elemento : Texto: Usuario o contraseña incorrecta
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(7)"));  // Shadow
    public static final Target MSJ_USUARIO_CLAVE_INCORRECTO1 = Target.the("Mensajeerror") // error: Te quedan 2 intentos de ingreso o se bloqueará el usuario..")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__sub-title > slot",    // elemento : Texto: Te quedan 2 intentos de ingreso o se bloqueará el usuario.
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(7)"));  // Shadow
    public static final String MNJ_LOGININCORRECTO1 = "Te quedan 2 intentos de ingreso o se bloqueará el usuario.";


    public static final Target BTN_ENTENDIDO = Target.the("Mensaje error: Usuario o contraseña incorrecta")
            .located(ByShadow.cssSelector(
                    "#\\30 ",    // elemento: Boton: Entendido
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(7)"));  // Shadow
    ///
// este que sigue es el mismo mensaje y mismo localizador del intento 1, se puede borrar creo.
    public static final Target TITULO_USUARIO_CLAVE_INCORRECTO2 = Target.the("Mensaje error: Usuario o contraseña incorrecta")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__title",    // elemento : Texto: Usuario o contraseña incorrecta
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(7)"));  // Shadow
    // este que sigue es el mismo localizador del intento 1, solo cambiaria el texto
    public static final Target MSJ_USUARIO_CLAVE_INCORRECTO2 = Target.the("Mensajeerror2") // error: Te quedan 2 intentos de ingreso o se bloqueará el usuario..")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__sub-title > slot",    // elemento : Texto: Te quedan 2 intentos de ingreso o se bloqueará el usuario.
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(7)"));  // Shadow
    public static final String MNJ_LOGININCORRECTO2 = "Te queda 1 intento de ingreso o se bloqueará el usuario.";
    public static final String MNJ_LOGININCORRECTO3 = "Por tu seguridad hemos bloqueado tu usuario. Puedes desbloquearlo virtualmente o llamar a la servílinea de tu ciudad.";

    public static final Target BTN_DESBLOQUEO_VIRTUAL = Target.the("Btn Mensaje:Excediste el número de intentos")
            .located(ByShadow.cssSelector(
                    "#\\30 ",    // elemento: Boton: Desbloqueo Virtual
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(5)"));  // Shadow
    ///
    public static final Target MSJ_EXCEDISTE_NRO_INTENTOS = Target.the("Mensaje: Excediste el número de intentos")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__title",    // elemento : Texto: Excediste el número de intentos
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(5)"));  // Shadow


    public static final Target MSJ_BLOQUEO_USUARIO = Target.the("Mensaje: Por tu seguridad hemos bloqueado tu usuario. Puedes desbloquearlo virtualmente o llamar a la servílinea de tu ciudad.")
            .located(ByShadow.cssSelector(
                    "#modal > div > div.sp-ml-modal__content__box__sub-title > slot",    // elemento : Texto: Excediste el número de intentos
                    "#bodyd > app-root > pqrpn-login > sp-ml-modal:nth-child(5)"));  // Shadow

    public static final String MNJ_DESBLOQUEO = "Bienvenido (a) a desbloqueos y reinicios";

    public static final Target TITULO_DESBLOQUEO_VIRTUAL = Target.the("Pagina Bienvenido (a) a desbloqueos y reinicios")
            .locatedBy("/html/body/app-root/main/app-login/main/div[1]");

}
