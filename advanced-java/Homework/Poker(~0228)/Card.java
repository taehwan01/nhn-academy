public class Card implements Comparable<Card> {
    private Suit suit;
    private int number;

    Card(Suit suit, int number) {
        this.suit = suit; // 그림
        this.number = number; // 숫자
    }

    public int compareCardNumber(Card card) {
        return this.number - card.number;
    }

    // 카드끼리 높은 수 비교
    @Override
    public int compareTo(Card card) {
        if (this.number != card.number) {
            if (this.number == Constants.MIN_CARD_NUMBER)
                return 1;
            if (card.number == Constants.MIN_CARD_NUMBER)
                return -1;
            return this.number - card.number;
        }

        // 숫자가 같으면 그림 비교
        return this.suit.compareTo(card.suit);

    }

    // 카드 그림, 숫자 출력
    @Override
    public String toString() {
        return this.suit + ", " + this.number;
    }
}
