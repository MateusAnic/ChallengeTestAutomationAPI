package mateusaniceto.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mateusaniceto.model.Login;
import mateusaniceto.util.Auth;

import static io.restassured.RestAssured.given;

public class AuthClient {

    private static String AUTH = "/auth";
    private static String LOGIN = "/login";
    private static String PRODUCTS = "/products";

    public AuthClient(){
        BaseClient.initConfig();
    }

    private static String token = Auth.login();

    public Response criacaoTokenAutenticacao(Login login){
        return
                given().
                    contentType(ContentType.JSON).
                    body(login).
                when()
                        .post(AUTH + LOGIN)
                ;
    }

    public Response buscarProdutoComAutenticacao(){
        return
                given().
                        header("Authorization", token).
                        contentType(ContentType.JSON).

                when()
                        .get(AUTH + PRODUCTS)
                ;
    }

    public Response buscarProdutoComAutenticacaoInvalida(){
        return
                given().
                        header("Authorization", "arrozfeijaoebatata").
                        contentType(ContentType.JSON).
                when()
                        .get(AUTH + PRODUCTS)
                ;
    }

    public Response buscarProdutoSemAutenticacao(){
        return
                given().
                        contentType(ContentType.JSON).
                when()
                        .get(AUTH + PRODUCTS)
                ;
    }



}
