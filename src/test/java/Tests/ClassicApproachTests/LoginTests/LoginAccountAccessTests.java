package Tests.ClassicApproachTests.LoginTests;

import TestSteps.GenericStep;
import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import Utils.Browser;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Tests.TestData.UITestData.LoginPage.LoginMessages.HOME_URL;
import static Tests.TestData.UITestData.LoginPage.LoginMessages.INVALID_MESSAGE;

@RunWith(DataProviderRunner.class)
public class LoginAccountAccessTests extends GenericStep {

    private static WebDriver driver;
    private static LoginPage loginPage;
    public static HomePage homePage;

    @Before
    public void before_tests(){
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.signInLink.click();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("User can log in with valid credentials")
    @Feature("Login with valid credentials (Classic approach)")
    @UseDataProvider(value = "validUsernamesDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void canLoginWithValidCredentials(String username, String pass){
        loginPage.loginWithCredentials(username,pass);
        Wait wait = new WebDriverWait(driver,30).pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        Assertions.assertThat(driver.getCurrentUrl())
                .isEqualTo(HOME_URL);
    }

    @Test
    @Ignore
    @DisplayName("User cannot log in with valid username and invalid password")
    @Feature("Access denied with invalid credentials (Classic approach)")
    @UseDataProvider(value = "validUsernamesInvalidPasswordsDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void cannotLoginWithInvalidPassword (String username, String pass) {
        loginPage.loginWithCredentials(username,pass);
        Assertions.assertThat(loginPage.notificationMessage.getText())
                .isEqualTo(INVALID_MESSAGE);
    }

    @Test
    @Ignore
    @DisplayName("User cannot login with an invalid username and an invalid password")
    @Feature("Access denied with invalid credentials (Classic approach)")
    @UseDataProvider(value = "invalidUsernamesInvalidPasswordsDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void cannotLoginWithInvalidUsernameAndInvalidPassword (String username, String pass) {
        loginPage.loginWithCredentials(username,pass);
    Assertions.assertThat(loginPage.notificationMessage.getText()).as("error message")
                .isEqualTo(INVALID_MESSAGE);
    }



    @After
    public void afterTest(){
        driver.quit();
    }
}
