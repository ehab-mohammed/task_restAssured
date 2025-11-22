package task;
import BaseAPI.base;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.*;
public class ProductCreation extends base{

    File body = new File("src/test/resources/createProduct.json");

    @Test
    public void createProduct(){

         given().spec(request)
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post("/products")
                .then().log().all()
                 .statusCode(201)
                .body("title",equalTo("airpods 3 pro"))
                 .body("price",equalTo(29.99F));

    }

}
