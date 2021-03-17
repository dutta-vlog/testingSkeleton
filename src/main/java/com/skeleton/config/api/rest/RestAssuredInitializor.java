package com.skeleton.config.api.rest;

import com.skeleton.config.api.Initializor;

import io.restassured.RestAssured;

public class RestAssuredInitializor implements Initializor {

    @Override
    public void initializeApi() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
        //RestAssured.requestSpecification 
    }

}
