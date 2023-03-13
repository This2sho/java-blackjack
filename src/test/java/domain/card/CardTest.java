package domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    @DisplayName("카드의 타입과 숫자를 입력했을 때 카드 객체가 정상적으로 생성된다.")
    void makeCard() {
        Suit suit = Suit.CLOVER;
        Denomination denomination = Denomination.A;

        assertDoesNotThrow(() -> new Card(suit, denomination));
    }

    @Test
    @DisplayName("카드의 숫자를 입력했을 때 해당 카드의 숫자와 일치하는지 판단한다.")
    void isTest() {

        Card card = new Card(Suit.CLOVER, Denomination.EIGHT);

        assertThat(card.is(Denomination.EIGHT)).isTrue();
    }
}
