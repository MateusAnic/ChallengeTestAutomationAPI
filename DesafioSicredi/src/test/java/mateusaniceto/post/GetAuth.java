package mateusaniceto.post;

import mateusaniceto.client.AuthClient;
import mateusaniceto.model.*;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetAuth {

    private AuthClient authClient = new AuthClient();

    @Test
    public void validarBuscarProdutosAutenticadoComSucesso(){
       ListProduct listProduct = authClient.buscarProdutoComAutenticacao().
               then().
               statusCode(SC_OK).
               extract().
               as(ListProduct.class)
               ;

       assertThat(listProduct.getProducts(), is(not(empty())));
    }

    @Test
    public void validarBuscarProdutosComAutenticacaoInvalida(){
        Unauthorized listProductWithoutAuth = authClient.buscarProdutoComAutenticacaoInvalida().
                then().
                log().all().
                statusCode(SC_UNAUTHORIZED).
                extract().
                as(Unauthorized.class)
                ;

        assertThat(listProductWithoutAuth.getName(), is(equalTo("JsonWebTokenError")));
        assertThat(listProductWithoutAuth.getMessage(), is(equalTo("Invalid/Expired Token!")));
    }

    @Test
    public void validarBuscarProdutosSemAutenticacao(){
        Forbidden listProduct = authClient.buscarProdutoSemAutenticacao().
                then().
                statusCode(SC_FORBIDDEN).
                extract().
                as(Forbidden.class)
                ;

        assertThat(listProduct.getMessage(), is(equalTo("Authentication Problem")));
    }



}
