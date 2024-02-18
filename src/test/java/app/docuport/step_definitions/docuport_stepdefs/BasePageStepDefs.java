package app.docuport.step_definitions.docuport_stepdefs;

import app.docuport.pages.docuport_pages.BasePage;
import app.docuport.utilities.BrowserUtilities;

import app.docuport.utilities.DocuportConstants;
import app.docuport.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasePageStepDefs {
    private Logger LOG = LogManager.getLogger();
    static BasePage basePage = new BasePage();
    @Then("validate the left navigation items for each user type")
    public void validate_the_left_navigation_items_for_each_user_type(Map<String,String> map) {
        map.forEach((userType,expectedLeftNavigationItems)->{
            //login based on usertype
            basePage.loginDocuport(userType);

            //creates actualList
            List<String> actualLeftNavigationItems = new ArrayList<>();
            //finds left navigation web elements and then adds text of elements into actualList
            Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//a")).forEach(each->{
                actualLeftNavigationItems.add(each.getText());});

            //Compares actual and expected lists of left navigation items
            Assert.assertEquals(actualLeftNavigationItems.toString(), expectedLeftNavigationItems);

            //logs out of user
            basePage.logout();
        });
    }

    @Then("user validates expected navigation items {string}")
    public void user_validates_expected_navigation_items(String expectedLeftNavigationItems) {
        //creates actualList
        List<String> actualLeftNavigationItems = new ArrayList<>();
        basePage.openLeftNavigationPanel();
        BrowserUtilities.waitFor(1);
        //finds left navigation web elements and then adds text of elements into actualList
        basePage.getNavigationItems().forEach(each->{
            actualLeftNavigationItems.add(each.getText());});

        basePage.closeLeftNavigationPanel();
        //Compares actual and expected lists of left navigation items
        Assert.assertEquals(expectedLeftNavigationItems,actualLeftNavigationItems.toString());
    }

    @When("user navigates to {string}")
    public void user_navigates_to(String string) {
        basePage.navigateItem(string);
        BrowserUtilities.waitFor(1);
    }

    @Then("assert search button, download button, and {string} is displayed")
    public void assert_search_button_download_button_and_is_displayed(String string) {
        Assert.assertTrue(basePage.getSearchButton().isDisplayed());
        Assert.assertTrue(basePage.getDownloadButton().isDisplayed());
        Assert.assertEquals(basePage.getPageHeaderText(), string);
    }

    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        BrowserUtilities.waitForVisibility(basePage.getElement(text), DocuportConstants.large);
        Assert.assertTrue(basePage.getElement(text).isDisplayed());
        BrowserUtilities.waitFor(1 / 2);
    }

    @Then("user chooses account from drop down")
    public void user_chooses_account_from_drop_down() {
    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String buttonText) {
        basePage.clickButton(buttonText);
    }

    @Then("assert soft assertions")
    public void assert_soft_assertions() {
        //softAssertions.assertAll();
    }

    @Then("user assert {string} header text")
    public void user_assert_header_text(String string) {
        Assert.assertEquals(string,basePage.getPageHeaderText());
    }

    @Then("validate Rows Per Page shows {string}")
    public void validate_rows_per_page_shows(String expectedRowsPerPage) {
        Assert.assertEquals(expectedRowsPerPage,basePage.getRowsPerPage());
    }

    @When("user changes Rows Per Page to {string}")
    public void user_changes_rows_per_page_to(String newRowCount) {
        basePage.changeRowsPerPage(newRowCount);
    }
}
