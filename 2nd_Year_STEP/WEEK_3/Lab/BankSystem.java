import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient funds");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[5];

        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 2000);

        accounts[0].deposit(500);
        accounts[1].withdraw(1000);

        accounts[0].checkBalance();
        accounts[1].checkBalance();

        accounts[0].displayAccountInfo();
        accounts[1].displayAccountInfo();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}
