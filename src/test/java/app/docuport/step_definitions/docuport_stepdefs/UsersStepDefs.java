package app.docuport.step_definitions.docuport_stepdefs;

import app.docuport.pages.docuport_pages.UsersPage;
import app.docuport.utilities.BrowserUtilities;
import app.docuport.utilities.DBUtils;
import app.docuport.utilities.DB_Utility;
import app.docuport.utilities.DocuportConstants;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersStepDefs {
    UsersPage usersPage = new UsersPage();

    @Then("verify new client is created")
    public void verify_new_client_is_created() throws SQLException {
        usersPage.navigateItem("Users");
        usersPage.assertClientIsPresent(ClientStepDefs.list.get(2), ClientStepDefs.list.get(3));
        BrowserUtilities.waitForVisibility(usersPage.totalResultCount, DocuportConstants.large);
        Assert.assertTrue(usersPage.getResultCount() > 0);

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("select * from document.users where email_address = '" + ClientStepDefs.list.get(2) + "'");
        rs.next();
        Assert.assertEquals(ClientStepDefs.list.get(0), rs.getString("first_name"));
    }

    @Then("Delete user from the database")
    public void delete_new_user_from_the_database() throws SQLException {

        //DB_Utility.createConnection();
        DB_Utility.createConnection("jdbc:postgresql://35.222.62.70:5432/postgres", "tstadmin", "hoxBam-jaghuj-7cette");
        ResultSet rs = DB_Utility.runQuery("select * from document.users where email_address = '" + ClientStepDefs.list.get(2) + "'");

        rs.next();
        rs.deleteRow();

        rs = DB_Utility.runQuery("select * from identity.users where email_address = '" + ClientStepDefs.list.get(2) + "'");

        rs.next();
        rs.deleteRow();


    }

}
