import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetResourceTest {
    @Test
    void getResourceWithoutIdShouldReturnResourceFullList() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data",notNullValue());
    }
    @Test
    void getResourceWithExistingIdShouldReturnSingleResource() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/unknown/1")
                .then()
                .statusCode(200)
                .body("data",notNullValue())
                .body("data.id",equalTo(1));
    }

    @Test
    void getResourceWithUnexistingIdShouldReturnError() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/unknown/100")
                .then()
                .statusCode(404)
                .body(equalTo("{}"));
    }
}
