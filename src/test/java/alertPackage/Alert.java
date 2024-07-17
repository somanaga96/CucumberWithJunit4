package alertPackage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Alert {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();

    @Given("User on Alert UI")
    public void userOnAlertUI() {
        baseTest.commonSetupMethod();
        this.driver = baseTest.getDriver();
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

    }

    @Then("User accept the alert")
    public void userAcceptTheAlert() throws InterruptedException {
        driver.findElement(By.id("alertexamples")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
        baseTest.tearDown();
    }

    @When("User {string} the alert")
    public void userTheAlert(String value) {
        driver.findElement(By.xpath("//input[@value='Show confirm box']")).click();
        if (value.equals("accept")) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }

    }


    @Then("User should able to see the message as {string}")
    public void userShouldAbleToSeeTheMessageAs(String expectedMessage) {
        String confirmreturn = driver.findElement(By.id("confirmexplanation")).getText();
        System.out.println("Text : " + confirmreturn);
        Assert.assertEquals("comparison message :", expectedMessage, confirmreturn);
        baseTest.tearDown();
    }


    @When("user click on prompt and send the {string} message")
    public void userClickOnPromptAndSendTheMessage(String message) {
        driver.findElement(new By.ByCssSelector("input#promptexample")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
    }

    @Then("user should able to see the {string} message")
    public void userShouldAbleToSeeTheMessage(String message) {
        String text = driver.findElement(new By.ByCssSelector("p#promptreturn")).getText();
        Assert.assertEquals("comparison message :", message, text);
        baseTest.tearDown();
    }
}
