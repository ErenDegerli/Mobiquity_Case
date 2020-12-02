package com.mobiquity.core.client;

import com.mobiquity.core.config.ConfigParser;
import com.mobiquity.utils.SpecificationFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestClient {


    public RestClient() {
        RestAssured.baseURI = ConfigParser.getValue("BaseUrl");
    }

    public Response get(String endpoint) {
        return given().spec(SpecificationFactory.log_Response_To_Allure()).when().get(endpoint);
    }
}
