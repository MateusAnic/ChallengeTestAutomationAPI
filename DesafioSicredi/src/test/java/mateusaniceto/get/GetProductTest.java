package mateusaniceto.get;

import mateusaniceto.client.ProductClient;
import mateusaniceto.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetProductTest {

    private ProductClient productClient = new ProductClient();

    @Test
    public void validarBuscarProdutosComSucesso(){
        ListProduct listProduct = productClient.buscarTodosProdutos().
                then().
                statusCode(SC_OK).
                extract().
                as(ListProduct.class)
                ;

        List<Product> produtos = listProduct.getProducts();

        assertThat(produtos, is(not(empty())));
    }

    @Test
    public void validarBuscarProdutoPorIdComSucesso(){
        Random random = new Random();
        Integer randomId = random.nextInt(10);
        Product produto = productClient.buscarProdutoPorId(randomId).
                then().
                statusCode(SC_OK).
                extract().
                as(Product.class)
                ;

        Integer idProduto = produto.getId();
        assertThat(idProduto, is(equalTo(randomId)));

    }

    @Test
    public void validarBuscarProdutoPorIdSemSucesso(){
        Forbidden produto = productClient.buscarProdutoPorId(0).
                then().
                statusCode(SC_NOT_FOUND).
                extract().
                as(Forbidden.class)
                ;

        String message = produto.getMessage();
        assertThat("Deve informar uma mensagem de que o produto não foi encontrado", message.equals("Product with id \'0\' not found"));
    }


    @Test
    public void validarBuscarProdutoPorIdNegativo(){
        Forbidden produto = productClient.buscarProdutoPorId(-10).
                then().
                statusCode(SC_NOT_FOUND).
                extract().
                as(Forbidden.class)
                ;

        String message = produto.getMessage();
        assertThat("Deve informar uma mensagem de que o produto não foi encontrado", message.equals("Product with id \'-10\' not found"));
    }

    @Test
    public void validarBuscarProdutoPorIdString(){
        Forbidden produto = productClient.buscarProdutoPorIdString("arroz e feijao").
                then().
                statusCode(SC_NOT_FOUND).
                extract().
                as(Forbidden.class)
                ;

        String message = produto.getMessage();
        assertThat("Deve informar uma mensagem de que o produto não foi encontrado", message.equals("Product with id \'arroz e feijao\' not found"));
    }

}
