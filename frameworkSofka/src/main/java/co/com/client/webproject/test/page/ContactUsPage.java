package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(id = "contact-link")
    WebElement contactUs;

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement subject;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "message")
    WebElement subjectMessage;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement sendBtn;

    @CacheLookup
    @FindBy(xpath = "html/body/div/div[2]/div/div[3]/div[1]/p")
    WebElement contactSuccessful;

    @FindBy(xpath = "html/body/div/div[2]/div/div[3]/div[1]/div/ol/li")
    @CacheLookup
    WebElement errorMailText;

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSubjectMessage() {
        return subjectMessage;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public WebElement getContactSuccessful() {
        return contactSuccessful;
    }

    public WebElement getErrorMailText() {
        return errorMailText;
    }

    public ContactUsPage(WebDriver webDriver){

        PageFactory.initElements(webDriver, this);
    }

}
