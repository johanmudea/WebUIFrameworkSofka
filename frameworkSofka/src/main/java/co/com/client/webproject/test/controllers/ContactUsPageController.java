package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class ContactUsPageController {

    private WebAction webAction;
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;

    }


    public void diligenciarMensaje() {

        try {
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.selectByText(contactUsPage.getSubject(), "Webmaster", true);

            webAction.sendText(
                    contactUsPage.getEmail(),
                    customer.getEmail(),
                    2,
                    true
            );

            webAction.click(contactUsPage.getSubjectMessage(), true);
            webAction.sendText(contactUsPage.getSubjectMessage(), "Esto es una prueba", true);
            webAction.click(contactUsPage.getSendBtn(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar mensaje.", e);
        }

    }

    public void diligenciarSinMail() {

        try {
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.selectByText(contactUsPage.getSubject(), "Webmaster", true);

            webAction.click(contactUsPage.getSubjectMessage(), true);
            webAction.sendText(contactUsPage.getSubjectMessage(), "Esto es una prueba", true);
            webAction.click(contactUsPage.getSendBtn(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar mensaje.", e);
        }

    }

    public String confirmacionMensajeContacto() {

        String mensaje2 = EMPTY_STRING;

        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.waitUntilExist(contactUsPage.getContactSuccessful(), Seconds.SIXTY_SECONDS.getValue(), true);
            mensaje2 = webAction.getText(contactUsPage.getContactSuccessful(), true).trim();

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar mensaje.", e);
        }
        return mensaje2;
    }

    public String mensajeErrorMail() {

        String mensaje3 = EMPTY_STRING;

        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.waitUntilExist(contactUsPage.getErrorMailText(), Seconds.SIXTY_SECONDS.getValue(), true);
            mensaje3 = webAction.getText(contactUsPage.getErrorMailText(), true).trim();

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar mensaje.", e);
        }
        return mensaje3;
    }


}