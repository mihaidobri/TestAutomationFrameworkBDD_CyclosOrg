package PageObjectRepository.Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransferDetailsPage {

    WebDriver driver;

    @FindBy(xpath="//div[@class = 'notificationText notificationText-singleLine']")
    public WebElement confirmationMessage;

    @FindBy(xpath="//div[@class='pageHeadingText']")
    public WebElement headerTitle;

    @FindAll(@FindBy(css="td[class$=formLabel]"))
    public List<WebElement> transferDetailsLabels;

    @FindBy(css = "td[class$='formLabel ']")
    public WebElement descriptionLabel;

    @FindAll(@FindBy(css="td[class$=formField]"))
    public List<WebElement> transferDetailsValues;

    @FindBy(css = "td[class$='formField ']")
    public WebElement descriptionValue;

    public TransferDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
