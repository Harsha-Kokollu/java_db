import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

public class AuthTest {

    String baseUrl = "https://reqres.in/";

    @Test
    public void VerifyGet(){
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("page",2).log().all().when().get(baseUrl+"api/users?page={page}");
  response.then().log().all().assertThat().statusCode(200).body("page", Matchers.equalTo(2));
    }
}
