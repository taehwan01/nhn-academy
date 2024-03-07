public class AccountCreator {
    // public static AccountCreator accountCreator;
    private static AccountCreator accountCreator;
    private int nextAccountNo = 0;

    private AccountCreator() {
    }

    public static AccountCreator getAccountCreator() {
        if (accountCreator == null) {
            accountCreator = new AccountCreator();
        }

        return accountCreator;
    }

    public int getNextAccountNo() {
        return this.nextAccountNo++;
    }
}

class Test3 {
    public static void main(String[] args) {
        // AccountCreator accountCreator = new AccountCreator();
        // AccountCreator accountCreator = AccountCreator.getAccountCreator();
        // int no = accountCreator.getNextAccountNo();
        // no = accountCreator.getNextAccountNo();
        // no = accountCreator.getNextAccountNo();
        // System.out.println(no);
    }
}