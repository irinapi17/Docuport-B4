package app.docuport.step_definitions;

import app.docuport.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HelloWorldApiStepDefs {

    @Given("User sends get request to hello world api")
    public void user_sends_get_request_to_hello_world_api() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("hello world api status code is {int}")
    public void hello_world_api_status_code_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("hello world api response body contains {string}")
    public void hello_world_api_response_body_contains(String string) {
        // Write code here that turns the phrase above into concrete actions
    }



}
