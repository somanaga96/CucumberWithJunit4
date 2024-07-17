package alertPackage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private WebDriver driver;

    @Before
    public void commonSetupMethod() {
        if (this.driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            this.driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
