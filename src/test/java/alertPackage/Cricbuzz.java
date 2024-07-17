package alertPackage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cricbuzz {
    WebDriver driver;

    @Given("^user logins to cricbuzz$")
    public void userLoginsToCricbuzz() {
        BaseTest baseTest = new BaseTest();
        baseTest.commonSetupMethod();
        this.driver = baseTest.getDriver();
        driver.get("https://www.cricbuzz.com/");
    }

    @When("user select {string}")
    public void user_select(String countryName) {
        WebElement teamDropDown = driver.findElement(By.id("teamDropDown"));
        Actions actions = new Actions(driver);
        actions.moveToElement(teamDropDown).perform();
        driver.findElement(By.xpath("//a[@title='" + countryName + " Cricket Team']")).click();
    }
}
