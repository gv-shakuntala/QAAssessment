package regression.stepdefinations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {
    public static WebDriver driver;

    public void openBrowser() {
        String browser = System.getProperty("browser");
        if (browser.toUpperCase().equals("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get("https://www.motors.co.uk/");
        driver.manage().window().maximize();
    }


    public void closeBrowser() {
        driver.quit();
    }
}
