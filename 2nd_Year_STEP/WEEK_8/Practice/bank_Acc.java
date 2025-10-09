// BankAccount.java
public abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }
}

// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest: $" + interest);
    }
}

// CurrentAccount.java
public class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: $" + interest);
    }
}

// BankTest.java
public class BankTest {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount(5000);
        sa.displayBalance();
        sa.calculateInterest();

        BankAccount ca = new CurrentAccount(8000);
        ca.displayBalance();
        ca.calculateInterest();
    }
}
