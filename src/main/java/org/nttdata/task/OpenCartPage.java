package org.nttdata.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nttdata.page.CartPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenCartPage implements Task {

    public static Performable open() {
        return instrumented(OpenCartPage.class);
    }


    @Override
    @Step("{0} abre la página del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPage.CART_BTN, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.CART_BTN)
        );

        actor.attemptsTo(
                WaitUntil.the(CartPage.PRODUCT_TABLE_BODY, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
    }
}