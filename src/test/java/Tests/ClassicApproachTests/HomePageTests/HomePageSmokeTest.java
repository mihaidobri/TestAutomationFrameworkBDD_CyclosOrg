package Tests.ClassicApproachTests.HomePageTests;

import TestSteps.GenericStep;
import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import Tests.TestData.UITestData.HomePage.HomePageData;
import Utils.Browser;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Feature("Home page smoke test (Classic approach)")
public class HomePageSmokeTest extends GenericStep {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;

    @Before
    public void before_all_tests() {
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("The user has the correct horizontal menu items")
    public void correctHorizontalMenuItemsArePresent() {
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int index = 0; index < HomePageData.HORIZONTAL_MENU_ITEMS.size(); index++) {
            softAssertions.assertThat(homePage.horizontalMenuItems.get(index).getText())
                    .isEqualTo(HomePageData.HORIZONTAL_MENU_ITEMS.get(index));
        }
        softAssertions.assertAll();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("The first tab in the status menu is \"My messages\"")
    public void messagesIsPresentInTheStatusMenu(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.statusMenuItems.get(0).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.statusMenuItems.get(0).getAttribute("href"))
                .containsIgnoringCase("my-messages");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.statusMenuItems.get(0)))
                .isNotNull();

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("The second tab in the status menu is \"Notifications\"")
    public void notificationsIsPresentInTheStatusMenu(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.statusMenuItems.get(1).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.statusMenuItems.get(1).getAttribute("href"))
                .containsIgnoringCase("notifications");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.statusMenuItems.get(1)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("The second tab in the status menu is \"User profile\"")
    public void userProfileIsPresentInTheStatusMenu(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.statusMenuItems.get(2).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.statusMenuItems.get(2).getText())
                .isEqualTo("demo");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.statusMenuItems.get(2)))
                .isNotNull();
        Assertions.assertThat(homePage.statusMenuItems.get(2).getAttribute("href"))
                .containsIgnoringCase("my-profile");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("The second tab in the status menu is \"Logout\"")
    public void loguotIsPresentInTheStatusMenu(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.statusMenuItems.get(3).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.statusMenuItems.get(3).getText())
                .isEqualTo("Logout");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.statusMenuItems.get(2)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("First dashboard item is \"Account info\"")
    public void firstDashboardIsPayUser(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(0).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(0).getText())
                .isEqualTo("Account info");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(0)))
                .isNotNull();

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Second dashboard item is \"Update profile\"")
    public void secondDashboardIsAccountInfo(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(1).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(1).getText())
                .isEqualTo("Update profile");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(1)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Third dashboard item is \"Pay user\"")
    public void thirdDashboardIsUpdateProfile(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(2).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(2).getText())
                .isEqualTo("Pay user");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(2)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Fourth dashboard item is \"View contacts\"")
    public void fourthDashboardIsViewMessage(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(3).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(3).getText())
                .isEqualTo("View contacts");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(3)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Fifth dashboard item is \"Place ad\"")
    public void fifthDashboardIsPlaceAd(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(4).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(4).getText())
                .isEqualTo("Place ad");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(4)))
                .isNotNull();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Sixth dashboard item is \"View messages\"")
    public void sixthDashboardIsViewContacts(){
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        captureScreenshot(driver);
        Assertions.assertThat(homePage.dashboardActions.get(5).isDisplayed())
                .isEqualTo(true);
        Assertions.assertThat(homePage.dashboardActions.get(5).getText())
                .isEqualTo("View messages");
        Assertions.assertThat(ExpectedConditions.elementToBeClickable(homePage.dashboardActions.get(5)))
                .isNotNull();
    }

    @After
    public void after_all_tests(){
        driver.close();
    }

}
