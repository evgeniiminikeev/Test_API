import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetListUsersTest {
    @Test
    void getUsersList() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.size()",greaterThan(0))
                .body("data[0].email",containsString("@reqres.in"));

    }
}
