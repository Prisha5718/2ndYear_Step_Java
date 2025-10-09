class Game {
    String name;
    int players;

    Game(String name, int players) {
        this.name = name;
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game[name=" + name + ", players=" + players + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Game g = (Game) obj;
        return players == g.players && name.equals(g.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + players;
    }
}

class CardGame extends Game {
    int deckSize;

    CardGame(String name, int players, int deckSize) {
        super(name, players);
        this.deckSize = deckSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", CardGame[deckSize=" + deckSize + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        CardGame c = (CardGame) obj;
        return deckSize == c.deckSize;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + deckSize;
    }
}

public class Main {
    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4, 52);
        CardGame c2 = new CardGame("Poker", 4, 52);
        System.out.println(c1);
        System.out.println("c1 equals c2? " + c1.equals(c2));
    }
}
