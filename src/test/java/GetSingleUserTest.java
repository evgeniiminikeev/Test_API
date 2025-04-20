import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserTest {
    @Test
    void getExistedUserShouldReturnUser() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test
    void getUnexistedUserShoudReturnError() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users/23")
                .then()
                .statusCode(404)
                .body(equalTo("{}"));
    }

}
