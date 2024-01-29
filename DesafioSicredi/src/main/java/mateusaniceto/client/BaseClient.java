package mateusaniceto.client;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public abstract class BaseClient {
    public static void initConfig(){
        baseURI = "https://dummyjson.com";
        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
