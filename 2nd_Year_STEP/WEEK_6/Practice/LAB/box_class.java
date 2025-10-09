class Box {
    void pack() {
        System.out.println("Box is being packed");
    }

    void unpack() {
        System.out.println("Box is being unpacked");
    }
}

class GiftBox extends Box {
    @Override
    void pack() {
        super.pack();
        System.out.println("Adding ribbons and decorations");
    }

    @Override
    void unpack() {
        super.unpack();
        System.out.println("Opening gift wrap and revealing surprise");
    }
}

public class Main {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
