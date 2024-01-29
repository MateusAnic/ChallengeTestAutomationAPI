package mateusaniceto.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mateusaniceto.model.Product;

import static io.restassured.RestAssured.given;

public class ProductClient {
    private static String PRODUCTS = "/products";

    public ProductClient(){
        BaseClient.initConfig();
    }

    public Response criarProduto(Product product){
        return
                given().
                    contentType(ContentType.JSON).
                    body(product).
                when()
                        .post(PRODUCTS)
                ;
    }

    public Response buscarTodosProdutos(){
        return
                given().
                when()
                        .get(PRODUCTS)
                ;
    }

    public Response buscarProdutoPorId(int idUser){
        return
                given().
                        pathParam("id", idUser).
                when()
                        .get(PRODUCTS)
                ;
    }


}
