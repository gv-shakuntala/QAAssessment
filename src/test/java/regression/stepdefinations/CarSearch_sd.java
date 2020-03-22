package regression.stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import regression.pages.CarSearch_page;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CarSearch_sd extends driver {
    private CarSearch_page carSearch_page = PageFactory.initElements(driver, CarSearch_page.class);

    @When("^I enter post code as \"([^\"]*)\"$")
    public void iEnterPostCodeAs(String postcode) {
        carSearch_page.enterPostcode(postcode);
    }


    @And("^I select \"([^\"]*)\" from make drop box$")
    public void iSelectFromMakeDropBox(String make) {
        carSearch_page.selectMake(make);
    }

    @And("^I click on search button$")
    public void iClickOnSearchButton() {
        carSearch_page.clickSearchButton();
    }

    @When("^I click on  model from filter options$")
    public void iClickOnModelFromFilterOptions() {
        carSearch_page.clickMakeModelButton();
        carSearch_page.clickModelAllButton();
    }

    @And("^I select model as \"([^\"]*)\"$")
    public void iSelectModelAs(String model) {
        carSearch_page.clickModel();

    }

    @And("^I click on Update button$")
    public void iClickOnUpdateButton() {
        carSearch_page.clickUpdateButton();
    }


    @When("^I selected to see full details of results (\\d+)$")
    public void iSelectedToSeeFullDetailsOfResults(int result) {
        carSearch_page.clickFullDetails(result);
    }

    @Then("^I verify the url as \"([^\"]*)\"$")
    public void iVerifyTheUrlAs(String expectedUrl) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Then("^I found the results as \"([^\"]*)\"$")
    public void iFoundTheResultsAs(String expecteResultsCount) throws InterruptedException {
        String actualResultCount;
        actualResultCount = carSearch_page.getResultsCount_withoutFilter();
        assertEquals(expecteResultsCount, actualResultCount);
    }

    @Then("^I should see the make as \"([^\"]*)\"$")
    public void iShouldSeeTheMakeAs(String expectedMake) {
        String actualMakeModel;
        String makeModel;
        String[] iMakeModel;
        makeModel = carSearch_page.getMakeModel();
        iMakeModel = makeModel.split(",");
        assertEquals(expectedMake, iMakeModel[0].trim());
    }

    @Then("^I should see the model as \"([^\"]*)\"$")
    public void iShouldSeeTheModelAs(String expectedModel) {
        String actualMakeModel;
        String makeModel;
        String[] iMakeModel;
        makeModel = carSearch_page.getMakeModel();
        iMakeModel = makeModel.split(",");
        assertEquals(expectedModel, iMakeModel[1].trim());
    }

    @Then("^I should see the variant as \"([^\"]*)\"$")
    public void iShouldSeeTheVariantAs(String expectedVariantDetails) {
        String actualVariantDeatils;
        actualVariantDeatils = carSearch_page.getVariantDetails();
        assertTrue(actualVariantDeatils.contains(expectedVariantDetails));
    }

    @Then("^I should see the title as \"([^\"]*)\"$")
    public void iShouldSeeTheTitleAs(String expectedTitleDetails) {
        String actualTitleDeatils;
        actualTitleDeatils = carSearch_page.getVariantDetails();
        assertEquals(expectedTitleDetails, actualTitleDeatils);
    }

    @When("^I click on dealer details tab$")
    public void iClickOnDealerDetailsTab() {
        carSearch_page.clickdealerDetails();
    }

    @Then("^I should see vehicle distance as \"([^\"]*)\"$")
    public void iShouldSeeVehicleDistanceAs(String expectedDealereDistance) {
        String actualDealerDistance;
        actualDealerDistance = carSearch_page.getDealerDistance();
        assertEquals(expectedDealereDistance, actualDealerDistance.replace("...", "").trim());
    }
}

