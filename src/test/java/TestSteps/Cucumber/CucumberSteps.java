package TestSteps.Cucumber;

import TestSteps.General.AdvertisementsSteps;
import TestSteps.General.LoginSteps;
import Utils.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CucumberSteps {

    WebDriver driver;
    LoginSteps loginSteps;
    AdvertisementsSteps advertisementsSteps;

    public CucumberSteps(){
        driver = new Browser().getDriver();
        loginSteps = new LoginSteps(driver);
        advertisementsSteps = new AdvertisementsSteps(driver);
    }

    @Given("^I login to the application with the credentials (.*)/(.*)$")
    public void i_login_to_the_application_with_the_credentials(String arg1, String arg2) {
        loginSteps.accessTheLoginPage();
        loginSteps.loginWithTheCredentials(arg1,arg2);
    }

    @Given("^I go to My advertisements page$")
    public void i_go_to_My_advertisements_page() {
        advertisementsSteps.navigateToMyAdvertisements();
    }

    @Given("^I have less than five advertisements$")
    public void i_have_less_than_five_advertisements() throws InterruptedException {
        if (!(driver.findElements(By.xpath("//button/div[contains(text(),'New')]")).size()>0)) {
            driver.findElements(By.cssSelector(".iconLink")).get(1).click();
            driver.findElement(By.xpath("//button/div[contains(text(),'Ok')]")).click();
            Thread.sleep(3000);
        }
    }

    @When("^I click on the new button$")
    public void i_click_on_the_new_button() {
        driver.findElement(By.xpath("//button/div[contains(text(),'New')]")).click();
        Wait wait = new WebDriverWait(driver,30).pollingEvery(500, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".inputField.large")));
    }

    @When("^complete the Title field$")
    public void complete_the_Title_field() {
        driver.findElements(By.cssSelector(".inputField.large")).get(0).sendKeys("Placeholder title");
    }

    @When("^I select the category$")
    public void i_select_the_category() throws InterruptedException {
        driver.findElements(By.xpath("//div[contains(text(),'Please')]")).get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Musicians')]")).click();
    }

    @When("^add the description$")
    public void add_the_description(String arg1) {
        driver.findElement(By.xpath("//iframe[@class='richTextField']")).sendKeys(arg1);
    }

    @When("^add an image$")
    public void add_an_image() throws InterruptedException {
    }

    @When("^click on the Save button$")
    public void click_on_the_Save_button() {
        driver.findElement(By.xpath("//*[text()='Save']")).click();
    }

    @Then("^my attachment is added$")
    public void my_attachment_is_added() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertThat(driver.findElement(By.cssSelector(".notificationText")).getText())
                .isEqualTo("Saved successfully");
        driver.quit();
    }
}
