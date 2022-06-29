package restassuredapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC002_PostRequest {
    @Test
    void PostRequestCreateRecord(){
        //specify base url
        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
        //Request Object
        RequestSpecification httpRequest=RestAssured.given();
        //Request Payload Sending along with POST request
        JSONObject requestParam = new JSONObject();
        requestParam.put("name","RockDravidson");
        requestParam.put("age",30);
        requestParam.put("salary",50000);
        httpRequest.header("Content-Type","application/json");
        //Attach above data to the request
        httpRequest.body(requestParam.toJSONString());

        //Sending Request POST
        Response response = httpRequest.request(Method.POST,"/create");
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
        Assert.assertEquals(contentType,"application/json");

        //Success Code validation
        String successCode = response.jsonPath().get("status");
        System.out.println("SuccessCode:"+successCode);
        Assert.assertEquals(successCode,"success");

    }

}
