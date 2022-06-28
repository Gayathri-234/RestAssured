import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GetRequest {
    @Test
    void getWeatherDetails(){
        //specify base url
        RestAssured.baseURI="https://reqres.in/api/users";
       //Request Object creator GET
        RequestSpecification httpRequest=RestAssured.given();
        //Response Object
        Response response = httpRequest.request(Method.GET,"/2");
        //Print response in console
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is :"+responseBody);
        //Status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is: "+statusCode);
        Assert.assertEquals(statusCode,200);
        //Status Line Validation
        String statusLine=response.getStatusLine();
        System.out.println("Status Line: "+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        //Content-Type validation
        String contentType=response.getContentType();
        System.out.println("Content-Type is: "+contentType);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");
    }
}
