package org.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = "org.nttdata.glue",
        tags = "@AddProduct"
)
public class RunnerTest {
}
