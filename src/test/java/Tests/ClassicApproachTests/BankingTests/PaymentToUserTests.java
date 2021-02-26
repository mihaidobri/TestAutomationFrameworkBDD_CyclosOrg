package Tests.ClassicApproachTests.BankingTests;

import Models.PaymentToUserForm.PaymentToUserForm;
import PageObjectRepository.Banking.*;
import PageObjectRepository.Home.HomePage;
import PageObjectRepository.Login.LoginPage;
import Utils.Browser;
import com.poiji.bind.Poiji;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(DataProviderRunner.class)
public class PaymentToUserTests {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static PaymentReviewPage paymentReviewPage;
    private static BankingLeftSideMenuPage bankingLeftSideMenuPage;
    private static AccountInformationPage accountInformationPage;
    private static TransferDetailsPage transferDetailsPage;
    private static PaymentToUserPage paymentToUserPage;

    @Before
    public void beforeTests() throws InterruptedException {
        driver = new Browser().getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        bankingLeftSideMenuPage = new BankingLeftSideMenuPage(driver);
        paymentReviewPage = new PaymentReviewPage(driver);
        paymentToUserPage = new PaymentToUserPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
        transferDetailsPage = new TransferDetailsPage(driver);
    }

    @DataProvider
    public static List<PaymentToUserForm> validPaymentToUserForm(){
        return Poiji.fromExcel(new File("ExternalTestData/Excel/PaymentToUserTestData.xlsx"),PaymentToUserForm.class);
    }

    @Test
    @DisplayName("Confirm payment screen shows all data")
    @UseDataProvider("validPaymentToUserForm")
    public void submitPaymentToUserAllDataTest(PaymentToUserForm paymentToUserForm) throws InterruptedException {
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(bankingLeftSideMenuPage.leftSideMenuSubsections.get(4)));
        Thread.sleep(3000);
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentToUserPage.userQuickSearchInput));
        SoftAssertions softAssertions = new SoftAssertions();
        paymentToUserPage.completeForm(paymentToUserForm);
        Thread.sleep(5000);
        softAssertions.assertThat(paymentReviewPage.paymentReviewLabels.get(0).getText())
                .isEqualTo("From account");
        softAssertions.assertThat(paymentReviewPage.paymentReviewLabels.get(1).getText())
                .isEqualTo("To");
        softAssertions.assertThat(paymentReviewPage.paymentReviewLabels.get(2).getText())
                .isEqualTo("Payment type");
        softAssertions.assertThat(paymentReviewPage.paymentReviewLabels.get(3).getText())
                .isEqualTo("Amount");
        softAssertions.assertThat(paymentReviewPage.paymentReviewLabels.get(4).getText())
                .isEqualTo("Description");
        softAssertions.assertThat(paymentReviewPage.paymentReviewValues.get(0).getText())
                .isEqualTo(paymentToUserForm.getFromAccount());
        softAssertions.assertThat(paymentReviewPage.paymentReviewValues.get(1).getText())
                .isEqualTo(paymentToUserForm.getActualUsername());
        softAssertions.assertThat(paymentReviewPage.paymentReviewValues.get(2).getText())
                .isEqualTo(paymentToUserForm.getPaymentType());
        softAssertions.assertThat(paymentReviewPage.paymentReviewValues.get(3).getText())
                .isEqualTo(paymentToUserForm.getAmmountInteger()+","+paymentToUserForm.getAmmountDecimal()+" IU's");
        softAssertions.assertThat(paymentReviewPage.paymentReviewValues.get(4).getText())
                .isEqualTo(paymentToUserForm.getDescription());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Transfer details screen shows all data")
    @UseDataProvider("validPaymentToUserForm")
    public void transferDetailsPageDisplaysAllData(PaymentToUserForm paymentToUserForm) throws InterruptedException {
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(bankingLeftSideMenuPage.leftSideMenuSubsections.get(4)));
        Thread.sleep(3000);
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentToUserPage.userQuickSearchInput));
        SoftAssertions softAssertions = new SoftAssertions();
        paymentToUserPage.completeForm(paymentToUserForm);
        Thread.sleep(2000);
        paymentReviewPage.confirmationButton.click();
        Thread.sleep(5000);
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(0).getText())
                .isEqualTo("Amount");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(1).getText())
                .isEqualTo("Date");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(2).getText())
                .isEqualTo("From");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(3).getText())
                .isEqualTo("To");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(4).getText())
                .isEqualTo("Payment type");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(5).getText())
                .isEqualTo("Channel");
        softAssertions.assertThat(transferDetailsPage.transferDetailsLabels.get(6).getText())
                .isEqualTo("Transfer number");
        softAssertions.assertThat(transferDetailsPage.descriptionLabel.getText())
                .isEqualTo("Description");
        softAssertions.assertThat(transferDetailsPage.transferDetailsValues.get(0).getText())
                .isEqualTo(paymentToUserForm.getAmmountInteger()+","+paymentToUserForm.getAmmountDecimal()+ " IU's");
        softAssertions.assertThat(transferDetailsPage.transferDetailsValues.get(2).getText())
                .isEqualTo("Demo user");
        softAssertions.assertThat(transferDetailsPage.transferDetailsValues.get(3).getText())
                .isEqualTo(paymentToUserForm.getActualUsername());
        softAssertions.assertThat(transferDetailsPage.transferDetailsValues.get(4).getText())
                .isEqualTo(paymentToUserForm.getPaymentType());
        softAssertions.assertThat(transferDetailsPage.descriptionValue.getText())
                .isEqualTo(paymentToUserForm.getDescription());
        softAssertions.assertThat(transferDetailsPage.confirmationMessage.getText())
                .isEqualTo("The payment was successful");
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("User that receives payment can see the payment")
    @UseDataProvider("validPaymentToUserForm")
    public void receivedUserCanSeePayment(PaymentToUserForm paymentToUserForm) throws InterruptedException {
        loginPage.signInLink.click();
        loginPage.loginWithCredentials("demo","1234");
        Wait wait = new WebDriverWait(driver,60).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(homePage.displayedUsername));
        homePage.horizontalMenuItems.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(bankingLeftSideMenuPage.leftSideMenuSubsections.get(4)));
        Thread.sleep(3000);
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentToUserPage.userQuickSearchInput));
        paymentToUserPage.completeForm(paymentToUserForm);
        Thread.sleep(2000);
        paymentReviewPage.confirmationButton.click();
        homePage.logoutButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'login') and contains(@class,'statusMenuLink')]")).click();
        Thread.sleep(2000);
        loginPage.loginWithCredentials(paymentToUserForm.getUsername(),paymentToUserForm.getPasswordReceivedUser());
        Thread.sleep(5000);
        homePage.horizontalMenuItems.get(1).click();
        Thread.sleep(2000);
        bankingLeftSideMenuPage.leftSideMenuSections.get(0).click();
        Thread.sleep(2000);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountInformationPage.firstTableFromTo.getText())
                .isEqualTo("Demo user");
        softAssertions.assertThat(accountInformationPage.firstTableDescription.getText())
                .isEqualTo(paymentToUserForm.getDescription());
        softAssertions.assertThat(accountInformationPage.firstTableAmmount.getText())
                .isEqualTo(paymentToUserForm.getAmmountInteger()+","+paymentToUserForm.getAmmountDecimal()+" IU's");
        softAssertions.assertAll();
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
