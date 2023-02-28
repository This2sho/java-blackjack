package domain;

public enum Type {
    CLOVER("클로버"),
    HEART("하트"),
    SPACE("스페이스"),
    DIAMOND("다이아몬드");

    private final String name;

    Type(String name) {
        this.name = name;
    }
}
