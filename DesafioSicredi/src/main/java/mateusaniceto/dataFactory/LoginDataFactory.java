package mateusaniceto.dataFactory;

import mateusaniceto.model.Login;
import net.datafaker.Faker;

import java.util.Locale;

public class LoginDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static Login loginInvalido(){
        Login loginInvalido = new Login();
        loginInvalido.setUsername(faker.internet().username());
        loginInvalido.setPassword(faker.internet().password());

        return loginInvalido;
    }
}
