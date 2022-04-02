package co.com.client.webproject.test.stepdefinition.shoppingcart;


import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.DressesPageController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.checkerframework.checker.units.qual.C;

import java.net.CacheRequest;

public class AgregarProductoStepDefinition extends Setup {

    private WebAction webAction;
    DressesPageController dressesPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());

    }

    @Dado("que soy un comprador registrado en la zona de vestidos")
    public void queSoyUnCompradorRegistradoEnLaZonaDeVestidos() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.comprarVestidos();


    }
    @Cuando("el cliente agrega producto vestido al carrito")
    public void elClienteAgregaProductoVestidoAlCarrito() {

        dressesPageController = new DressesPageController();
        dressesPageController.setWebAction(webAction);
        dressesPageController.adicionarVestido();




    }
    @Entonces("como resultado mostrara mensaje de confirmacion.")
    public void comoResultadoMostraraMensajeDeConfirmacion() {

    }



    @Dado("que soy un comprador registrado en la zona de camisetas")
    public void queSoyUnCompradorRegistradoEnLaZonaDeCamisetas() {

    }
    @Cuando("adiciono producto al carrito")
    public void adicionoProductoAlCarrito() {

    }
    @Entonces("mostrara mensaje de confirmacion en pantalla.")
    public void mostraraMensajeDeConfirmacionEnPantalla() {

    }


}
