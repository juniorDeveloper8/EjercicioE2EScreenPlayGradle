package org.nttdata.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.nttdata.page.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateCart implements Task {

    private final String productName;
    private final String expectedPrice;

    public ValidateCart(String productName, String expectedPrice) {
        this.productName = productName;
        this.expectedPrice = expectedPrice;
    }

    public static Performable forProduct(String productName, String expectedPrice) {
        return instrumented(ValidateCart.class, productName, expectedPrice);
    }

    @Override
    @Step("{0} valida la tabla de productos")
    public <T extends Actor> void performAs(T actor) {
        // Espera hasta que la tabla sea visible
        actor.attemptsTo(
                WaitUntil.the(CartPage.PRODUCT_TABLE_BODY, isVisible()).forNoMoreThan(10).seconds()
        );

        WebElement tableBody = CartPage.PRODUCT_TABLE_BODY.resolveFor(actor).getWrappedElement();

        if (tableBody == null) {
            throw new AssertionError("No se encontró el cuerpo de la tabla de productos.");
        }

        boolean productFound = false;

        // Recorro las filas de la tabla
        for (WebElement row : tableBody.findElements(By.tagName("tr"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 2) {
                String productNameInTable = cells.get(1).getText().trim();
                String priceInTable = cells.get(2).getText().trim();

                // Verifico q el producto y el precio coinciden
                if (productNameInTable.equals(productName)) {
                    assert priceInTable.equals(expectedPrice) : "El precio del producto no es el esperado. Esperado: " + expectedPrice + ", Encontrado: " + priceInTable;
                    productFound = true;
                    break;
                }
            }
        }

        if (!productFound) {
            throw new AssertionError("El producto '" + productName + "' no se encontró en la tabla de productos.");
        }
    }
}
