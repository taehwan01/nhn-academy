public class Birthday {
    public static void main(String[] args) {
        BoyFriends boys = new BoyFriends();

        boys.add(new BoyFriend("Julio", 23));
        boys.add(new BoyFriend("Jorge", 24));

        for (BoyFriend boy : boys) {
            boy.hear("BRING 50,000₩");
        }
    }
}
