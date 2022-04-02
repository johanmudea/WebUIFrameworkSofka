package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Dictionary;
import co.com.client.webproject.test.helpers.Seconds;
import co.com.client.webproject.test.page.TshirtsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class TshirtsPageController {

    private WebAction webAction;
    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void adicionarCamiseta(){

        try{
            TshirtsPage tshirtsPage = new TshirtsPage(webAction.getDriver());

            webAction.moveTo(tshirtsPage.getProductText(),60,true);
            webAction.click(tshirtsPage.getProductText(),60,true);
            webAction.waitUntilExist(tshirtsPage.getAddToChartBtn(),60,true);
            webAction.click(tshirtsPage.getAddToChartBtn(),60,true);



        }catch(WebActionsException e) {
            Report.reportFailure("Ocurrio un eerror al adicionar producto" + e);
        }

    }

    public String mensajeDeConfirmacion(){
        String mensaje = Dictionary.EMPTY_STRING;

        try {
            TshirtsPage tshirtsPage = new TshirtsPage(webAction.getDriver());
            webAction.waitUntilExist(tshirtsPage.getAddMessage(), Seconds.SIXTY_SECONDS.getValue(), true);
            mensaje = webAction.getText(tshirtsPage.getAddMessage(),Seconds.SIXTY_SECONDS.getValue(),true).trim();

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje de eliminacion del producto "+e);
        }

        return mensaje;






    }


}
