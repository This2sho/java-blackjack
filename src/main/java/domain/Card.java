package domain;


public class Card {

    private final Suit suit;
    private final Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }

    public boolean is(Number number) {
        return number.equals(this.number);
    }
}
