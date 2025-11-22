package BaseAPI;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;

public class base {
    protected RequestSpecification request;
    @BeforeClass
    public void before(){
        request = given().baseUri("https://fakestoreapi.com");
    }
}
