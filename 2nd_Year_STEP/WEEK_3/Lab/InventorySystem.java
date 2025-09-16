class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;

    static int totalProducts = 0;
    static double totalInventoryValue = 0;
    static int lowStockCount = 0;
    static String[] categories = new String[100];
    static int categoryCount = 0;

    Product(String productId, String productName, double price, int quantity, String supplierName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;
        totalProducts++;
        categories[categoryCount++] = category;
    }

    void addStock(int quantity) {
        this.quantity += quantity;
    }

    void reduceStock(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough stock to reduce for " + productName);
        }
    }

    boolean isLowStock() {
        return quantity < 10;
    }

    double calculateProductValue() {
        return price * quantity;
    }

    void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    void displayProductInfo() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: " + price + ", Qty: " + quantity + ", Supplier: " + supplierName + ", Category: " + category);
    }

    static double calculateTotalInventoryValue(Product[] products) {
        double total = 0;
        for (Product p : products) {
            if (p != null) total += p.calculateProductValue();
        }
        totalInventoryValue = total;
        return total;
    }

    static void findLowStockProducts(Product[] products) {
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                lowStockCount++;
                p.displayProductInfo();
            }
        }
    }

    static void generateInventoryReport(Product[] products) {
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Inventory Value: " + calculateTotalInventoryValue(products));
        System.out.println("Low Stock Products: ");
        findLowStockProducts(products);
    }

    static Product searchProduct(Product[] products, String productName) {
        for (Product p : products) {
            if (p != null && p.productName.equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Product[] products = new Product[5];

        products[0] = new Product("P001", "Laptop", 50000, 5, "Dell", "Electronics");
        products[1] = new Product("P002", "Phone", 20000, 15, "Samsung", "Electronics");
        products[2] = new Product("P003", "Book", 500, 50, "Pearson", "Stationery");
        products[3] = new Product("P004", "Table", 3000, 8, "Ikea", "Furniture");
        products[4] = new Product("P005", "Pen", 50, 100, "Reynolds", "Stationery");

        products[0].addStock(10);
        products[1].reduceStock(5);
        products[2].updatePrice(550);

        Product.searchProduct(products, "Laptop").displayProductInfo();
        Product.generateInventoryReport(products);
    }
}
