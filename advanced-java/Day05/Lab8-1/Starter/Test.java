import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setData("James", new BigDecimal(100.0));

        BankAccount account2 = new BankAccount();
        account2.setData("Jason", new BigDecimal(110.0));

        System.out.println("BEFORE TRANSFER: ");
        // displayAccountInfo(account1);
        // displayAccountInfo(account2);
        System.out.println(account1);
        System.out.println(account2.toString());

        account1.transferFrom(account2, new BigDecimal(50.0));

        System.out.println("\nAFTER TRANSFER: ");
        displayAccountInfo(account1);
        displayAccountInfo(account2);
    }

    public static void displayAccountInfo(BankAccount account) {
        System.out.println("Account Number: " + account.getNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }
}
