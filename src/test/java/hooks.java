import cucumber.api.java.After;
import cucumber.api.java.Before;
import regression.stepdefinations.driver;

public class hooks {

    driver idriver = new driver();

    @Before
    public void open() {
        idriver.openBrowser();
    }

    @After
    public void close() {
        idriver.closeBrowser();

    }
}
