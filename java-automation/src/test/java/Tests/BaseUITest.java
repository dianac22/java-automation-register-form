package Tests;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class BaseUITest {
    WebDriver driver;
    String url;
    String signUpPath;
    String signUpPageURL;
    String browser;

    @BeforeClass
    public void setUp() throws IOException {
        Properties properties = SeleniumUtils.readProperties("src\\test\\resources\\application.properties");
        url = properties.getProperty("url");
        signUpPath = properties.getProperty("signUpPath");
        browser = properties.getProperty("browser");
        signUpPageURL = url + signUpPath;

        System.out.println("Default browser: " + browser);
        System.out.println("Page under test: " + signUpPageURL);
    }

    @Test
    public void demoTest() {

    }
}
