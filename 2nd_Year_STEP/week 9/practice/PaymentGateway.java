class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }}
class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid via Credit Card");
    }}
class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid via Wallet");
    }}
public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment(),
            new WalletPayment(),
            new Payment()
        };
        for (Payment p : payments) {
            System.out.println("Processing: " + p.getClass().getSimpleName());
            p.pay();
            System.out.println();
        } }}