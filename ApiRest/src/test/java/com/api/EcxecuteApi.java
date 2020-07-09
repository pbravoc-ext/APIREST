package com.api;

import org.apache.http.HttpStatus;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EcxecuteApi {
	
	public void getTest0() {
		Response response = null;
		RestAssured.baseURI = "https://api.github.com/gists/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "33");
		request.body(requestParams);
		response = request.get("https://api.github.com/gists");
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().assertThat().body("public[0]", Is.is(true));
				
	}

	public void getTest1() {
		boolean status;
		String URL = "https://api.github.com/gists/45/comments";
		Response response = null;
		RestAssured.baseURI = "https://api.github.com/gists";
		RequestSpecification request = RestAssured.given();
		response = request.get(URL);
		response.then().assertThat().statusCode(HttpStatus.SC_OK);
		if(response.getTime()< 500) {
			status = true;
		}else {
			status = false;
		}
		
		Assert.assertTrue(status);

	}
	
	public void getTest2() {
		boolean status;
		String URL = "https://api.github.com/gists/33/comments";
		Response response = null;
		RestAssured.baseURI = "https://api.github.com/gists";
		RequestSpecification request = RestAssured.given();
		response = request.get(URL);
		response.then().assertThat().statusCode(HttpStatus.SC_OK);
		if(response.getTime()< 500) {
			status = true;
		}else {
			status = false;
		}
		
		Assert.assertTrue(status);

	}

}
