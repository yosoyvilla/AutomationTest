/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectTestFactory;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author DVILLA
 */
public class ExitTest {

    public Boolean EndTest(WebDriver driver) throws Exception {
        Boolean result = true;
        try {
            driver.quit();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}
