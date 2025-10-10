package testing.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class BandejaEntradaPage {
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
