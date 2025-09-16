import java.util.UUID;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    public PersonalAccount(String name, double openingBalance) {
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = openingBalance;
        this.totalIncome = openingBalance > 0 ? openingBalance : 0;
        this.totalExpenses = 0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount <= 0) return;
        currentBalance += amount;
        totalIncome += amount;
    }

    public void addExpense(double amount, String description) {
        if (amount <= 0) return;
        currentBalance -= amount;
        totalExpenses += amount;
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("-------------------------------------------------");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: %.2f%n", currentBalance);
        System.out.printf("Total Income: %.2f%n", totalIncome);
        System.out.printf("Total Expenses: %.2f%n", totalExpenses);
        System.out.printf("Calculated Savings (Income - Expenses): %.2f%n", calculateSavings());
        System.out.println("-------------------------------------------------");
    }

    public static void setBankName(String name) {
        if (name != null && !name.isEmpty()) bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "AC" + System.currentTimeMillis() + "-" + (totalAccounts + 1);
    }

    // Getters for potential testing use
    public String getAccountNumber() { return accountNumber; }
    public double getCurrentBalance() { return currentBalance; }
}

public class Assignment1 {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Atharv National Bank");

        PersonalAccount acc1 = new PersonalAccount("Riya Sharma", 1000.00);
        PersonalAccount acc2 = new PersonalAccount("Vikram Joshi", 500.00);
        PersonalAccount acc3 = new PersonalAccount("Pooja Verma", 0.00);

        acc1.addIncome(2500.00, "Salary");
        acc1.addExpense(450.50, "Groceries");
        acc1.addExpense(1200.00, "Rent");

        acc2.addIncome(1500.00, "Freelance");
        acc2.addExpense(300.00, "Utilities");
        acc2.addExpense(200.00, "Shopping");

        acc3.addIncome(800.00, "Part-time");
        acc3.addExpense(50.00, "Transport");

        System.out.println("Total accounts created: " + PersonalAccount.getTotalAccounts());
        System.out.println();

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();

        PersonalAccount.setBankName("Global Trust Bank");

        acc3.displayAccountSummary();

        System.out.println("Note: bankName is static and therefore shown as same for all accounts (last set value).");
    }
}










