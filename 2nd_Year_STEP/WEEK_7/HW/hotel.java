class HotelBooking {

    public void calculatePrice(String roomType, int nights) {
        int rate = roomType.equalsIgnoreCase("Deluxe") ? 200 : 100;
        int total = rate * nights;
        System.out.println("Standard Booking: " + nights + " nights in " + roomType + " room = $" + total);
    }

    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        int rate = roomType.equalsIgnoreCase("Deluxe") ? 200 : 100;
        double total = rate * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking: " + nights + " nights in " + roomType + " room x seasonal multiplier " + seasonalMultiplier + " = $" + total);
    }

    public void calculatePrice(String roomType, int nights, double corporateDiscount, double mealPackage) {
        int rate = roomType.equalsIgnoreCase("Deluxe") ? 200 : 100;
        double total = rate * nights;
        double discount = total * corporateDiscount;
        total = total - discount + mealPackage;
        System.out.println("Corporate Booking: " + nights + " nights in " + roomType + " room, discount $" + discount + ", meal $" + mealPackage + " = $" + total);
    }

    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, double cateringFee) {
        int rate = roomType.equalsIgnoreCase("Deluxe") ? 200 : 100;
        double total = rate * nights + decorationFee + cateringFee * guestCount;
        System.out.println("Wedding Package: " + nights + " nights in " + roomType + " room, " + guestCount + " guests, decoration $" + decorationFee + ", catering $" + cateringFee + " per guest = $" + total);
    }

    public static void main(String[] args) {
        HotelBooking hb = new HotelBooking();
        hb.calculatePrice("Deluxe", 3);
        hb.calculatePrice("Standard", 2, 1.5);
        hb.calculatePrice("Deluxe", 5, 0.1, 150);
        hb.calculatePrice("Standard", 4, 50, 200, 20);
    }
}
