package lab;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = 0; // default
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance(int enteredPin) {
        if (enteredPin == pin) return balance;
        return -1; // wrong PIN
    }

    public void setPin(int oldPin, int newPin) {
        if (oldPin == pin) pin = newPin;
    }

    public void deposit(double amount, int enteredPin) {
        if (enteredPin == pin && amount > 0) balance += amount;
    }

    public void withdraw(double amount, int enteredPin) {
        if (enteredPin == pin && amount <= balance) balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("AC001", 1000);
        acc.setPin(0, 1234);
        acc.deposit(500, 1234);
        acc.withdraw(200, 1234);
        System.out.println("Balance: " + acc.getBalance(1234)); // 1300
    }
}
