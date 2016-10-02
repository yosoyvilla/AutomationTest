/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ObjectTestFactory.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

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

    @When("^I enter \"([^\"]*)\" in date day box$")
    public void DateDay(String DateDay) throws Exception {
        try {
            APS.DateDay(driver, DateDay);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void PatientID(WebDriver driver) throws Exception {
        try {
            APS.PatientID(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void DoctorID(WebDriver driver) throws Exception {
        try {
            APS.DoctorID(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void SchedulingNotes(WebDriver driver) throws Exception {
        try {
            APS.SchedulingNotes(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void SaveButton(WebDriver driver) throws Exception {
        try {
            APS.SaveButton(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void EndTestRun(WebDriver driver) throws Exception {
        try {
            ET.EndTest(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
