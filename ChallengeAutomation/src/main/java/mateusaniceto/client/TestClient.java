package mateusaniceto.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestClient {

    private static String TEST = "/test";

    public TestClient(){
        BaseClient.initConfig();
    }

    public Response buscarStatusAplicacao(){
        return
                given().
                when()
                        .get(TEST)
                ;
    }


}
