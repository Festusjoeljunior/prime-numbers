package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinitions extends Utils {

    private RequestSpecification requestSpecBuilder;
    private Response response;

    @Given("I provide the value {string}")
    public void provideTheNumber(String number) throws IOException {
        requestSpecBuilder = given().spec(requestSpecification())
                .pathParam("number", number);
    }

    @When("I retrieve the list of prime numbers")
    public void retrieveTheListOfPrimeNumbers() {
        response = requestSpecBuilder.get("/{number}");
    }

    @Then("the numbers are returned with a {int} response")
    public void theNumbersAreReturnedWithAResponse(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @And("the {string} in response body is {string}")
    public void theInResponseBodyIs(String keyValue, String expectedValue) {
        Assert.assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

    @And("the json body is empty")
    public void theJsonBodyIsEmpty() {
        String contentLengthValue = response.getHeader("Content-Length");
        Assert.assertEquals(contentLengthValue, String.valueOf(0));
    }

    @And("the size of numbers in the list is {int}")
    public void theSizeOfNumbersInTheListIs(int primeNumbersActualSize) {
        String primeNumbersExpectedSize = getJsonPath(response, "primeNumbers.size()");

        Assert.assertEquals(Integer.parseInt(primeNumbersExpectedSize), primeNumbersActualSize);
    }
}
