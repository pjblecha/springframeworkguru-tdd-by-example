package guru.springframework;

public class Money implements Expression {
    public static final String CURRENCY_DOLLAR = "USD";
    public static final String CURRENCY_FRANC = "CHF";

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected int amount;
    protected String currency;

    public static Money dollar(int amount){
        return new Money(amount, Money.CURRENCY_DOLLAR);
    }

    public static Money franc(int amount) {
        return new Money(amount, Money.CURRENCY_FRANC);
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return amount == money.amount
                && this.currency == money.currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times (int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }
}
