package com.brainlab;

import io.javalin.Javalin;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class Tests {

    private static Javalin app;

    @BeforeClass
    public static void setup() {
        RestAssured.port = 5000;
        RestAssured.baseURI = "http://localhost";
        app = App.start();
    }

    @AfterClass
    public static void after() {
        app.stop();
    }

    @Test
    public void noOperands1() {
        given().when().get("/calculator/add")
                .then().body(containsString("{\"sum\":0}"));
    }

    @Test
    public void noOperands2() {
        given().when().get("/calculator/add?operands=")
                .then().body(containsString("{\"sum\":0}"));
    }

    @Test
    public void validOperands1() {
        given().when().get("/calculator/add?operands=7,-7")
                .then().body(containsString("{\"sum\":0.0}"));
    }

    @Test
    public void validOperands2() {
        given().when().get("/calculator/add?operands=7,-74,23,65.12,-12.24,45.50,434,-23")
                .then().body(containsString("{\"sum\":465.38}"));
    }

    @Test
    public void invalidOperands() {
        given().when().get("/calculator/add?operands=1,2,foo")
                .then().body(containsString("{\"error\":\"For input string: \\\"foo\\\"\"}"));
    }

}
