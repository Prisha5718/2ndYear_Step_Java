class Instrument {
    String name;
    String material;

    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    void play() {
        System.out.println("Playing an instrument");
    }
}

class Piano extends Instrument {
    int keys;

    Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    void play() {
        System.out.println("Playing the piano with " + keys + " keys");
    }
}

class Guitar extends Instrument {
    int strings;

    Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    void play() {
        System.out.println("Playing the guitar with " + strings + " strings");
    }
}

class Drum extends Instrument {
    int size;

    Drum(String name, String material, int size) {
        super(name, material);
        this.size = size;
    }

    @Override
    void play() {
        System.out.println("Playing the drum of size " + size);
    }
}

public class Main {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Piano", "Wood", 88),
            new Guitar("Guitar", "Metal", 6),
            new Drum("Drum", "Plastic", 24)
        };

        for (Instrument i : instruments) {
            i.play();
        }
    }
}
