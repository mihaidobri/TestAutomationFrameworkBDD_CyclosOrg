package Tests.ClassicApproachTests.BankingTests;

import TestSteps.GenericStep;
import PageObjectRepository.Banking.BankingLeftSideMenuPage;
import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import Utils.Browser;
import Utils.Parsers.JsonParser;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Feature("Banking menu (Classic approach)")
@Story("Left side menu")
public class BankingLeftSideMenuPageTests extends GenericStep {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static BankingLeftSideMenuPage bankingLeftSideMenuPage;

    @Before
    public void beforeTest(){
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        bankingLeftSideMenuPage = new BankingLeftSideMenuPage(driver);

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Banking left side menu has the correct sections")
    public void bankingLeftSideMenuSectionsTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SoftAssertions softAssertions = new SoftAssertions();
        JsonParser jsonParser = new JsonParser("ExternalTestData/Json/BankingLeftSideMenu.json");
        List<String> testList = jsonParser.getJsonObject("Sections");
        for (int index = 0; index < testList.size(); index++) {
            softAssertions.assertThat(bankingLeftSideMenuPage.leftSideMenuSections.get(index).getText())
                    .isEqualTo(testList.get(index));
        }
        softAssertions.assertAll();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Banking left side menu has the correct subsections")
    public void bankingLeftSideMenuSubsectionsTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SoftAssertions softAssertions = new SoftAssertions();
        JsonParser jsonParser = new JsonParser("ExternalTestData/Json/BankingLeftSideMenu.json");
        List<String> testList = jsonParser.getJsonObject("Subsections");
        for (int index = 0; index < testList.size(); index++) {
            softAssertions.assertThat(bankingLeftSideMenuPage.leftSideMenuSubsections.get(index).getText())
                    .isEqualTo(testList.get(index));
        }
        softAssertions.assertAll();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Banking left side menu pages have the correct header")
    public void bankingLeftSideMenuSubsectionsHeadersTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SoftAssertions softAssertions = new SoftAssertions();
        JsonParser jsonParser = new JsonParser("ExternalTestData/Json/BankingLeftSideMenu.json");
        List<String> testList = jsonParser.getJsonObject("Headings");
        for (int index = 0; index < testList.size(); index++) {
            bankingLeftSideMenuPage.leftSideMenuSubsections.get(index).click();
            wait.until(ExpectedConditions.textToBePresentInElement(bankingLeftSideMenuPage.subsectionHeading,testList.get(index)));
            softAssertions.assertThat(bankingLeftSideMenuPage.subsectionHeading.getText())
                    .isEqualTo(testList.get(index));
        }
        softAssertions.assertAll();
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
