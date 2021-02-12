package com.framework.ObjectAPI;

import com.framework.core.Base;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

public class APIAction {
    String endPointUrl;
    private Response response;

    //POST
    public Response request_POST_Action(String endPoint, HashMap <String, String>jsonObject){

        endPointUrl = Base.config.getProperty("APIBaseURL") + endPoint;

        response = RestAssured.given().body(jsonObject).when().post(endPointUrl);

        System.out.println("POST Action Response: "+response.asString());

        return response;

    }

    public int getStatusCode(){

        System.out.println("Status Code: "+response.getStatusCode());
        return response.getStatusCode();
    }

    public void verifyResponse(){

        //verify id
        System.out.println("ID: "+response.getBody().jsonPath().getInt("id"));

        //verify token
        System.out.println("Token: "+response.getBody().jsonPath().getString("token"));

    }


}
