import java.util.*;

class VirtualPet {
    final String petId;
    String petName, species;
    int age, happiness, health;
    String evolutionStage;
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    VirtualPet(String name) {
        this(name, getRandomSpecies(), 0, 60, 60, EVOLUTION_STAGES[1]);
    }

    VirtualPet(String name, String species) {
        this(name, species, 1, 70, 70, EVOLUTION_STAGES[2]);
    }

    VirtualPet(String name, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = stage;
        totalPetsCreated++;
    }

    static String generatePetId() {
        return "PET-" + System.nanoTime();
    }

    static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Slime", "Unicorn"};
        return speciesList[(int)(Math.random() * speciesList.length)];
    }

    void feedPet() { happiness += 5; health += 10; }
    void playWithPet() { happiness += 10; health -= 2; }
    void healPet() { health += 20; }

    void evolvePet() {
        if (health <= 0) {
            evolutionStage = "Ghost";
            return;
        }
        int stageIndex = Math.min(age / 2, EVOLUTION_STAGES.length - 1);
        evolutionStage = EVOLUTION_STAGES[stageIndex];
    }

    void simulateDay() {
        age++;
        happiness -= (int)(Math.random() * 5);
        health -= (int)(Math.random() * 5);
        evolvePet();
    }

    String getPetStatus() {
        return "[" + petId + "] " + petName + " (" + species + ") - Age: " + age +
               ", Health: " + health + ", Happiness: " + happiness +
               ", Stage: " + evolutionStage;
    }
}

public class PetDaycare {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Fluffy");
        VirtualPet pet3 = new VirtualPet("Sparky", "Dragon");

        VirtualPet[] pets = {pet1, pet2, pet3};

        for (int day = 1; day <= 5; day++) {
            System.out.println("\nDay " + day + " Simulation:");
            for (VirtualPet p : pets) {
                p.simulateDay();
                System.out.println(p.getPetStatus());
            }
        }
    }
}