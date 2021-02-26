package PageObjectRepository.Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BankingLeftSideMenuPage {

    private WebDriver driver;

    @FindAll(@FindBy(css = ".leftMenuLink"))
    public List<WebElement> leftSideMenuSubsections;

    @FindAll(@FindBy(css = ".leftMenuSection"))
    public List<WebElement> leftSideMenuSections;

    @FindBy(css = ".pageHeadingText")
    public WebElement subsectionHeading;

    public BankingLeftSideMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
