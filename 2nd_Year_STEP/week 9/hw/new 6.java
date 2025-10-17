interface Discount {
    double apply(double amount);}

class Payment {
    void processTransaction(double amount) {
        class Validator {
            boolean isValid(double amt) {
                return amt > 0;
            }}

        Validator validator = new Validator();
        if (!validator.isValid(amount)) {
            System.out.println("Invalid payment amount.");
            return;}
        Discount discount = new Discount() {
            public double apply(double amt) {
                return amt * 0.9; // 10% discount
            }};
        double finalAmount = discount.apply(amount);
        System.out.println("Payment processed. Final amount after discount: " + finalAmount);
    }}
public class Main {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(1000);
        p.processTransaction(-50);
    }}