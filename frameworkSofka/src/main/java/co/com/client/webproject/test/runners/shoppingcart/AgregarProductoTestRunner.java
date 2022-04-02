package co.com.client.webproject.test.runners.shoppingcart;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/carritoCompras.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.shoppingcart"},
        publish = true


)


public class AgregarProductoTestRunner {
}
