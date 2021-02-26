package PageObjectRepository.Banking;

import Models.PaymentToUserForm.PaymentToUserForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentToUserPage {

    WebDriver driver;

    @FindBy(css = ".autoCompleteFieldContainer>input")
    public WebElement userQuickSearchInput;

    @FindBy(css = ".inputField.large.rightAligned")
    public WebElement ammountInteger;

    @FindBy(css = ".inputField.centerAligned")
    public WebElement ammountDecimal;

    @FindBy(css = ".inputField.full")
    public WebElement descriptionTextArea;

    @FindBy(xpath = "//button")
    public WebElement submitButton;

    public PaymentToUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void completeForm(PaymentToUserForm paymentToUserForm){
        userQuickSearchInput.sendKeys(paymentToUserForm.getUsername());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ammountInteger.sendKeys(paymentToUserForm.getAmmountInteger());
        ammountDecimal.clear();
        ammountDecimal.sendKeys(paymentToUserForm.getAmmountDecimal());
        descriptionTextArea.sendKeys(paymentToUserForm.getDescription());
        submitButton.click();
    }
}
