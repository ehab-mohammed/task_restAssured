package task;

import BaseAPI.base;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class authApi extends base {

    File body = new File("src/test/resources/auth.json");

    @Test
    public void generateToken(){
       Response res = given().spec(request)
            .header("Content-Type","application/json")
                .body(body).
                when().post("/auth/login").
                then().log().all().
                statusCode(201)
                .assertThat().body("token",not(empty()))
                .extract().response();

        String token = res.path("token");

        System.out.println("TOKEN  "+token);


    }

}
