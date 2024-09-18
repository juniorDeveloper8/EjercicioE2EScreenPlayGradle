package org.nttdata.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target ARTICULO_UNO = Target.the("Samsung galaxy s6")
            .located(By.xpath("//a[contains(@href, 'prod.html?idp') and contains(text(), 'Samsung galaxy s6')]"));

    public static final Target ARTICULO_DOS = Target.the("Nokia lumia 1520")
            .located(By.xpath("//a[contains(text(), 'Nokia lumia 1520')]"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("boton de agregar al carro")
            .locatedBy("//a[@onclick='addToCart(1)']");

    public static final Target ADD_TO_CART_BUTTON_2 = Target.the("boton de agregar al carro")
            .locatedBy("//a[@onclick='addToCart(2)']");

    public static final Target HOME_BTN = Target.the("botón para volver al home")
            .locatedBy("//a[contains(@class, 'nav-link') and contains(text(), 'Home')]");

    public static final Target ERROR_TEXT = Target.the("Mensaje de error").locatedBy("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");

}
