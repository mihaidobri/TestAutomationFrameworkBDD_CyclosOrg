package PageObjectRepository.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'login')][contains(@class,'statusMenuLink')]")
    public WebElement signInLink;

    @FindBy(xpath="//div[@class='loginForm']/input")
    public WebElement loginNameField;

    @FindBy(xpath="//input[@type='password']")
    public WebElement loginPasswordField;

    @FindBy(xpath="//button")
    public WebElement signInButton;

    @FindAll(@FindBy(css = ".horizontalMenuContentItem>a>span.gwt-InlineLabel"))
    public List<WebElement> horizontalMenuItems;

    @FindBy(css = ".notificationText")
    public WebElement notificationMessage;

    @FindBy(css = ".pageHeading")
    public WebElement loginPageHeading;

    @FindBy(css = ".loginTitle")
    public WebElement loginFormTitle;

    @FindBy(xpath = "//div[@class='loginForm']/div[2]")
    public WebElement loginNameLabel;

    @FindBy(xpath = "//div[@class='loginForm']/div[3]")
    public WebElement passwordLabel;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginWithCredentials(String username, String password) {
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(loginNameField));
        loginNameField.sendKeys(username);
        loginPasswordField.sendKeys(password);
        signInButton.click();
    }
}
