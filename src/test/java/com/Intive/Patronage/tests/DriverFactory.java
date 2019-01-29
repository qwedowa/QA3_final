package com.Intive.Patronage.tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {

    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int SCRIPT_TIMEOUT = 5;
    protected static WebDriver driver;

    public static void startBrowser() {
        if (driver == null) {
            switch (getBrowser().toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");
            }

            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().fullscreen();

        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }

    }

    private static String getBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = "chrome";
            }
        }
        return browser;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
