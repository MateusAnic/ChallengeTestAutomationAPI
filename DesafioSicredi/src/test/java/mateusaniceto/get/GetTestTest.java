package mateusaniceto.get;

import mateusaniceto.client.TestClient;
import mateusaniceto.model.TestResponse;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetTestTest {

    private TestClient testClient = new TestClient();

    @Test
    public void validarBuscarStatusComSucesso(){
        TestResponse testResponse = testClient.buscarStatusAplicacao().
                then().
                statusCode(SC_OK).
                extract().
                as(TestResponse.class)
                ;
    }

    @Test
    public void validarRespostaStatus(){
        TestResponse testResponse = testClient.buscarStatusAplicacao().
                then().
                statusCode(SC_OK).
                extract().
                as(TestResponse.class)
                ;

        assertThat(testResponse.getStatus(), is(equalTo("ok")));
        assertThat(testResponse.getMethod(), is(equalTo("GET")));

    }
}
