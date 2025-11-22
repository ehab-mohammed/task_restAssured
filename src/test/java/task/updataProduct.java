package task;
import BaseAPI.base;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.*;
public class updataProduct extends base{

    File body = new File("src/test/resources/updateProduct.json");

    @Test
    public void update(){

        given().spec(request)
                .header("Content-Type","application/json")
                .body(body)
                .when().put("/products/21")
                .then().log().all().statusCode(200)
                .body("title",equalTo("airpode 5 pro"))
                 .body("price",equalTo(49.99F));

    }



}
