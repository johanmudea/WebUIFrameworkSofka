package co.com.client.webproject.test.stepdefinition.contactus;

import co.com.client.webproject.test.controllers.ContactUsPageController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.model.ContactUs;
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

public class ContactUsStepsDefinition extends Setup {

    private WebAction webAction;
    private ContactUs contactUs;
    private ContactUsPageController contactUsPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }





    @Dado("que estoy en la seccion de contacto")
    public void queEstoyEnLaSeccionDeContacto() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUs();


    }
    @Cuando("el cliente diligencia la informacion")
    public void elClienteDiligenciaLaInformacion() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.diligenciarMensaje();

    }
    @Entonces("como resultado mostrara mensaje de confirmacion.")
    public void comoResultadoMostraraMensajeDeConfirmacion() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);

        String mensaje2 = contactUsPageController.confirmacionMensajeContacto();

        Assert.Hard
                .thatString(mensaje2)
                .isEqualTo("Your message has been successfully sent to our team.");

        webAction.closeBrowser();


    }


    @Dado("que estoy en  contacto")
    public void queEstoyEnContacto() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUs();


    }
    @Cuando("no diligencio el email")
    public void noDiligencioElEmail() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.diligenciarSinMail();



    }
    @Entonces("mostrara mensaje de error en pantalla.")
    public void mostraraMensajeDeErrorEnPantalla() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);

        String mensaje3 = contactUsPageController.mensajeErrorMail();

        Assert.Hard
                .thatString(mensaje3)
                .isEqualTo("Invalid email address.");

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
