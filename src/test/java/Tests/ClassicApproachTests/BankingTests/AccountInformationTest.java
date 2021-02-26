package Tests.ClassicApproachTests.BankingTests;

import PageObjectRepository.Banking.AccountInformationPage;
import PageObjectRepository.Banking.BankingLeftSideMenuPage;
import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import Utils.Browser;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Feature("Banking menu (Classic approach)")
@Story("Account information")
public class AccountInformationTest {

    private static LoginPage loginPage;
    private static WebDriver driver;
    private static HomePage homePage;
    private static BankingLeftSideMenuPage bankingLeftSideMenuPage;
    private static AccountInformationPage accountInformationPage;

    @Before
    public void beforeClass(){
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        bankingLeftSideMenuPage = new BankingLeftSideMenuPage(driver);
        accountInformationPage = new AccountInformationPage(driver);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Balance information is displayed")
    public void balanceIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.balanceInformation.getText())
                .contains("Balance:");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Balance at begin of period information is displayed")
    public void balanceAtBeginOfPeriodIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.balanceAtBeginOfPeriodInformation.getText())
                .contains("Balance at begin of period:");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Balance at end of period information is displayed")
    public void balanceAtEndOfPeriodIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.balanceAtEndOfPeriodInformation.getText())
                .contains("Balance at end of period:");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Total income information is displayed")
    public void totalIncomeIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.totalIncomeInformation.getText())
                .contains("Total income:");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Total outflow is displayed")
    public void totalOutflowIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.totalOutflowInformation.getText())
                .contains("Total outflow:");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Net inflow is displayed")
    public void netInflowIsDisplayedTest(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(0).click();
        Assertions.assertThat(accountInformationPage.netInflowInformation.getText())
                .contains("Net inflow:");
    }

    @After
    public void after(){
        driver.quit();
    }
}
