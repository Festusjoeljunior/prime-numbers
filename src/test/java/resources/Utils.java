package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Utils {

    public static RequestSpecification requestSpecification;

    public RequestSpecification requestSpecification() throws IOException {
        if (requestSpecification == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecification = new RequestSpecBuilder().setBaseUri("http://localhost:8080/")
                    .setBasePath("/primeNumbers/")
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return requestSpecification;
        }
        return requestSpecification;
    }

    public String getJsonPath(Response response, String key) {
        String responseBody = response.asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        return jsonPath.get(key).toString();
    }
}
