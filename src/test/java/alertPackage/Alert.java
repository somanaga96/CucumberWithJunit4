package alertPackage;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert {
    WebDriver driver;

    @Given("User on Alert UI")
    public void userOnAlertUI() {
        BaseTest baseTest = new BaseTest();
        baseTest.commonSetupMethod();
        this.driver = baseTest.getDriver();
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");
        driver.findElement(By.id("alertexamples")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.accept();
        baseTest.tearDown();
    }
}
