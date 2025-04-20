import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUserTest {
    @Test
    void getUserWithoutIdShouldReturnUsersFullList() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.size()",greaterThan(0))
                .body("data[0].email",containsString("@reqres.in"));

    }
    @Test
    void getUserWithExistingIdShouldReturnUser() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data",notNullValue())
                .body("data.id", equalTo(2));
    }

    @Test
    void getUserWithUnexistingIdShouldReturnError() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users/100")
                .then()
                .statusCode(404)
                .body(equalTo("{}"));
    }

}
