abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    MagicalStructure() {
        this("Unknown Structure", 50, "Unknown", true);
    }

    MagicalStructure(String name, int power) {
        this(name, power, "Central Kingdom", true);
    }

    MagicalStructure(String name, int power, String location, boolean active) {
        this.structureName = name;
        this.magicPower = power;
        this.location = location;
        this.isActive = active;
    }

    abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    WizardTower() {
        this("Wizard Tower", 100, "North", true, 3, new String[]{"Fireball"});
    }

    WizardTower(String name, int power, String loc, boolean active, int capacity, String[] spells) {
        super(name, power, loc, active);
        this.spellCapacity = capacity;
        this.knownSpells = spells;
    }

    void castMagicSpell() {
        System.out.println(structureName + " casts " + knownSpells[0]);
    }
}

class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    EnchantedCastle(String name, int defense, boolean drawbridge) {
        super(name, defense * 2, "South", true);
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }

    void castMagicSpell() {
        System.out.println(structureName + " raises magical shield!");
    }
}

class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    MysticLibrary(String name, int books, String language) {
        super(name, 80, "East", true);
        this.bookCount = books;
        this.ancientLanguage = language;
    }

    void castMagicSpell() {
        System.out.println(structureName + " invokes " + ancientLanguage + " knowledge.");
    }
}

class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    DragonLair(String type, int treasure) {
        super("Dragon Lair", 200, "Mountains", true);
        this.dragonType = type;
        this.treasureValue = treasure;
    }

    void castMagicSpell() {
        System.out.println(dragonType + " breathes fire from " + structureName);
    }
}

class KingdomManager {
    static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return (s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
               (s1 instanceof EnchantedCastle && s2 instanceof DragonLair);
    }

    static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) return attacker.structureName + " wins!";
        else return defender.structureName + " defends successfully!";
    }

    static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) total += s.magicPower;
        return total;
    }
}

public class KingdomSimulator {
    public static void main(String[] args) {
        WizardTower tower = new WizardTower();
        EnchantedCastle castle = new EnchantedCastle("Royal Castle", 150, true);
        MysticLibrary library = new MysticLibrary("Arcane Library", 5000, "Elder Tongue");
        DragonLair lair = new DragonLair("Red Dragon", 10000);

        MagicalStructure[] structures = {tower, castle, library, lair};

        System.out.println("Total Kingdom Power: " + KingdomManager.calculateKingdomMagicPower(structures));
        System.out.println(KingdomManager.performMagicBattle(tower, castle));
        System.out.println("Can Castle + Lair interact? " + KingdomManager.canStructuresInteract(castle, lair));
        tower.castMagicSpell();
        castle.castMagicSpell();
        library.castMagicSpell();
        lair.castMagicSpell();
    }
}
