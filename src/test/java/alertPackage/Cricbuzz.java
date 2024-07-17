package alertPackage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Cricbuzz {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();

    @Given("^user logins to cricbuzz$")
    public void userLoginsToCricbuzz() {
        BaseTest baseTest = new BaseTest();
        baseTest.commonSetupMethod();
        this.driver = baseTest.getDriver();
    }

    @When("user select {string}")
    public void user_select(String countryName) {
        driver.get("https://www.cricbuzz.com/");
        WebElement teamDropDown = driver.findElement(By.id("teamDropDown"));
        Actions actions = new Actions(driver);
        actions.moveToElement(teamDropDown).perform();
        driver.findElement(By.xpath("//a[@title='" + countryName + " Cricket Team']")).click();
    }

    @Given("user login to frames website")
    public void userLoginToFramesWebsite() {
        BaseTest baseTest = new BaseTest();
        baseTest.commonSetupMethod();
        this.driver = baseTest.getDriver();
        driver.get("https://testpages.eviltester.com/styled/frames/frames-test.html");
    }

    @Then("user should able to see the {string} message in ui")
    public void userShouldAbleToSeeTheMessageInUi(String msg) {
        BaseTest baseTest = new BaseTest();
        driver.switchTo().frame("top");
        String text = driver.findElement(By.xpath("//div[@class='app-navigation']//child::a[1]")).getText();
        Assert.assertEquals("message :", msg, text);
        baseTest.tearDown();
    }

    @And("switch the frame to Left")
    public void switchTheFrameToLeft() {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame("left");
            List<WebElement> elements = driver.findElements(By.xpath("/html/body/ul/li"));
            System.err.println("Size :" + elements.size());
        } catch (NoSuchFrameException e) {
            System.err.println("Frame 'left' not found: " + e.getMessage());
            // Handle or log the exception as needed
        } finally {
            baseTest.tearDown();
        }
    }
}

