class FoodDelivery {

    public void calculateDelivery(double distance) {
        double cost = distance * 5;
        System.out.println("Basic Delivery: Distance " + distance + " km, Cost: $" + cost);
    }

    public void calculateDelivery(double distance, double priorityFee) {
        double cost = distance * 5 + priorityFee;
        System.out.println("Premium Delivery: Distance " + distance + " km + Priority Fee $" + priorityFee + ", Total Cost: $" + cost);
    }

    public void calculateDelivery(double distance, int numOrders) {
        double baseCost = distance * 5;
        double discount = numOrders * 2;
        double total = baseCost - discount;
        System.out.println("Group Delivery: Distance " + distance + " km, Orders " + numOrders + ", Discount $" + discount + ", Total Cost: $" + total);
    }

    public void calculateDelivery(double distance, double discountPercent, double freeDeliveryThreshold) {
        double cost = distance * 5;
        double discount = cost * (discountPercent / 100);
        if (cost > freeDeliveryThreshold) {
            cost = 0;
            System.out.println("Festival Special: Distance " + distance + " km, Over threshold! Free delivery applied.");
        } else {
            cost -= discount;
            System.out.println("Festival Special: Distance " + distance + " km, Discount " + discountPercent + "% = $" + cost);
        }
    }

    public static void main(String[] args) {
        FoodDelivery fd = new FoodDelivery();
        fd.calculateDelivery(10);
        fd.calculateDelivery(8, 3);
        fd.calculateDelivery(12, 4);
        fd.calculateDelivery(15, 20, 50);
    }
}
