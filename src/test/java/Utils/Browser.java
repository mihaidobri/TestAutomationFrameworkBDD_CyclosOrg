package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {

    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Browser() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }

        if (browser.equals("firefox")){
            driver = new FirefoxDriver();
            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
    }
}
