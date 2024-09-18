package org.nttdata.page;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioModal {

    public static final Target OPEN_FORM = Target.the("boton del formulario")
            .locatedBy("//button[text()='Place Order']");

    public static final Target INPUT_NAME = Target.the("input para el nombre")
            .locatedBy("//input[@id='name']");

    public static final Target INPUT_COUNTRY = Target.the("input para el país")
            .locatedBy("//input[@id='country']");

    public static final Target INPUT_CITY = Target.the("input para la ciudad")
            .locatedBy("//input[@id='city']");

    public static final Target INPUT_CREDIT_CARD = Target.the("input para la tarjeta de crédito")
            .locatedBy("//input[@id='card']");

    public static final Target INPUT_MONTH = Target.the("input para el mes")
            .locatedBy("//input[@id='month']");

    public static final Target INPUT_YEAR = Target.the("input para el año")
            .locatedBy("//input[@id='year']");

    public static final Target BUY = Target.the("boton de compra")
            .located(By.xpath("//button[@onclick='purchaseOrder()']"));

    public static final Target OK = Target.the("boton de validacion")
            .located(By.xpath("//button[text()='OK']"));

}
