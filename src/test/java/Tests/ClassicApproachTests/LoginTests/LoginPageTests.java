package Tests.ClassicApproachTests.LoginTests;

import PageObjectRepository.Login.LoginPage;
import Tests.TestData.UITestData.LoginPage.LoginPageData;
import Tests.TestData.UITestData.PageHeadings;
import TestSteps.GenericStep;
import Utils.Browser;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Feature("Login page smoke test (Classic approach)")
public class LoginPageTests extends GenericStep {

    private static WebDriver driver;
    private static LoginPage loginPage;

    @Before
    public void before_tests(){
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        loginPage.signInLink.click();
    }



    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login page has the correct heading")
    public void loginPageHeadingIsCorrect() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertThat(loginPage.loginPageHeading.getText()).as("login page heading")
                .isEqualTo(PageHeadings.LOGIN_PAGE_HEADING);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login page horizontal menu items clickable and correct")
    public void loginPageHasCorrectHorizontalMenuItems() {
        SoftAssertions softAssertions = new SoftAssertions();
        for (int index = 0; index < LoginPageData.HORIZONTAL_MENU_SECTIONS.size(); index++) {
            softAssertions.assertThat(loginPage.horizontalMenuItems.get(index).getText())
                    .isEqualTo(LoginPageData.HORIZONTAL_MENU_SECTIONS.get(index));
            softAssertions.assertThat(loginPage.horizontalMenuItems.get(index).isDisplayed())
                    .isEqualTo(true);
        }
        softAssertions.assertAll();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Login form is displayed and has the correct labels")
    public void loginFormIsDisplayedAndHasCorrectLabels() {
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

    @After
    public void after_tests() {
        driver.quit();
    }
}
