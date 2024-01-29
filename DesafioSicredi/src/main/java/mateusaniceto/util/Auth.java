package mateusaniceto.util;

import mateusaniceto.client.AuthClient;
import mateusaniceto.client.UserClient;
import mateusaniceto.model.ListUser;
import mateusaniceto.model.Login;
import mateusaniceto.model.LoginSucess;
import mateusaniceto.model.User;

import static org.apache.http.HttpStatus.SC_OK;

public class Auth {

    private static final UserClient userClient = new UserClient();
    private static final AuthClient authClient = new AuthClient();

    public static String login(){

        Login login = new Login();
        ListUser users = userClient.buscarUsuarioParaAutenticacao().
                then().
                    statusCode(SC_OK).
                    extract().
                    as(ListUser.class)
                ;

        User firstUser = users.get(0);

        login.setUsername(firstUser.getUsername());
        login.setPassword(firstUser.getPassword());


        return authClient.criacaoTokenAutenticacao(login).
                then().
                statusCode(SC_OK).
                extract().
                path("token");
    }
}
