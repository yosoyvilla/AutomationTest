/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectTestFactory;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author DVILLA
 */
public class StartTest {
    public Boolean GoToSite(WebDriver driver, String URL) throws Exception {
        Boolean result = true;
        try {
            driver.get(URL);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
}
