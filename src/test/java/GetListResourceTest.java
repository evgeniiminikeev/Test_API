import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class GetListResourceTest {
    @Test
    void getResourceWithoutIdShouldReturnFullList() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("data",notNullValue());
    }
}
