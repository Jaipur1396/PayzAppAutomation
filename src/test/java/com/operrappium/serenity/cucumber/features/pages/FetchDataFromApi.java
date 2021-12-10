package com.operrappium.serenity.cucumber.features.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchDataFromApi extends BasePage{
    public void getDVCCodeFromApi(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("as string "+ response.asString());
        System.out.println("as getStatusCode "+ response.getStatusCode());
        System.out.println("as getBody().asString() "+ response.getBody().asString());
        System.out.println("as string "+ response.getHeader("content-type"));
    }

    public void deleteOldMessageFromAPI() throws Throwable{
//        Response response = RestAssured.delete("http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete");
//        String xmlResponse = response.getBody().asString();
//        System.out.println("Response .... "+ xmlResponse);
//        RestAssured.delete("http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete");
        deleteOldMessageFromAPI2();
    }
}
