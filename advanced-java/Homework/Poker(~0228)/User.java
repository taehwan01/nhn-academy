import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class User implements Comparable<User> {
    private List<Card> userCards;
    private int pairWinnings;

    public User() {
        this.userCards = new ArrayList<>();
        this.pairWinnings = 0;
    }

    // 카드 배분 받기
    public void getCard(Card card) {
        this.userCards.add(card);
    }

    // 페어 수 확인
    public void checkPairs() {
        for (int i = 0; i < userCards.size() - 1; i++) {
            for (int j = i + 1; j < userCards.size(); j++) {
                Card cardA = userCards.get(i);
                Card cardB = userCards.get(j);
                if (cardA.compareCardNumber(cardB) == 0) {
                    this.pairWinnings++;
                }
            }
        }
    }

    // 각 플레이어 별로 결과 및 페어 수 출력
    public String getResult() {
        Collections.sort(userCards); // 사용자 카드 정렬, 승자 구분을 위해 카드, 그림 비교하기 위해 결과 출력 시 미리 정렬
        String result = "[";
        for (int i = 0; i < userCards.size(); i++) {
            Card card = userCards.get(i);
            if (i == userCards.size() - 1) {
                result += "(" + card.toString() + ")";
            } else {
                result += "(" + card.toString() + "), ";
            }
        }
        result += "]\n";

        if (this.pairWinnings == 1)
            result += "One Pair ~ !\n";
        else if (this.pairWinnings == 2)
            result += "Two Pair ~ !\n";

        return result;
    }

    // 승자 구분을 위해 플레이어끼리 비교
    @Override
    public int compareTo(User user) {
        if (this.pairWinnings == user.pairWinnings) {
            // 페어 수 비교 -> 카드 숫자 비교 -> 그림 숫자 비교
            for (int i = 0; i < this.userCards.size(); i++) {
                if (this.userCards.get(i).compareCardNumber(user.userCards.get(i)) != 0) {
                    return this.userCards.get(i).compareTo(user.userCards.get(i));
                }
            }
        }
        return this.pairWinnings - user.pairWinnings;
    }
}
