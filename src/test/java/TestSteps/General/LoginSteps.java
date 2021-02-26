package TestSteps.General;

import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import TestSteps.GenericStep;
import Tests.TestData.UITestData.LoginPage.LoginPageData;
import Tests.TestData.UITestData.PageHeadings;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Tests.TestData.UITestData.LoginPage.LoginMessages.HOME_URL;
import static Tests.TestData.UITestData.LoginPage.LoginMessages.INVALID_MESSAGE;

public class LoginSteps extends GenericStep {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Step("Login with the credentials: {username}/ {password}")
    public void loginWithTheCredentials(String username, String password){
        loginPage.loginWithCredentials(username,password);
        Wait wait = new WebDriverWait(driver,30).pollingEvery(1,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
    }

    @Step("Verify that login page has the header displayed")
    public void loginPageHasTheHeaderDisplayed(){
        Wait wait = new WebDriverWait(driver,30).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginPageHeading));
        Assertions.assertThat(loginPage.loginPageHeading.getText()).as("login page heading")
                .isEqualTo(PageHeadings.LOGIN_PAGE_HEADING);
        captureScreenshot(driver);

    }

    @Step("Verify that login page has the horizontal menu items clickable and the displayed text is correct")
    public void loginPageHasHorizontalMenuItemsClickableAndTextIsCorrect(){
        SoftAssertions softAssertions = new SoftAssertions();
        for (int index = 0; index < LoginPageData.HORIZONTAL_MENU_SECTIONS.size(); index++) {
            softAssertions.assertThat(loginPage.horizontalMenuItems.get(index).getText())
                    .isEqualTo(LoginPageData.HORIZONTAL_MENU_SECTIONS.get(index));
            softAssertions.assertThat(loginPage.horizontalMenuItems.get(index).isDisplayed())
                    .isEqualTo(true);
        }
        softAssertions.assertAll();
        captureScreenshot(driver);
    }

    @Step("Verify that login form is displayed and has the correct labels")
    public void loginFormIsDisplayedAndHasTheCorrectLabels(){
        Wait wait = new WebDriverWait(driver,30).pollingEvery(200, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormTitle));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.loginFormTitle.getText())
                .isEqualTo(LoginPageData.LOGIN_FORM_HEADER);
        softAssertions.assertThat(loginPage.loginNameLabel.getText())
                .isEqualTo(LoginPageData.LOGIN_NAME_LABEL);
        softAssertions.assertThat(loginPage.passwordLabel.getText())
                .isEqualTo(LoginPageData.PASSWORD_LABEL);
        softAssertions.assertAll();
    }

    @Step("Access the login page")
    public void accessTheLoginPage(){
        loginPage.signInLink.click();
    }

    @Step("Verify that the redirect to the home page is functional")
    public void redirectToHomePageIsFunctional(){
        Wait wait = new WebDriverWait(driver,30).pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        Assertions.assertThat(driver.getCurrentUrl())
                .isEqualTo(HOME_URL);
    }

    @Step("Verify that the error message for invalid credentials is displayed")
    public void errorMessageForInvalidCredentialsIsDisplayed(){
        Assertions.assertThat(loginPage.notificationMessage.getText())
                .isEqualTo(INVALID_MESSAGE);
    }

    @Step("Log out from the application")
    public void logoutFromApp(){
        homePage.logoutButton.click();
    }

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }
}
