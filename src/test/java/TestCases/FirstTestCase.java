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

    @Given("^Run With \"([^\"]*)\"$")
    public void i_select_a_browser_as(String Browser) throws Exception {
        Browser = "Chrome";
        try {
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

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I go to \"([^\"]*)\"$")
    public void i_go_to(String URL) throws Exception {
        try {
            ST.GoToSite(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I press the Appointment Scheduling button$")
    public void i_press_appointmentSchedulingClick() throws Exception {
        try {
            IM.appointmentSchedulingClick(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I enter \"([^\"]*)\" in the date day box$")
    public void i_enter_the_date_day(String DateDay) throws Exception {
        try {
            APS.DateDay(driver, DateDay);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I enter \"([^\"]*)\" in the patient identification box$")
    public void i_enter_the_patient_id(String PatientIdentification) throws Exception {
        try {
            APS.PatientID(driver, PatientIdentification);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I enter \"([^\"]*)\" in the doctor identification box$")
    public void i_enter_the_doctor_id(String DoctorIdentification) throws Exception {
        try {
            APS.DoctorID(driver, DoctorIdentification);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @When("^I enter \"([^\"]*)\" in the scheduling notes box$")
    public void i_enter_the_scheduling_notes(String SNotes) throws Exception {
        try {
            APS.SchedulingNotes(driver, SNotes);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Then("^I press the save button and should get \"([^\"]*)\"$")
    public void i_press_the_save_button(WebDriver driver, String ContentResult) throws Exception {
        try {
            APS.SaveButton(driver);
            Thread.sleep(3000L);
            boolean boolresult = driver.getPageSource().contains(ContentResult);
            Assert.assertTrue(boolresult);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @After
    public void EndTestRun(Scenario scenario) throws Exception {
        try {
            ET.EndTest(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
