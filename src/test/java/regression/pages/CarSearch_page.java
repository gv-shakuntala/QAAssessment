package regression.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static regression.stepdefinations.driver.driver;

public class CarSearch_page {

    @FindBy(name = "PostCode")
    private WebElement postcode_ele;

    @FindBy(id = "Make")
    private WebElement make_ele;

    @FindBy(css = "div.inline-input-bar.sp__bar > button")
    private WebElement searchButton;

    @FindBy(id = "gdprAgree")
    private WebElement cookiesAcceptButton;

    @FindBy(css = "button.panel-link.mod")
    private WebElement Make_Model_ele;

    @FindBy(css = ".tab-item:nth-child(2) > button")
    private WebElement modelall_ele;

    @FindBy(id = "Models_Galaxy")
    private WebElement Model_Galaxy;

    @FindBy(css = "#sp2 > section > footer > button")
    private WebElement Update_Button_ele;

//    @FindBy(css = "div.r__cta > a")
    @FindBy(linkText = "Full Details")
    private List<WebElement> fullDetails;

    @FindBy(css = "section > div.sr__block.super > button")
    private WebElement smartPicksForYouClosebutton;

    @FindBy(css = "#resultHeader > p > span")
    private WebElement actual_results_pagecount_1;

    @FindBy(css = "div.wrapper > header > div.header-description > div > h1")
    private WebElement make_model_actual;

    @FindBy(css = " div.wrapper > header > div.header-description > div > p")
    private WebElement variant_details_actual;

    @FindBy(id="dealer-details")
    private  WebElement dealer_details;

    @FindBy(css="#panel-dealer-details > div.text-c > p > span")
    private  WebElement dealer_distance;

    WebDriverWait wait = new WebDriverWait(driver,30);


    public void enterPostcode(String postcode) {
        wait.until(ExpectedConditions.visibilityOf(postcode_ele));
        postcode_ele.sendKeys(postcode);
    }

    public void selectMake(String make) {
        new Select(make_ele).selectByValue(make);
    }

    public void clickSearchButton() {
        cookiesAcceptButton.click();
        searchButton.click();
    }


    public void clickMakeModelButton() {
        Make_Model_ele.click();
    }

    public void clickModelAllButton() {
        wait.until(ExpectedConditions.visibilityOf(modelall_ele));
        modelall_ele.click();
    }

    public void clickModel() {
        Model_Galaxy.click();
    }

    public void clickUpdateButton() {
        Update_Button_ele.click();
    }

    public void clickFullDetails(int results) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fullDetails.get(results - 1).click();
    }

    public String getResultsCount_withoutFilter() throws InterruptedException {
        Thread.sleep(5000);//Wanted used Thread.sleep so that this framework will have all the possible WAIT conditions (Except Fluent Wait).
         String actualResultCount;
        actualResultCount = actual_results_pagecount_1.getText();
        return actualResultCount;
    }

    public String getMakeModel() {
        wait.until(ExpectedConditions.visibilityOf(make_model_actual));
        String actualMakeModel;
        actualMakeModel = make_model_actual.getText();
        return actualMakeModel;
    }

    public String getVariantDetails() {
        String actualVariantDeatils;
        actualVariantDeatils = variant_details_actual.getText();
        return actualVariantDeatils;
    }

    public String getTitleDetails() {
        String actualTitleDeatils;
        actualTitleDeatils = variant_details_actual.getText();
        return actualTitleDeatils;
    }

    public void clickdealerDetails(){
        dealer_details.click();
    }


    public String getDealerDistance(){
        String actualDealerDistance;
        wait.until(ExpectedConditions.visibilityOf(dealer_distance));
        actualDealerDistance=dealer_distance.getText();
        return actualDealerDistance;
    }
}

