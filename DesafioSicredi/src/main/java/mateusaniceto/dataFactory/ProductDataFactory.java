package mateusaniceto.dataFactory;

import mateusaniceto.model.Product;
import net.datafaker.Faker;

import java.util.Locale;

public class ProductDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static Product novoProduto(){
        Product novoProduto = new Product();
        novoProduto.setTitle(faker.food().dish());
        novoProduto.setDescription(faker.text().text(3));
        novoProduto.setPrice(faker.number().randomDigit());
        novoProduto.setDiscountPercentage(faker.number().randomDouble(2, 1, 50));
        novoProduto.setRating(faker.number().randomDouble(2, 1, 10));
        novoProduto.setStock(faker.number().randomDigit());
        novoProduto.setBrand(faker.commerce().brand());
        novoProduto.setCategory(faker.restaurant().type());
        novoProduto.setThumbnail(faker.internet().domainName());

        return novoProduto;
    }
}
