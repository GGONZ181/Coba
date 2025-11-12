package testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class BandejaEntradaPage {


    public static final Target TITULO_HOME = Target.the("titulo").
            locatedBy("//body//app-root//div[@class='title-home']//div//div[1]"); //Puedes observar el estado de las solicitudes realizadas en los últimos 3 meses
    public static final String MNJ_TITULO_HOME = "Puedes observar el estado de las solicitudes realizadas en los últimos 3 meses";
    /*
        public static final Target BTN_SALIDA_SEGURA = Target.the("boton Salida Segura")
                .located(ByShadow.cssSelector(
                        "//*[@id='sp-ml-header__close']",  // "//*[@id='sp-ml-header__close']",
                        ///"sp-ml-header"  ///
                        "sp-ml-header:nth-of-type(1)"
                ));
        public static final Target BTN_SALIDA_ACEPTAR = Target.the("boton Aceptar Salida Segura")
                .located(ByShadow.cssSelector(
                        "#\\30", //"button:nth-of-type(1)",             // Selector interno final
                        "sp-ml-modal:nth-of-type(1)"  // Shadow nivel 1
                        //"(//sp-ml-modal)[1]"
                ));
    */
    // -------- FILTROS --------
    public static final Target CLIC_FILTRO_ESTADO = Target.the("filtro Estado de solicitud")
            .located(ByShadow.cssSelector("#dropdown_1_arrow","#state-search"));

    public static final Target OPCION_ESTADO_TODAS = Target.the("Opcion Todas")  //"opción de estado {0}")
            .located(ByShadow.cssSelector("#option-Todas","#state-search"));

    public static final Target OPCION_ESTADO_RECHAZADO = Target.the("filtro Estado de solicitud Rechazada")
            .located(ByShadow.cssSelector("#option-Rechazada","#state-search"));



    public static final Target CLIC_FILTRO_IDENTIFICACION = Target.the("filtro Identificación")
            .located(ByShadow.cssSelector("#dropdown_2_arrow","#id-type2"));

    public static final Target OPCION_IDENTIFICACION_TODAS = Target.the("Opcion Todas")  //"opción de estado {0}")
            .located(ByShadow.cssSelector("#option-Todas","#id-type2"));

    public static final Target OPCION_IDENTIFICACION_CEDULA = Target.the("Opcion Todas")
            .located(ByShadow.cssSelector("#option-C","#id-type2"));

    public static final Target OPCION_IDENTIFICACION_CEDULAEXT = Target.the("Opcion Todas")
            .located(ByShadow.cssSelector("#option-E","#id-type2"));

    public static final Target OPCION_IDENTIFICACION_NIT_PN = Target.the("Opcion Todas")
            .located(ByShadow.cssSelector("#option-L","#id-type2"));

    public static final Target OPCION_IDENTIFICACION = Target.the("opción de identificación {0}")
            .locatedBy("//div[contains(@class,'menu')]//span[normalize-space(text())='{0}']");

    public static final Target FILTRO_NUMERO = Target.the("campo Número (opcional)")
            .locatedBy("//input[@placeholder='#']");

    public static final Target FILTRO_TIPO_SOLICITUD = Target.the("filtro Tipo de solicitud")
            .locatedBy("//label[contains(text(),'Tipo de solicitud')]/following-sibling::div//input");

    public static final Target OPCION_TIPO_SOLICITUD = Target.the("opción tipo de solicitud {0}")
            .locatedBy("//div[contains(@class,'menu')]//span[normalize-space(text())='{0}']");

    public static final Target BOTON_FILTRAR = Target.the("botón Filtrar")
            .locatedBy("//button[normalize-space()='Filtrar']");

    // -------- TABLA RESULTADOS --------
    public static final Target TABLA_RESULTADOS = Target.the("tabla de resultados")
            .locatedBy("//table[contains(@class,'MuiTable-root')]");

    public static final Target FILAS_TABLA = Target.the("filas de la tabla")
            .locatedBy("//table//tbody//tr");
}
