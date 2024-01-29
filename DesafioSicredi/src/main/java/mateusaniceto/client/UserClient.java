package mateusaniceto.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static String USERS = "/users";

    public UserClient(){
        BaseClient.initConfig();
    }

    public Response buscarUsuarioParaAutenticacao(){
        return
                given().
                when()
                        .get(USERS)
                ;
    }


}
