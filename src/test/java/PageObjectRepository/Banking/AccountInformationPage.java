package PageObjectRepository.Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountInformationPage {

    private WebDriver driver;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[@class='iconLabel']/span")
    public WebElement balanceInformation;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/div[@class='iconLabel']/span")
    public WebElement balanceAtBeginOfPeriodInformation;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/div[@class='iconLabel']/span")
    public WebElement balanceAtEndOfPeriodInformation;

    @FindBy(xpath = "//tbody/tr[3]/td[1]/div[@class='iconLabel']/span")
    public WebElement totalIncomeInformation;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/div[@class='iconLabel']/span")
    public WebElement totalOutflowInformation;

    @FindBy(xpath = "//tbody/tr[4]/td[1]/div[@class='iconLabel']/span")
    public WebElement netInflowInformation;

    @FindBy(xpath = "//button[contains(@class,'resultsToolbarButton')][not(@aria-hidden)]")
    public WebElement sortingButton;

    @FindBy(xpath = "//tr[contains(@class,'dataTableRow dataTableRow-even')]/td[2]")
    public WebElement firstTableFromTo;

    @FindBy(xpath = "//tr[contains(@class,'dataTableRow dataTableRow-even')]/td[3]")
    public WebElement firstTableDescription;

    @FindBy(xpath = "//tr[contains(@class,'dataTableRow dataTableRow-even')]/td[4]")
    public WebElement firstTableAmmount;

    public AccountInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
