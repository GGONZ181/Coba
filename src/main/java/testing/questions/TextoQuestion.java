package testing.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TextoQuestion implements Question<String> {
    private final Target text;

    public TextoQuestion(Target text) {
        this.text = text;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade tituloElemento = text.resolveFor(actor);
        return tituloElemento.getText();
    }

    public static Question<String> title(Target text) {
        return new TextoQuestion(text);
    }
}
