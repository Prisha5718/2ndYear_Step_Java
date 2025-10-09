class Weather {
    String condition;

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather constructor");
    }

    void display() {
        System.out.println("Weather condition: " + condition);
    }
}

class Storm extends Weather {
    int windSpeed;

    Storm(String condition, int windSpeed) {
        super(condition);
        this.windSpeed = windSpeed;
        System.out.println("Storm constructor");
    }

    @Override
    void display() {
        System.out.println("Storm condition: " + condition + ", Wind speed: " + windSpeed + " km/h");
    }
}

class Thunderstorm extends Storm {
    int lightningCount;

    Thunderstorm(String condition, int windSpeed, int lightningCount) {
        super(condition, windSpeed);
        this.lightningCount = lightningCount;
        System.out.println("Thunderstorm constructor");
    }

    @Override
    void display() {
        System.out.println("Thunderstorm: " + condition + ", Wind: " + windSpeed + " km/h, Lightning strikes: " + lightningCount);
    }
}

class Sunshine extends Weather {
    int uvIndex;

    Sunshine(String condition, int uvIndex) {
        super(condition);
        this.uvIndex = uvIndex;
        System.out.println("Sunshine constructor");
    }

    @Override
    void display() {
        System.out.println("Sunshine: " + condition + ", UV Index: " + uvIndex);
    }
}

public class Main {
    public static void main(String[] args) {
        Weather[] weathers = {
            new Weather("Cloudy"),
            new Storm("Windy", 50),
            new Thunderstorm("Heavy Rain", 80, 10),
            new Sunshine("Sunny", 7)
        };

        for (Weather w : weathers) {
            w.display();
        }
    }
}
