import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

public class AccessTokenTest {

    String baseUrl = "https://api.us.onelogin.com/";

    @Test
    public void getAccessToken() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("grant_type", "client_credentials")
                .queryParam("client_id", "0ee1153edfdc30f7cdb9c5bb2f7a96575faadcac62e37bbf66566d59acf2df96")
                .queryParam("client_secret", "edae8332e57ade1ab0c41a263e8e6991bfc2ad5982e37c6afd97209378ea6cab")
                .log().all()
                .when()
                .post(baseUrl + "auth/oauth2/v2/token");

        // Assertions and Logging
        response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("access_token", Matchers.notNullValue()); // Ensure token is present
    }
}
