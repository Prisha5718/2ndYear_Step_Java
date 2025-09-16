public class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double fixedRate = 150.0;

    public FoodOrder() {
        customerName = "Unknown";
        foodItem = "Unknown";
        quantity = 0;
        price = 0.0;
    }

    public FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = fixedRate;
    }

    public FoodOrder(String foodItem, int quantity) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName + ", Food: " + foodItem + ", Quantity: " + quantity + ", Total: " + price);
    }

    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Pizza");
        FoodOrder o3 = new FoodOrder("Burger", 3);
        FoodOrder o4 = new FoodOrder("Atharv", "Pasta", 2, 400.0);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}