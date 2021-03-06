package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.page.DressesPage;
import co.com.client.webproject.test.page.MyAccountPage;
import co.com.client.webproject.test.page.TshirtsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }


    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            usuario = webAction.getText(myAccountPage.getCustomerName(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return usuario;
    }

    public void comprarVestidos(){

        try{
            DressesPage dressesPage = new DressesPage(webAction.getDriver());
            webAction.click(dressesPage.getLinkDresses(), Seconds.TEN_SECONDS.getValue(), true);


        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al ingresar a vestidos.", e);
        }

    }

    public void comprarCamisetas(){

        try{
            TshirtsPage tshirtsPage = new TshirtsPage(webAction.getDriver());
            webAction.click(tshirtsPage.getLinkTshirts(), Seconds.TEN_SECONDS.getValue(), true);


        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al ingresar a vestidos.", e);
        }

    }





}
