public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked = false;

    public SecureBankAccount(String accNo, double initialBalance) {
        this.accountNumber = accNo;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance(int enteredPin) {
        if (enteredPin == pin && !isLocked) return balance;
        return -1; // error
    }

    public void setPin(int oldPin, int newPin) {
        if (oldPin == pin) pin = newPin;
    }

    public void deposit(double amount, int enteredPin) {
        if (enteredPin == pin && !isLocked) balance += amount;
    }

    public void withdraw(double amount, int enteredPin) {
        if (enteredPin == pin && !isLocked && balance >= amount) balance -= amount;
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC123", 1000);
        acc1.setPin(0, 1234);
        acc1.deposit(500, 1234);
        acc1.withdraw(300, 1234);
        System.out.println("Balance: " + acc1.getBalance(1234)); 
    }
}
