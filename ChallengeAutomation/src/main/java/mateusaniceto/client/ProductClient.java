package mateusaniceto.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mateusaniceto.model.InvalidProduct;
import mateusaniceto.model.Product;

import static io.restassured.RestAssured.given;

public class ProductClient {
    private static String PRODUCTS = "/products";
    private static String ADD = "/add";
    private static String ID = "/{id}";

    public ProductClient(){
        BaseClient.initConfig();
    }

    public Response criarProduto(Product product){
        return
                given().
                    contentType(ContentType.JSON).
                    body(product).
                when()
                        .post(PRODUCTS + ADD)
                ;
    }

    public Response criarProdutoInvalido(InvalidProduct InvalidProduct){
        return
                given().
                        contentType(ContentType.JSON).
                        body(InvalidProduct).
                when()
                        .post(PRODUCTS + ADD)
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
                        .get(PRODUCTS + ID)
                ;
    }

    public Response buscarProdutoPorIdString(String idUser){
        return
                given().
                        pathParam("id", idUser).
                when()
                        .get(PRODUCTS + ID)
                ;
    }


}
