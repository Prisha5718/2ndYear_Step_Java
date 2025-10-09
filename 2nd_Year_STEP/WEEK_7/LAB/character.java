class Character {
    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " performs a basic attack.");
    }
}

class Warrior extends Character {
    private String weapon;
    private int defense;

    public Warrior(String name, String weapon, int defense) {
        super(name);
        this.weapon = weapon;
        this.defense = defense;
    }

    @Override
    public void attack() {
        System.out.println("Warrior " + name + " attacks with " + weapon + " with defense " + defense);
    }
}

class Mage extends Character {
    private String spell;
    private int mana;

    public Mage(String name, String spell, int mana) {
        super(name);
        this.spell = spell;
        this.mana = mana;
    }

    @Override
    public void attack() {
        System.out.println("Mage " + name + " casts " + spell + " using " + mana + " mana");
    }
}

class Archer extends Character {
    private int range;
    private int arrows;

    public Archer(String name, int range, int arrows) {
        super(name);
        this.range = range;
        this.arrows = arrows;
    }

    @Override
    public void attack() {
        System.out.println("Archer " + name + " shoots arrows at range " + range + " with " + arrows + " arrows left");
    }
}

public class BattleDemo {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Thor", "Hammer", 100),
            new Mage("Gandalf", "Fireball", 200),
            new Archer("Legolas", 50, 30)
        };

        for (Character c : army) {
            c.attack();
        }
    }
}
