package com.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public  class UtilsMethods {

    protected Response addPet(String uri) {
        JSONObject body = new JSONObject();
        JSONObject category = new JSONObject();
        JSONArray photoUrlsArr = new JSONArray();
        photoUrlsArr.put("test");
        category.put("name", "test");
        body.put("category", category);
        body.put("name", "test");
        body.put("photoUrls", photoUrlsArr);
        JSONObject tags = new JSONObject();
        JSONArray tagsArr = new JSONArray();
        tags.put("name", "test");
        tagsArr.put(tags);
        body.put("tags", tagsArr);
        body.put("status", "test");

        return RestAssured.given().contentType(ContentType.JSON).body(body.toString()).post(uri);
    }

}

