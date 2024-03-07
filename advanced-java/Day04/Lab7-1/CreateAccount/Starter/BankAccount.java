import java.math.*;
import java.util.Scanner;

public class BankAccount {
    private long accountNumber;
    private String ownerName;
    private BigDecimal balance;

    private static long nextAccountNumber;

    public static long nextNumber() {
        return nextAccountNumber++;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    public void setData(String ownerName, BigDecimal balance) {
        this.accountNumber = nextNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

class CreateAccount {
    public static BankAccount createNewBankAccount(String ownerName, BigDecimal balance) {
        BankAccount newAccount = new BankAccount();

        newAccount.setData(ownerName, balance);

        return newAccount;
    }

    public static void printBankAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }

    public static void testDeposit(BankAccount account) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER AMOUNT: ");
        BigDecimal amount = new BigDecimal(sc.next());
        account.deposit(amount);
        sc.close();
    }

    public static void main(String[] args) {
        BankAccount bankAccount = CreateAccount.createNewBankAccount("Vesper Lind", new BigDecimal("0.0"));
        BankAccount bankAccount2 = CreateAccount.createNewBankAccount("Celine", new BigDecimal("100.0"));

        printBankAccount(bankAccount);
        testDeposit(bankAccount);
        printBankAccount(bankAccount);

        printBankAccount(bankAccount2);
        testDeposit(bankAccount2);
        printBankAccount(bankAccount2);
    }
}