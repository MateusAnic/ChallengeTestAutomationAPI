package mateusaniceto.post;

import io.restassured.response.Response;
import mateusaniceto.client.ProductClient;
import mateusaniceto.dataFactory.ProductDataFactory;
import mateusaniceto.model.InvalidProduct;
import mateusaniceto.model.Product;
import mateusaniceto.model.ProductCreated;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PostProductTest {

    private ProductClient productClient = new ProductClient();
    private ProductDataFactory productDataFactory = new ProductDataFactory();


    @Test
    public void validarCriarNovoProdutoComSucesso(){
        Product produto = productDataFactory.novoProduto();
        ProductCreated novoProduto = productClient.criarProduto(produto).
                then().
                statusCode(SC_OK).
                extract().
                as(ProductCreated.class)
                ;

        Integer idProduto = novoProduto.getId();
        assertThat(idProduto, is(not(nullValue())));
    }

    @Test
    public void validarCriarNovoProdutoComCampoVazio(){
        Product produtoVazio = productDataFactory.novoProdutoCamposVazios();
        ProductCreated novoProduto = productClient.criarProduto(produtoVazio).
                then().
                statusCode(SC_OK).
                extract().
                as(ProductCreated.class)
                ;

        Integer idProduto = novoProduto.getId();
        Integer stockProduto = novoProduto.getStock();
        Integer ratingProduto = novoProduto.getRating();
        String thumbnailProduto = novoProduto.getThumbnail();
        String descriptionProduto = novoProduto.getDescription();
        String brandProduto = novoProduto.getBrand();
        assertThat(idProduto, is(not(nullValue())));
        assertThat(stockProduto, is(nullValue()));
        assertThat(ratingProduto, is(nullValue()));
        assertThat(thumbnailProduto, is(nullValue()));
        assertThat(descriptionProduto, is(nullValue()));
        assertThat(brandProduto, is(nullValue()));
    }

    @Test
    public void validarCriarNovoProdutoInvalido(){
        InvalidProduct produtoInvalido = productDataFactory.novoProdutoInvalido();
        Response novoProduto = productClient.criarProdutoInvalido(produtoInvalido).
                then().
                statusCode(SC_OK).
                extract().
                response()
                ;
    }

}
