package mateusaniceto.get;

import mateusaniceto.client.TestClient;
import mateusaniceto.client.UserClient;
import mateusaniceto.model.ListUser;
import mateusaniceto.model.TestResponse;
import mateusaniceto.model.User;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.http.HttpStatus.SC_OK;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.unique;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetUser {

    private UserClient userClient = new UserClient();

    @Test
    public void validarBuscarUsuarioComSucesso(){
        ListUser users = userClient.buscarUsuarioParaAutenticacao().
                then().
                statusCode(SC_OK).
                extract().
                as(ListUser.class)
                ;
    }

    @Test
    public void validarExisteUmUsuario(){
        ListUser users = userClient.buscarUsuarioParaAutenticacao().
                then().
                statusCode(SC_OK).
                extract().
                as(ListUser.class)
                ;

        List<User> userList = users.getUsers();
        assertThat("Deve haver pelo menos um usuário na listagem", userList, is(not(empty())));

    }

    @Test
    public void validarUsuarioUnico() {
        ListUser users = userClient.buscarUsuarioParaAutenticacao()
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(ListUser.class);

        List<User> userList = users.getUsers();
        List<String> usernames = userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        Set<String> uniqueUsernames = new HashSet<>(usernames);
        assertThat("Os nomes de usuário devem ser diferentes", uniqueUsernames, hasSize(usernames.size()));
    }



}
