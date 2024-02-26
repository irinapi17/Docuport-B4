package app.docuport.step_definitions;

import app.docuport.utilities.DocuportApiUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetDocumentClientsAllStepDefs {

    Response response;

    @Given("accept type is Json and adviser sends GET request to {string}")
    public void accept_type_is_json_and_adviser_sends_get_request_to(String endPoint) {
        response = given().accept(ContentType.JSON)
                .auth().oauth2(DocuportApiUtil.getAccessToken("advisor"))
                .when().get("https://beta.docuport.app"+endPoint);
    }

    @Then("status code is {string} and content type is {string}")
    public void status_code_is_and_content_type_is(String statusCode, String contentType) {
        response.then()
                .statusCode(Integer.parseInt(statusCode))
                .contentType(contentType);

    }

    @Then("body index {int} matches data:")
    public void body_index_matches_data(int index, Map <String,String> expected) {
        List<Map<String,Object>> actualList = response.as(List.class);

        assertThat(actualList.get(index).toString(),is(equalTo(expected.toString())));

        assertThat(actualList.get(index).get("id"),is(equalTo(1948)));
        assertThat(actualList.get(index).get("name"),is(equalTo("$randomName")));
        assertThat(actualList.get(index).get("clientType"),is(equalTo(1)));
        assertThat(actualList.get(index).get("isActive"),is(equalTo(true)));
        assertThat(actualList.get(index).get("advisor"),is(equalTo(null)));
    }
}