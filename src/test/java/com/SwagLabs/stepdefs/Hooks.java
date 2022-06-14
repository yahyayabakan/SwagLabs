package com.SwagLabs.stepdefs;

import com.SwagLabs.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static com.SwagLabs.utilities.Driver.driver;

public class Hooks {

    @Before
    public void setUp(){
        driver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }
}
