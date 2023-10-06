import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//Using this userID, get this user’s associated posts and verify they contains a valid Post IDs (an
//Integer between 1 and 100).
public class UserPostsTest {

    private String baseUrl = "https://jsonplaceholder.typicode.com";
    private int userId = 1;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void verifyUserPosts() {
        Response userResponse = RestAssured.get("/users/" + userId);


        userResponse.then().statusCode(200);


        int userId = userResponse.jsonPath().getInt("id");

        Response postsResponse = RestAssured.get("/posts?userId=" + userId);


        postsResponse.then().statusCode(200);


        List<Integer> postIds = postsResponse.jsonPath().getList("id");


        for (int postId : postIds) {
            assert postId >= 1 && postId <= 100 : "Invalid Post ID: " + postId;
        }
    }
}
