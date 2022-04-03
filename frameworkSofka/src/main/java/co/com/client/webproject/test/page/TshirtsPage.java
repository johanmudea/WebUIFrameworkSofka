package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtsPage {

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]/a")
    @CacheLookup
    WebElement linkTshirts;

    @FindBy(xpath = "//div[@id='center_column']/ul/li/div/div[2]/h5/a")
    @CacheLookup
    WebElement productText;

    @FindBy(xpath = "//p[@id='add_to_cart']/button/span")
    @CacheLookup
    WebElement addToChartBtn;


    @FindBy(xpath = "html/body/div/div/header/div[3]/div[1]/div[1]/div[4]/div/div[1]/h2")
    @CacheLookup
    WebElement addMessage;

    public WebElement getLinkTshirts() {
        return linkTshirts;
    }

    public WebElement getProductText() {
        return productText;
    }

    public WebElement getAddToChartBtn() {
        return addToChartBtn;
    }

    public WebElement getAddMessage() {
        return addMessage;
    }


    public TshirtsPage(WebDriver webDriver){

        PageFactory.initElements(webDriver, this);
    }



}


