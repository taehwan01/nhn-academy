public class BankAccount {
    private int account;
    private String ownerName;
    private int balance;
    private static int interest;

    public static int getInterest() {
        return interest;
    }

    public static void setInterest(int newInterest) {
        interest = newInterest;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAccount() {
        return this.account;
    }

    public String getOwner() {
        return this.ownerName;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public boolean withdraw(int amount) {
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }
}
