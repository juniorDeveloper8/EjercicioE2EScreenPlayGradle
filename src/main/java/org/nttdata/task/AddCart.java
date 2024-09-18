package org.nttdata.task;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nttdata.page.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddCart implements Task {

    public static Performable shoping() {
        return instrumented(AddCart.class);
    }

    @Override
    @Step("{0} agrega un artículo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // articulo uno
                WaitUntil.the(HomePage.ARTICULO_UNO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ARTICULO_UNO),
                WaitUntil.the(HomePage.ADD_TO_CART_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ADD_TO_CART_BUTTON),
                new AcceptAlert(),
                Click.on(HomePage.HOME_BTN),

                //articulo dos
                WaitUntil.the(HomePage.ARTICULO_DOS, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ARTICULO_DOS),
                WaitUntil.the(HomePage.ADD_TO_CART_BUTTON_2, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ADD_TO_CART_BUTTON_2),
                new AcceptAlert(),
                Click.on(HomePage.HOME_BTN)

        );
    }

}

