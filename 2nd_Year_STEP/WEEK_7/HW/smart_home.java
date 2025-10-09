class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void basicStatus() {
        System.out.println(deviceName + " is connected and operational.");
    }
}

class SmartTV extends SmartDevice {
    private int volume;
    private String channel;
    private String streamingApp;

    public SmartTV(String deviceName, int volume, String channel, String streamingApp) {
        super(deviceName);
        this.volume = volume;
        this.channel = channel;
        this.streamingApp = streamingApp;
    }

    public void controlTV() {
        System.out.println("SmartTV " + deviceName + " on channel " + channel + ", volume " + volume + ", streaming " + streamingApp);
    }
}

class SmartThermostat extends SmartDevice {
    private int temperature;
    private int humidity;
    private boolean energySaving;

    public SmartThermostat(String deviceName, int temperature, int humidity, boolean energySaving) {
        super(deviceName);
        this.temperature = temperature;
        this.humidity = humidity;
        this.energySaving = energySaving;
    }

    public void controlThermostat() {
        System.out.println("Thermostat " + deviceName + " set to " + temperature + "°C, humidity " + humidity + "%, energy saving: " + energySaving);
    }
}

class SmartSecurity extends SmartDevice {
    private int cameras;
    private boolean alarm;
    private String accessControl;

    public SmartSecurity(String deviceName, int cameras, boolean alarm, String accessControl) {
        super(deviceName);
        this.cameras = cameras;
        this.alarm = alarm;
        this.accessControl = accessControl;
    }

    public void controlSecurity() {
        System.out.println("Security " + deviceName + " has " + cameras + " cameras, alarm: " + alarm + ", access: " + accessControl);
    }
}

class SmartKitchen extends SmartDevice {
    private int cookingTime;
    private int temperature;
    private String recipe;

    public SmartKitchen(String deviceName, int cookingTime, int temperature, String recipe) {
        super(deviceName);
        this.cookingTime = cookingTime;
        this.temperature = temperature;
        this.recipe = recipe;
    }

    public void controlKitchen() {
        System.out.println("Kitchen " + deviceName + " cooking " + recipe + " for " + cookingTime + " mins at " + temperature + "°C");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("Living Room TV", 20, "HBO", "Netflix"),
            new SmartThermostat("Main Thermostat", 22, 50, true),
            new SmartSecurity("Home Security", 4, true, "Keypad"),
            new SmartKitchen("Oven", 45, 180, "Lasagna")
        };

        for (SmartDevice d : devices) {
            d.basicStatus();

            if (d instanceof SmartTV tv) {
                tv.controlTV();
            } else if (d instanceof SmartThermostat th) {
                th.controlThermostat();
            } else if (d instanceof SmartSecurity sc) {
                sc.controlSecurity();
            } else if (d instanceof SmartKitchen kc) {
                kc.controlKitchen();
            }

            System.out.println();
        }
    }
}
