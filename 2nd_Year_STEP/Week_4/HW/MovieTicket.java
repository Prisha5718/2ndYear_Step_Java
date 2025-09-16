public class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    public MovieTicket() {
        movieName = "Unknown";
        theatreName = "Unknown";
        seatNumber = 0;
        price = 0.0;
    }

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 200.0;
    }

    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.theatreName = "PVR";
        this.seatNumber = seatNumber;
        this.price = 200.0;
    }

    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Movie: " + movieName + ", Theatre: " + theatreName + ", Seat: " + seatNumber + ", Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Avengers", 12);
        MovieTicket t4 = new MovieTicket("Interstellar", "INOX", 25, 350.0);

        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}



