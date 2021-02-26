package Tests.StepsApproachTests.LoginTests;

import TestSteps.General.LoginSteps;
import Utils.Browser;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTests {

    private LoginSteps loginSteps;
    private WebDriver driver;

    @Before
    public void beforeTests(){
        driver = new Browser().getDriver();
        loginSteps = new LoginSteps(driver);
    }

    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login page has the correct heading")
    @Test
    public void loginPageHeadingTest(){
        loginSteps.accessTheLoginPage();
        loginSteps.loginPageHasTheHeaderDisplayed();
    }

    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login page horizontal menu items clickable and correct")
    @Test
    public void loginPageHorizontalMenuTest(){
        loginSteps.accessTheLoginPage();
        loginSteps.loginPageHasHorizontalMenuItemsClickableAndTextIsCorrect();
    }

    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login form is displayed and has the correct labels")
    @Test
    public void loginFormDisplayedTest(){
        loginSteps.accessTheLoginPage();
        loginSteps.loginFormIsDisplayedAndHasTheCorrectLabels();
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
