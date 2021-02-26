package TestSteps.General;

import PageObjectRepository.Banking.BankingLeftSideMenuPage;
import PageObjectRepository.Home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AdvertisementsSteps {

    WebDriver driver;
    HomePage homePage;
    BankingLeftSideMenuPage bankingLeftSideMenuPage;

    public AdvertisementsSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        bankingLeftSideMenuPage = new BankingLeftSideMenuPage(driver);
        this.driver = driver;
    }

    @Step
    public void navigateToMyAdvertisements(){
        homePage.horizontalMenuItems.get(3).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankingLeftSideMenuPage.leftSideMenuSubsections.get(1).click();

    }
}
