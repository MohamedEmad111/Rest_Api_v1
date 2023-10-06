import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostWithNonEmptyTitleAndBody {
//Do a post using same userID with a non-empty title and body, verify the correct response is
//returned (since this is a mock API, it might not return Response code 200, so check the
//documentation).
    private String baseUrl = "https://jsonplaceholder.typicode.com"; //
    private int userId = 1;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void postWithNonEmptyTitleAndBody() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", userId);
        requestBody.put("title", "Sample Title");
        requestBody.put("body", "Sample Body");


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody.toJSONString())
                .post("/posts");


        response.then().statusCode(201); // Check if the response code is 201 (Created)
    }
}
