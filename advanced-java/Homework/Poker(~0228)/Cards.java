import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
    private List<Card> cards;

    // 전체 카드 목록 생성
    public Cards() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int j = Constants.MIN_CARD_NUMBER; j <= Constants.MAX_CARD_NUMBER; j++) {
                this.cards.add(new Card(suit, j));
            }
        }
    }

    // 맨 위에 있는 카드 뽑기
    public Card pop() {
        return this.cards.removeLast();
    }

    // 전체 카드 섞기
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
