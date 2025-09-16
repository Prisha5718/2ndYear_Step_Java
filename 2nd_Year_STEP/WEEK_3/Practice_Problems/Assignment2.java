import java.util.*;

public class Assignment2 {
    static class Product {
        String productId;
        String productName;
        double price;
        String category;
        int stockQuantity;
        static int totalProducts = 0;
        static Set<String> categories = new HashSet<>();

        public Product(String productId, String productName, double price, String category, int stockQuantity) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.category = category;
            this.stockQuantity = stockQuantity;
            totalProducts++;
            categories.add(category);
        }

        public static Product findProductById(Product[] products, String productId) {
            for (Product p : products) if (p.productId.equals(productId)) return p;
            return null;
        }

        public static List<Product> getProductsByCategory(Product[] products, String category) {
            List<Product> list = new ArrayList<>();
            for (Product p : products) if (p.category.equalsIgnoreCase(category)) list.add(p);
            return list;
        }
    }

    static class ShoppingCart {
        String cartId;
        String customerName;
        Map<Product, Integer> items = new LinkedHashMap<>();
        double cartTotal = 0.0;

        public ShoppingCart(String cartId, String customerName) {
            this.cartId = cartId;
            this.customerName = customerName;
        }

        public void addProduct(Product product, int quantity) {
            if (product == null || quantity <= 0) return;
            if (product.stockQuantity < quantity) quantity = product.stockQuantity;
            if (quantity == 0) return;
            items.put(product, items.getOrDefault(product, 0) + quantity);
            product.stockQuantity -= quantity;
            calculateTotal();
        }

        public void removeProduct(String productId) {
            Product key = null;
            for (Product p : items.keySet()) {
                if (p.productId.equals(productId)) {
                    key = p;
                    break;
                }
            }
            if (key != null) {
                int qty = items.remove(key);
                key.stockQuantity += qty;
                calculateTotal();
            }
        }

        public void calculateTotal() {
            cartTotal = 0.0;
            for (Map.Entry<Product, Integer> e : items.entrySet()) cartTotal += e.getKey().price * e.getValue();
        }

        public void displayCart() {
            System.out.println("Cart ID: " + cartId + " | Customer: " + customerName);
            if (items.isEmpty()) { System.out.println("Cart is empty."); return; }
            for (Map.Entry<Product, Integer> e : items.entrySet()) {
                System.out.printf("%s (%s) x %d = %.2f%n", e.getKey().productName, e.getKey().productId, e.getValue(), e.getKey().price * e.getValue());
            }
            System.out.printf("Cart Total: %.2f%n", cartTotal);
        }

        public void checkout() {
            calculateTotal();
            System.out.printf("%s checked out. Total paid: %.2f%n", customerName, cartTotal);
            items.clear();
            cartTotal = 0.0;
        }
    }

    public static void main(String[] args) {
        Product[] catalog = {
            new Product("P001","Wireless Mouse",349.0,"Electronics",50),
            new Product("P002","Keyboard",499.0,"Electronics",30),
            new Product("P003","HDMI Cable",199.0,"Electronics",100),
            new Product("P004","Notebook",49.0,"Stationery",200),
            new Product("P005","Pen Pack",29.0,"Stationery",300),
            new Product("P006","Water Bottle",199.0,"Home",150),
            new Product("P007","Backpack",899.0,"Accessories",80),
            new Product("P008","Running Shoes",2499.0,"Footwear",40),
            new Product("P009","T-Shirt",599.0,"Apparel",120),
            new Product("P010","Smartphone Stand",199.0,"Accessories",60)
        };

        ShoppingCart cart = new ShoppingCart("CART1001","Atharv");
        cart.addProduct(Product.findProductById(catalog,"P001"),2);
        cart.addProduct(Product.findProductById(catalog,"P004"),5);
        cart.addProduct(Product.findProductById(catalog,"P007"),1);
        cart.displayCart();

        cart.removeProduct("P004");
        cart.displayCart();

        cart.addProduct(Product.findProductById(catalog,"P008"),1);
        cart.displayCart();

        cart.checkout();

        System.out.println();
        System.out.println("Products in Accessories category:");
        List<Product> acc = Product.getProductsByCategory(catalog,"Accessories");
        for (Product p: acc) System.out.printf("%s - %s - Stock: %d%n", p.productId, p.productName, p.stockQuantity);

        System.out.println("Total products in catalog: " + Product.totalProducts);
        System.out.println("Categories: " + Product.categories);
    }
}