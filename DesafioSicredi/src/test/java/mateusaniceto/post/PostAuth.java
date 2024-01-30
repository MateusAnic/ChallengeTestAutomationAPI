package mateusaniceto.post;

import mateusaniceto.client.AuthClient;
import mateusaniceto.client.UserClient;
import mateusaniceto.dataFactory.LoginDataFactory;
import mateusaniceto.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PostAuth {

    private UserClient userClient = new UserClient();
    private AuthClient authClient = new AuthClient();
    private LoginDataFactory loginDataFactory = new LoginDataFactory();

    @Test
    public void validarLogarUsuarioComSucesso(){
        Login login = new Login();
        ListUser users = userClient.buscarUsuarioParaAutenticacao().
                then().
                statusCode(SC_OK).
                extract().
                as(ListUser.class)
                ;

        List<User> userList = users.getUsers();
        if (userList.isEmpty()) {
            throw new RuntimeException("Não há usuários na lista.");
        }

        User firstUser = users.get(0);

        login.setUsername(firstUser.getUsername());
        login.setPassword(firstUser.getPassword());

        LoginSucess loginResult = authClient.criacaoTokenAutenticacao(login).
                then().
                statusCode(SC_OK).
                extract().
                as(LoginSucess.class)
                ;

        String token = loginResult.getToken();
        assertThat(token, is(not(emptyString())));
    }

    @Test
    public void validarLogarUsuarioSemSucesso(){
        Forbidden loginSemSucesso = authClient.criacaoTokenAutenticacao(LoginDataFactory.loginInvalido()).
                then().
                statusCode(SC_BAD_REQUEST).
                extract().
                as(Forbidden.class)
        ;

        String message = loginSemSucesso.getMessage();

        assertThat("Deve exibir uma mensagem informando que as credenciais são inválidas", message.equals("Invalid credentials"));
    }




}
