package co.com.client.webproject.test.stepdefinition.shoppingcart;

import co.com.client.webproject.test.controllers.*;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


public class AgregarProductoStepDefinition extends Setup {

    private WebAction webAction;
    DressesPageController dressesPageController;
    TshirtsPageController tshirtsPageController;

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

        String mensaje = dressesPageController.mensajeDeConfirmacion();

        Assert.Hard.thatString(mensaje).isEqualTo("Product successfully added to your shopping cart");
        webAction.closeBrowser();


    }


    //segundo escenario.

    @Dado("que soy un comprador registrado en la zona de camisetas")
    public void queSoyUnCompradorRegistradoEnLaZonaDeCamisetas() {

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
        myAccountWebController.comprarCamisetas();


    }
    @Cuando("adiciono producto al carrito")
    public void adicionoProductoAlCarrito() {

        tshirtsPageController = new TshirtsPageController();
        tshirtsPageController.setWebAction(webAction);
        tshirtsPageController.adicionarCamiseta();

    }
    @Entonces("mostrara mensaje de confirmacion en pantalla.")
    public void mostraraMensajeDeConfirmacionEnPantalla() {

        String mensaje = tshirtsPageController.mensajeDeConfirmacion();

        Assert.Hard.thatString(mensaje).isEqualTo("Product successfully added to your shopping cart");

    }

    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }


}
