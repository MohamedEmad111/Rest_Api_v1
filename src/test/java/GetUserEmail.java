import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class GetUserEmail {
    //Get a random user (userID), print out its email address to console.
    @Test
    public void test1() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        Response response = RestAssured.get("/users/1");


        if (response.getStatusCode() == 200) {

            String email = response.jsonPath().getString("email");


            System.out.println("Email: " + email);
        } else {
            System.out.println("Failed to retrieve data. Status code: " + response.getStatusCode());
        }
    }

}
