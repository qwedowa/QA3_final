package com.Intive.Patronage.tests.steps;
import com.Intive.Patronage.tests.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Hooks extends DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.debug("============================================================BEFORE SCENARIO");
        startBrowser();
        logger.debug(scenario.getId().split(";")[0].toUpperCase() + " SCENARIO: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        String status = (scenario.isFailed() ? "FAILED" : "SUCCESS");
        logger.debug("=======================================SCENARIO FINISHED WITH " + status + " STATUS");
        if (scenario.isFailed() && driver != null) {

            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            FileUtils.copyFile(scrFile, new File(currentPath + "\\screenshots\\screenshot.png"));

        }
        destroyDriver();
        logger.debug("============================================CLEANUP AFTER SCENARIO FINISHED");
    }
}


