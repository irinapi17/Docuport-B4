package app.docuport.pages.docuport_pages;


import app.docuport.utilities.BrowserUtilities;

public class UsersPage extends BasePage{

    public void assertClientIsPresent(String emailAddress,String phoneNumber){
        BrowserUtilities.waitForClickable(searchButton,5).click();
        searchEmailAddress.sendKeys(emailAddress);
        searchPhoneNumber.sendKeys(phoneNumber);
        BrowserUtilities.waitForClickable(updateSearchButton,5).click();
    }
}
