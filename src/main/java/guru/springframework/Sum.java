package guru.springframework;

public class Sum implements Expression {
    Money augend;
    Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String curr) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, curr);
    }
}
