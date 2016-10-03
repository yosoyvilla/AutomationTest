/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:report/smokeTest","json:report/cucumber.json"}, features="src/test/resources", glue = {"TestCases"}, dryRun = false, monochrome = true)
public class RunTest {

}
