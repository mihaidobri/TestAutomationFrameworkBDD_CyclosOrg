package TestSteps.General;

import Models.PaymentToUserForm.PaymentToUserForm;
import PageObjectRepository.Banking.BankingLeftSideMenuPage;
import PageObjectRepository.Banking.PaymentReviewPage;
import PageObjectRepository.Banking.PaymentToUserPage;
import PageObjectRepository.Banking.TransferDetailsPage;
import PageObjectRepository.Home.HomePage;
import TestSteps.GenericStep;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PaymentToUserSteps extends GenericStep {

    WebDriver driver;
    HomePage homePage;
    BankingLeftSideMenuPage bankingLeftSideMenuPage;
    PaymentToUserPage paymentToUserPage;
    PaymentReviewPage paymentReviewPage;
    TransferDetailsPage transferDetailsPage;

    public PaymentToUserSteps(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.bankingLeftSideMenuPage = new BankingLeftSideMenuPage(driver);
        this.paymentToUserPage = new PaymentToUserPage(driver);
        this.paymentReviewPage = new PaymentReviewPage(driver);
        this.transferDetailsPage = new TransferDetailsPage(driver);
    }

    @Step("Navigate to Payment to user page")
    public void navigateToPaymentToUserPage(){
        homePage.horizontalMenuItems.get(1).click();
        Wait wait = new WebDriverWait(driver,30).pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(bankingLeftSideMenuPage.leftSideMenuSubsections.get(4)));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentToUserPage.userQuickSearchInput));
        captureScreenshot(driver);
    }

    @Step("Complete payment to user form with data")
    public void completePaymentToUserFormWithDataAndSubmit(PaymentToUserForm paymentToUserForm){
        paymentToUserPage.completeForm(paymentToUserForm);
        captureScreenshot(driver);
    }

    @Step("Verify that the payment review page displays accurate information")
    public void paymentReviewPageDisplaysAccurateInformationFor(PaymentToUserForm paymentToUserForm){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SoftAssertions softAssertions = new SoftAssertions();
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
        captureScreenshot(driver);
    }

    @Step("Confirm the payment from payment review page")
    public void confirmPayment(){
        Wait wait = new WebDriverWait(driver,30).pollingEvery(1,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(paymentReviewPage.confirmationButton));
        paymentReviewPage.confirmationButton.click();
    }

    @Step("Verify that the transfer details page displays accurate information")
    public void transferDetailsPageDisplaysAccurateInformationFor(PaymentToUserForm paymentToUserForm){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SoftAssertions softAssertions = new SoftAssertions();
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
        softAssertions.assertThat(transferDetailsPage.transferDetailsValues.get(7).getText())
                .isEqualTo(paymentToUserForm.getDescription());
        softAssertions.assertThat(transferDetailsPage.confirmationMessage.getText())
                .isEqualTo("The payment was successful");
        softAssertions.assertAll();
        captureScreenshot(driver);
    }
}
