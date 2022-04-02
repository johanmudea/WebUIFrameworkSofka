package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.page.DressesPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class DressesPageController {

    private WebAction webAction;
    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void adicionarVestido(){

        try{
            DressesPage dressesPage = new DressesPage(webAction.getDriver());

            webAction.moveTo(dressesPage.getProductText(),60,true);
            webAction.click(dressesPage.getProductText(),60,true);
            webAction.waitUntilExist(dressesPage.getAddToChartButton(),60,true);
            webAction.click(dressesPage.getAddToChartButton(),60,true);



        }catch(WebActionsException e) {
            Report.reportFailure("Ocurrio un eerror al adicionar producto" + e);
            }

        }

        public String mensajeDeConfirmacion(){
            String mensaje = Dictionary.EMPTY_STRING;

            try {
                DressesPage dressesPage = new DressesPage(webAction.getDriver());
                webAction.waitUntilExist(dressesPage.getAddedMessage(), Seconds.SIXTY_SECONDS.getValue(), true);
                mensaje = webAction.getText(dressesPage.getAddedMessage(),Seconds.SIXTY_SECONDS.getValue(),true).trim();

            }catch (WebActionsException e){
                Report.reportFailure("Ocurrió un error al intentar validar el mensaje de eliminacion del producto "+e);
            }

            return mensaje;






    }


}
