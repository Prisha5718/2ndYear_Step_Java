interface Notifier {
    void send(String message);
}

public class Service {
    public void triggerAlert() {
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Alert: " + message);
            }
        };

        notifier.send("Server CPU usage is high!");
    }

    public static void main(String[] args) {
        new Service().triggerAlert();
    }
}