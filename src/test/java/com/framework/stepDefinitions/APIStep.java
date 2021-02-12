package com.framework.stepDefinitions;

import com.framework.ObjectAPI.APIAction;
import com.framework.core.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;

public class APIStep {

    APIAction apiAction = new APIAction();

   //JsonObject jsonObject = new JsonObject();

    HashMap<String, String> jsonObject = new HashMap<>();

   Response response;


    @When("User Post request to register")
    public void user_post_request_to_register() {

        String endpoint;

        //get json request
        jsonObject.put("email", Base.TestData.get("email"));

        jsonObject.put("password", Base.TestData.get("password"));

        //endpoint
        endpoint = "api/register";

        //post action
          response = apiAction.request_POST_Action(endpoint, jsonObject);

        //response

    }

    @Then("Verify response status code is {string}")
    public void verify_response_status_code_is(String httpStatus) {


        Assert.assertEquals("Response Status Comparison", httpStatus, String.valueOf(apiAction.getStatusCode()) );

    }

    @Then("Verify response")
    public void verify_response() {

        apiAction.verifyResponse();

    }

    @Then("Verify user register successful")
    public void verify_user_register_successful() {

        Assert.assertEquals("Registration Failed ",Base.TestData.get("token") ,response.getBody().jsonPath().getString("token"));

    }

}
