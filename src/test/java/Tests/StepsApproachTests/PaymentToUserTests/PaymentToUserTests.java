package Tests.StepsApproachTests.PaymentToUserTests;

import Models.PaymentToUserForm.PaymentToUserForm;
import TestSteps.General.LoginSteps;
import TestSteps.General.PaymentToUserSteps;
import Utils.Browser;
import com.poiji.bind.Poiji;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class PaymentToUserTests {

    private WebDriver driver;
    private LoginSteps loginSteps;
    private PaymentToUserSteps paymentToUserSteps;

    @Before
    public void beforeTests(){
        driver = new Browser().getDriver();
        loginSteps = new LoginSteps(driver);
        paymentToUserSteps = new PaymentToUserSteps(driver);
    }

    @DataProvider
    public static List<PaymentToUserForm> validPaymentToUserFormSteps(){
        return Poiji.fromExcel(new File("ExternalTestData/Excel/PaymentToUserTestData.xlsx"),PaymentToUserForm.class);
    }

    @Test
    @DisplayName("Confirm payment screen shows all data")
    @UseDataProvider("validPaymentToUserFormSteps")
    public void submitPaymentToUserAllDataTest(PaymentToUserForm paymentToUserForm){
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials("demo","1234");
        paymentToUserSteps.navigateToPaymentToUserPage();
        paymentToUserSteps.completePaymentToUserFormWithDataAndSubmit(paymentToUserForm);
        paymentToUserSteps.paymentReviewPageDisplaysAccurateInformationFor(paymentToUserForm);
    }

    @Test
    @DisplayName("Transfer details screen shows all data")
    @UseDataProvider("validPaymentToUserFormSteps")
    public void transferDetailsPageDisplaysAllData(PaymentToUserForm paymentToUserForm) {
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials("demo","1234");
        paymentToUserSteps.navigateToPaymentToUserPage();
        paymentToUserSteps.completePaymentToUserFormWithDataAndSubmit(paymentToUserForm);
        paymentToUserSteps.confirmPayment();
        paymentToUserSteps.transferDetailsPageDisplaysAccurateInformationFor(paymentToUserForm);
    }

    @Test
    @DisplayName("User that receives payment can see the payment")
    @UseDataProvider("validPaymentToUserFormSteps")
    public void receivedUserCanSeePayment(PaymentToUserForm paymentToUserForm) {
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials("demo","1234");
        paymentToUserSteps.navigateToPaymentToUserPage();
        paymentToUserSteps.completePaymentToUserFormWithDataAndSubmit(paymentToUserForm);
        paymentToUserSteps.confirmPayment();
        loginSteps.logoutFromApp();
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials(paymentToUserForm.getUsername(),paymentToUserForm.getPasswordReceivedUser());
    }

    @After
    public void afterTests(){
        driver.close();
    }
}
