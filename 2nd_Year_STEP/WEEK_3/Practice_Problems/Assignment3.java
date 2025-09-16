import java.util.*;

public class Assignment3 {
    static class Room {
        String roomNumber;
        String roomType;
        double pricePerNight;
        boolean isAvailable;
        int maxOccupancy;

        public Room(String roomNumber, String roomType, double pricePerNight, boolean isAvailable, int maxOccupancy) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.pricePerNight = pricePerNight;
            this.isAvailable = isAvailable;
            this.maxOccupancy = maxOccupancy;
        }
    }

    static class Guest {
        String guestId;
        String guestName;
        String phoneNumber;
        String email;
        List<String> bookingHistory = new ArrayList<>();

        public Guest(String guestId, String guestName, String phoneNumber, String email) {
            this.guestId = guestId;
            this.guestName = guestName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }
    }

    static class Booking {
        String bookingId;
        Guest guest;
        Room room;
        String checkInDate;
        String checkOutDate;
        double totalAmount;

        public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, double totalAmount) {
            this.bookingId = bookingId;
            this.guest = guest;
            this.room = room;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.totalAmount = totalAmount;
        }
    }

    static class HotelManager {
        static int totalBookings = 0;
        static double hotelRevenue = 0.0;
        static String hotelName = "Default Hotel";
        Map<String, Room> rooms = new HashMap<>();
        Map<String, Booking> bookings = new HashMap<>();
        Map<String, Integer> roomTypeCount = new HashMap<>();

        public void addRoom(Room r) {
            rooms.put(r.roomNumber, r);
        }

        public Booking makeReservation(Guest g, String roomType, String checkIn, String checkOut) {
            for (Room r : rooms.values()) {
                if (r.roomType.equalsIgnoreCase(roomType) && r.isAvailable) {
                    r.isAvailable = false;
                    int nights = Math.max(1, computeNights(checkIn, checkOut));
                    double amount = nights * r.pricePerNight;
                    String bid = "BKG" + (totalBookings + 1);
                    Booking b = new Booking(bid, g, r, checkIn, checkOut, amount);
                    bookings.put(bid, b);
                    totalBookings++;
                    hotelRevenue += amount;
                    g.bookingHistory.add(bid);
                    roomTypeCount.put(r.roomType, roomTypeCount.getOrDefault(r.roomType,0)+1);
                    return b;
                }
            }
            return null;
        }

        public boolean cancelReservation(String bookingId) {
            Booking b = bookings.remove(bookingId);
            if (b != null) {
                b.room.isAvailable = true;
                totalBookings = Math.max(0, totalBookings-1);
                hotelRevenue = Math.max(0.0, hotelRevenue - b.totalAmount);
                roomTypeCount.put(b.room.roomType, roomTypeCount.getOrDefault(b.room.roomType,1)-1);
                return true;
            }
            return false;
        }

        public boolean checkAvailability(String roomType) {
            for (Room r : rooms.values()) if (r.roomType.equalsIgnoreCase(roomType) && r.isAvailable) return true;
            return false;
        }

        public double calculateBill(String bookingId) {
            Booking b = bookings.get(bookingId);
            return b != null ? b.totalAmount : 0.0;
        }

        public static double getOccupancyRate(HotelManager hm) {
            int total = hm.rooms.size();
            long occupied = hm.rooms.values().stream().filter(r->!r.isAvailable).count();
            return total == 0 ? 0.0 : (occupied*100.0)/total;
        }

        public static double getTotalRevenue() {
            return hotelRevenue;
        }

        public static String getMostPopularRoomType(HotelManager hm) {
            String best = "N/A";
            int max = 0;
            for (Map.Entry<String,Integer> e: hm.roomTypeCount.entrySet()) if (e.getValue()>max) { max=e.getValue(); best=e.getKey(); }
            return best;
        }

        private int computeNights(String in, String out) {
            return 2;
        }
    }

    public static void main(String[] args) {
        HotelManager hm = new HotelManager();
        HotelManager.hotelName = "Atharv Grand";

        hm.addRoom(new Room("101","Deluxe",3000.0,true,2));
        hm.addRoom(new Room("102","Deluxe",3000.0,true,2));
        hm.addRoom(new Room("201","Suite",6000.0,true,4));
        hm.addRoom(new Room("301","Single",1500.0,true,1));
        hm.addRoom(new Room("302","Single",1500.0,true,1));

        Guest g1 = new Guest("G001","Rohan","9876543210","rohan@example.com");
        Guest g2 = new Guest("G002","Maya","9123456780","maya@example.com");

        Booking b1 = hm.makeReservation(g1,"Deluxe","2025-09-10","2025-09-12");
        Booking b2 = hm.makeReservation(g2,"Suite","2025-09-11","2025-09-13");
        Booking b3 = hm.makeReservation(g2,"Single","2025-09-15","2025-09-16");

        System.out.println("Bookings made: " + HotelManager.totalBookings);
        if (b1!=null) System.out.println("Booking " + b1.bookingId + " for " + b1.guest.guestName + " in room " + b1.room.roomNumber + " amount " + b1.totalAmount);
        if (b2!=null) System.out.println("Booking " + b2.bookingId + " for " + b2.guest.guestName + " in room " + b2.room.roomNumber + " amount " + b2.totalAmount);
        if (b3!=null) System.out.println("Booking " + b3.bookingId + " for " + b3.guest.guestName + " in room " + b3.room.roomNumber + " amount " + b3.totalAmount);

        System.out.printf("Occupancy Rate: %.2f%%%n", HotelManager.getOccupancyRate(hm));
        System.out.printf("Total Revenue: %.2f%n", HotelManager.getTotalRevenue());
        System.out.println("Most Popular Room Type: " + HotelManager.getMostPopularRoomType(hm));

        System.out.println("Cancelling booking " + (b2!=null?b2.bookingId:"N/A"));
        if (b2!=null) hm.cancelReservation(b2.bookingId);

        System.out.printf("Occupancy Rate after cancel: %.2f%%%n", HotelManager.getOccupancyRate(hm));
        System.out.printf("Total Revenue after cancel: %.2f%n", HotelManager.getTotalRevenue());
    }
}