public class BankAccount {
    private int accountNo;
    private String ownerName;

    public BankAccount(String ownerName) {
        this.accountNo = AccountCreator.getAccountCreator().getNextAccountNo();
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return this.accountNo + ", " + this.ownerName;
    }
}

class Test4 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Monte");
        BankAccount account2 = new BankAccount("Tae Hwan");
        BankAccount account3 = new BankAccount("Pani");

        System.out.println(account1.toString());
        System.out.println(account2.toString());
        System.out.println(account3.toString());
    }
}