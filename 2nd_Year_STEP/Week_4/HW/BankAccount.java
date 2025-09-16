import java.util.Random;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    public BankAccount() {
        accountHolder = "Unknown";
        accountNumber = new Random().nextInt(90000) + 10000;
        balance = 0.0;
    }

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(90000) + 10000;
        this.balance = 0.0;
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(90000) + 10000;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + ", Account No: " + accountNumber + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Atharv");
        BankAccount a3 = new BankAccount("Edith", 5000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();

        a2.deposit(2000);
        a2.withdraw(500);

        a3.withdraw(6000);
        a3.deposit(1500);
        a3.displayAccount();
    }
}