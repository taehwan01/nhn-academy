import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        int countOfUsers = getUserCount();
        User[] users = createUsers(countOfUsers);

        System.out.println(countOfUsers + "명의 플레이어로 게임을 시작합니다.");
        Cards cards = new Cards();
        cards.shuffle();

        handOutCards(users, cards);

        for (int i = 0; i < countOfUsers; i++) {
            User user = users[i];
            System.out.println((i + 1) + "번 사용자 패를 확인합니다: ");
            user.checkPairs();
            System.out.println(user.getResult());
        }

        int winnerIndex = findWinnerIndex(users);
        System.out.println("승자는 " + (winnerIndex + 1) + " 번 플레이어입니다 ~ !");
    }

    // 플레이어 수 입력
    private static int getUserCount() {
        Scanner sc = new Scanner(System.in);
        int countOfUsers;
        do {
            System.out.print("플레이어 수를 입력해주세요 (2 ~ 10명): ");
            countOfUsers = sc.nextInt();
        } while (countOfUsers < Constants.MIN_USERS || countOfUsers > Constants.MAX_USERS);
        sc.close();
        return countOfUsers;
    }

    // 플레이어 생성자 호출
    private static User[] createUsers(int countOfUsers) {
        User[] users = new User[countOfUsers];
        for (int i = 0; i < countOfUsers; i++) {
            users[i] = new User();
        }
        return users;
    }

    // 플레이어들에게 카드 배분
    private static void handOutCards(User[] users, Cards cards) {
        System.out.println("카드를 배분합니다...");
        for (int i = 0; i < Constants.PLAYER_CARDS; i++) {
            for (User user : users) {
                Card card = cards.pop();
                user.getCard(card);
            }
        }
    }

    // 승자 찾기
    private static int findWinnerIndex(User[] users) {
        User winner = users[0];
        int winnerIndex = 0;
        for (int i = 1; i < users.length; i++) {
            if (winner.compareTo(users[i]) < 0) {
                winner = users[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}
