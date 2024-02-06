package guru.springframework;

public abstract class Money {
    public static final String CURRENCY_DOLLAR = "USD";
    public static final String CURRENCY_FRANC = "CHF";

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected int amount;
    protected String currency;

    public abstract Money times(int multiplier);

    public static Money dollar(int amount){
        return new Dollar(amount, Money.CURRENCY_DOLLAR);
    }

    public static Money franc(int amount) {
        return new Franc(amount, Money.CURRENCY_FRANC);
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return amount == money.amount
                && getClass().equals(object.getClass());
    }

}
