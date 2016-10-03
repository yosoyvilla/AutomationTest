/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ObjectTestFactory.*;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;

/**
 *
 * @author JOHANAYLUISA
 */
public class FirstTestCase {

    WebDriver driver;
    StartTest ST = new StartTest();
    InitialMenu IM = new InitialMenu();
    ExitTest ET = new ExitTest();
    AppointmentSchedulingMenu APS = new AppointmentSchedulingMenu();

    @Given("^Run Whit \"([^\"]*)\"$")
    public void run_Whit(String arg1) throws Throwable {
        String Browser = arg1;
        switch (Browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

    }

    @When("^I go to \"([^\"]*)\"$")
    public void i_go_to(String arg1) throws Throwable {

        ST.GoToSite(driver, arg1);
    }

    @When("^I press the Appointment Scheduling button$")
    public void i_press_the_appointmentSchedulingClick() throws Throwable {
        try {
            IM.appointmentSchedulingClick(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I enter \"([^\"]*)\" in the date day box$")
    public void i_enter_in_the_date_day_box(String arg1) throws Throwable {
        APS.DateDay(driver, arg1);

    }

    @When("^I enter \"([^\"]*)\" in the patient identification box$")
    public void i_enter_the_patient_identification_box(String arg1) throws Throwable {
        APS.PatientID(driver, arg1);

    }

    @When("^I enter \"([^\"]*)\" in the doctor identification box$")
    public void i_enter_in_the_doctor_identification_box(String arg1) throws Throwable {
        APS.DoctorID(driver, arg1);

    }

    @When("^I enter \"([^\"]*)\" in the scheduling notes box$")
    public void i_enter_in_the_scheduling_notes_box(String arg1) throws Throwable {
        APS.SchedulingNotes(driver, arg1);

    }

    @Then("^I press the save button and should get \"([^\"]*)\"$")
    public void i_press_the_save_button_and_should_get(String arg1) throws Throwable {
        APS.SaveButton(driver);
        Thread.sleep(3000L);
        boolean boolresult = driver.getPageSource().contains(arg1);
        Assert.assertTrue(boolresult);

    }

    @After
    public void EndTestRun(Scenario scenario) throws Throwable {
        ET.EndTest(driver);

    }

}
