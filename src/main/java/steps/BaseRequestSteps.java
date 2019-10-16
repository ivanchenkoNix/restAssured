package steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseRequestSteps {

    private RequestSpecification spec;
    private Response response;

    public BaseRequestSteps(RequestSpecification spec) {
        this.spec = spec;
    }

    public BaseRequestSteps simpleRequest(String endpoint){
        response = given()
                .spec(spec)
                .header("User-Agent", "Jmeter")
                .when()
                .get(endpoint)
                .then()
                .extract().response();
        return this;
    }

    public BaseRequestSteps checkStatusCode(Integer statusCode) {
        assertThat(String.format("status code is not %d",statusCode), response.getStatusCode() == statusCode);
        return this;
    }

    public BaseRequestSteps checkHeaderEquals(String headerName, String header) {
        assertThat(String.format("%s is not equals to %s",headerName,header), response.getHeader(headerName).equals(header));
        return this;
    }

    public BaseRequestSteps checkHeaderContains(String headerName,String header){
        assertThat(String.format("%s not contains %s",headerName,header), response.getHeader(headerName).contains(header));
        return this;
    }
}