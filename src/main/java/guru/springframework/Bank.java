package guru.springframework;

public class Bank {

    Money reduce(Expression source, String currency) {
        return source.reduce(currency);
    }
}
