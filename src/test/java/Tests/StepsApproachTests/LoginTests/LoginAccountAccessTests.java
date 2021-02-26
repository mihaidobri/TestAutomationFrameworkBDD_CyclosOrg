package Tests.StepsApproachTests.LoginTests;

import TestSteps.General.LoginSteps;
import Utils.Browser;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(DataProviderRunner.class)
public class LoginAccountAccessTests {

    private LoginSteps loginSteps;
    private WebDriver driver;

    @Before
    public void beforeTests(){
        driver = new Browser().getDriver();
        loginSteps = new LoginSteps(driver);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("User can log in with valid credentials")
    @Feature("Login with valid credentials (Steps approach)")
    @UseDataProvider(value = "validUsernamesDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void canLoginWithValidCredentials(String username, String pass){
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials(username,pass);
        loginSteps.redirectToHomePageIsFunctional();
    }

    @Test
    @Ignore
    @DisplayName("User cannot log in with valid username and invalid password")
    @Feature("Access denied with invalid credentials (Steps approach)")
    @UseDataProvider(value = "validUsernamesInvalidPasswordsDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void cannotLoginWithInvalidPassword (String username, String pass) {
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials(username,pass);
        loginSteps.errorMessageForInvalidCredentialsIsDisplayed();
    }

    @Test
    @Ignore
    @DisplayName("User cannot login with an invalid username and an invalid password")
    @Feature("Access denied with invalid credentials (Classic approach)")
    @UseDataProvider(value = "invalidUsernamesInvalidPasswordsDataProvider",
            location = Tests.TestData.DataProviders.LoginDataProivders.class)
    public void cannotLoginWithInvalidUsernameAndInvalidPassword (String username, String pass) {
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials(username,pass);
        loginSteps.errorMessageForInvalidCredentialsIsDisplayed();
    }



    @After
    public void afterTest(){
        driver.quit();
    }
}
