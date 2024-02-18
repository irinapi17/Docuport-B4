package app.docuport.step_definitions;

import app.docuport.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HelloWorldApiStepDefs {

    Response response;

    @Given("User sends get request to hello world api")
    public void user_sends_get_request_to_hello_world_api() {
        response = given().accept(ContentType.JSON)
                .when().get("https://sandbox.api.service.nhs.uk/hello-world/hello/world");
    }

    @Then("hello world api status code is {int}")
    public void hello_world_api_status_code_is(Integer int1) {
        response.then().statusCode(int1);
    }

    @Then("hello world api response body contains {string}")
    public void hello_world_api_response_body_contains(String string) {
        response.then().body("message", is(equalTo(string)));
    }



}
