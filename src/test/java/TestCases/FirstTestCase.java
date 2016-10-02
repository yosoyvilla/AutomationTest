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

/**
 *
 * @author JOHANAYLUISA
 */
public class FirstTestCase {

    WebDriver driver;
    String Browser;
    StartTest ST = new StartTest();
    InitialMenu IM = new InitialMenu();
    ExitTest ET = new ExitTest();
    AppointmentSchedulingMenu APS = new AppointmentSchedulingMenu();

    @Test
    public void Initialize() throws Exception {
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
            ST.GoToSite(driver);
            IM.appointmentSchedulingClick(driver);
            ET.EndTest(driver);
            APS.DateDay(driver);
            APS.PatientID(driver);
            APS.DoctorID(driver);
            APS.SchedulingNotes(driver);
            APS.SaveButton(driver);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
