package guru.springframework;

import java.util.HashMap;

public class Bank {

    Money reduce(Expression source, String currency) {
        return source.reduce(this, currency);
    }

    public int rate(String from, String to) {
        return (from.equals(to)) ? 1 : rateMap.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }

    private HashMap<Pair, Integer> rateMap = new HashMap<>();
}
