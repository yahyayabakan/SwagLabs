package com.SwagLabs.stepdefs;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class APIStepDefs {
    Response response;
    JsonPath jsonPath;
    private static final String BASE_URL = "https://reqres.in/";
    private static final String BASE_PATH = "api/";

    @When("user retrieves the all persons")
    public void user_retrieves_the_all_persons() {
        response =
                given()
                        .baseUri(BASE_URL)
                        .basePath(BASE_PATH).
                when()
                        .get("users?page=1");


    }

    @Then("all persons status code should be {int}")
    public void all_persons_status_code_should_be(int status) {
        assertEquals(status,response.statusCode());
    }

    @And("all persons response includes the total {int}")
    public void allPersonsResponseIncludesTheTotal(int total) {
        jsonPath = response.jsonPath();
        assertEquals(total,jsonPath.getInt("total"));
    }

    @When("user retrieves one person id {int}")
    public void user_retrieves_one_person_id(int id) {
        response =
                given()
                        .baseUri(BASE_URL)
                        .basePath(BASE_PATH).
                when()
                        .get("users/" + id);

    }
    @Then("one person status code should be {int}")
    public void one_person_status_code_should_be(int status) {
        assertEquals(status,response.statusCode());
    }
    @Then("one person response includes firstName {string}, lastName {string}")
    public void one_person_response_includes_first_name_last_name(String firstName, String lastName) {
        JsonPath jsonPath = response.jsonPath();
        assertEquals(firstName, jsonPath.getString("data.first_name"));
        assertEquals(lastName, jsonPath.getString("data.last_name"));
    }


    @When("user posts a person with name {string} and job {string}")
    public void userPostsAPersonWithNameAndJob(String name, String job) {
        Map<String, String> newPerson = new HashMap<>();
        newPerson.put("name",name);
        newPerson.put("job", job);

        JsonPath jsonPath =
                given()
                        .contentType(ContentType.JSON)
                        .body(newPerson).
                when()
                        .post("users").
                then()
                        .statusCode(201)
                        .extract().jsonPath();
    }

    @And("one person should be created")
    public void onePersonShouldBeCreated() {
    }
}
