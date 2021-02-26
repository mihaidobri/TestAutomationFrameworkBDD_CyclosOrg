package PageObjectRepository.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'my-profile') and contains(@class,'statusMenuLink')]")
    public WebElement displayedUsername;

    @FindBy(xpath = "//a[contains(@href,'javascript') and contains(@class,'statusMenuLink')]")
    public WebElement logoutButton;

    @FindAll(@FindBy(css = ".gwt-InlineLabel"))
    public List<WebElement> horizontalMenuItems;

    @FindAll(@FindBy(css = ".statusMenuItem>a"))
    public List<WebElement> statusMenuItems;

    @FindAll(@FindBy(css = ".dashboardAction"))
    public List<WebElement> dashboardActions;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
