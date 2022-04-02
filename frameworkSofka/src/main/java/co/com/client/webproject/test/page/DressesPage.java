package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {


    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
    @CacheLookup
    WebElement linkDresses;

    @FindBy(xpath = "//li[2]/div/div[2]/h5/a")
    @CacheLookup
    WebElement productText;

    @FindBy(xpath = "//div[3]/div/p/button/span")
    @CacheLookup
    WebElement addToChartButton;


    @FindBy(xpath = "//div[4]/div/div")
    @CacheLookup
    WebElement addedMessage;

    public WebElement getLinkDresses() {
        return linkDresses;
    }

    public WebElement getProductText() {
        return productText;
    }

    public WebElement getAddToChartButton() {
        return addToChartButton;
    }

    public WebElement getAddedMessage() {
        return addedMessage;
    }

    public DressesPage(WebDriver webDriver){

        PageFactory.initElements(webDriver, this);
    }



}
