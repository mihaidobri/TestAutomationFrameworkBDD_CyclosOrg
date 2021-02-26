package PageObjectRepository.Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentReviewPage {

    WebDriver driver;

    @FindAll(@FindBy(css=".formLabel"))
    public List<WebElement> paymentReviewLabels;

    @FindAll(@FindBy(css=".spacedLabel"))
    public List<WebElement> paymentReviewValues;

    @FindBy(xpath="//div[contains(@class,'notificationText')]")
    public WebElement notificationMessage;

    @FindBy(xpath ="//div[@class='pageHeadingText']")
    public WebElement tableHeaderTitle;

    @FindBy(xpath="//div[@class='actionButtonText']")
    public WebElement confirmationButton;

    public PaymentReviewPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
