package domain;

import java.util.List;

public class Cards {

    public static final int BLACKJACK_NUMBER = 21;
    public static final int ADDITIONAL_A_VALUE = 10;

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int getScore() {
        int sum = getSum();
        if (hasA()) {
            return calculateAValues(sum);
        }
        return sum;
    }

    private int getSum() {
        return cards.stream()
            .map(Card::getNumber)
            .map(Number::getValue)
            .reduce(Integer::sum)
            .orElse(0);
    }

    private boolean hasA() {
        return cards.stream()
            .anyMatch(c -> c.is(Number.A));
    }

    private int calculateAValues(int sum) {
        if (sum + ADDITIONAL_A_VALUE > BLACKJACK_NUMBER) {
            return sum;
        }
        return sum + ADDITIONAL_A_VALUE;
    }
}
