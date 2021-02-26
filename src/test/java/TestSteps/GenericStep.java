package TestSteps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericStep {

    @Attachment
    public byte[] captureScreenshot(WebDriver d) {
        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
    }
}
