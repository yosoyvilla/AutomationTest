/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectTestFactory;

import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author JOHANAYLUISA
 */
public class AppointmentSchedulingMenu {

    By HasDatePicker = By.id("datepicker");
    By PatientIdentification = By.xpath("//input[@placeholder='Ingrese el documento de identidad del paciente']");
    By DoctorIdentification = By.xpath("//input[@placeholder='Ingrese el documento de identidad del doctor']");
    By Notes = By.className("textarea.form-control");
    By BtnSave = By.cssSelector("a[class='btn btn-primary pull-right']");

    public Boolean DateDay(WebDriver driver, String Day) throws Exception {
        Boolean result = false;
        try {
            driver.findElement(this.HasDatePicker).sendKeys(Day);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public Boolean PatientID(WebDriver driver) throws Exception {
        Boolean result = false;
        try {
            Random rnd = new Random();
            String ID = String.valueOf(rnd.nextInt(999999999));
            driver.findElement(this.PatientIdentification).sendKeys(ID);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public Boolean DoctorID(WebDriver driver) throws Exception {
        Boolean result = false;
        try {
            Random rnd = new Random();
            String ID = String.valueOf(rnd.nextInt(999999999));
            driver.findElement(this.DoctorIdentification).sendKeys(ID);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public Boolean SchedulingNotes(WebDriver driver) throws Exception {
        Boolean result = false;
        try {
            driver.findElement(this.Notes).sendKeys("Automation Test");
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    
        public Boolean SaveButton(WebDriver driver) throws Exception {
        Boolean result = false;
        try {
            driver.findElement(this.BtnSave).click();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}
