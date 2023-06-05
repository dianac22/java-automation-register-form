package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumUtils {

    public SeleniumUtils() {
    }
    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
        switch(getBrowserEnumFromString(browserType)) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case Firefox:
            case Mozilla:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case Safari:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        return driver;
    }

    public static Browsers getBrowserEnumFromString(String browserType) {
        Browsers[] var1 = Browsers.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Browsers browser = var1[var3];
            if (browserType.equalsIgnoreCase(browser.toString())) {
                return browser;
            }
        }
        return null;
    }

    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
