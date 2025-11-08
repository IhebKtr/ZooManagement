package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.entities.InvalidAgeException;

public class Zoo {
    private Animal [] animals;
    private Aquatic[] aquaticAnimals; // Instruction 25
    private String name;
    private String city;
    private final int nbrCages=3;
    private int animalCount;
    private int nbrAnimals;
    private int aquaticAnimalCount; // To keep track of aquatic animals
    public Zoo(){}

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        animals = new Animal[nbrCages];
        aquaticAnimals = new Aquatic[10]; // Instruction 25: Initialize aquaticAnimals array
        animalCount = 0;
        aquaticAnimalCount = 0;
    }

    /* public tn.esprit.gestionzoo.entities.Zoo(String name, String city, int nbrCages) {
        animals = new tn.esprit.gestionzoo.entities.Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        animalCount = 0;
    } */

    public void displayZoo(){
        System.out.println("le nom de zoo : "+name+" city :"+
                city+" nbr de cages :"+nbrCages);
    }

    @Override
    public String toString() {
        return "nom de zoo : "+name+ " city :"+city+" num de cages"+nbrCages;
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Animal age cannot be negative.");
        }
        if (animalCount >= nbrCages) {
            throw new ZooFullException("The zoo is full. Cannot add more animals.");
        }
        animals[animalCount] = animal;
        animalCount++;
    }

    public void displayAnimals(){
        System.out.println("list des animaux dans  "+name+":");
        for(int i=0;i<animalCount;i++){
            System.out.println(animals[i].name);
        }
    }

    public int searchAnimal(Animal animal){
        int index = -1 ;
        for (int i=0;i<animalCount;i++){
            if(animal.name == animals[i].name){
                return i;
            }
        }
        return index;
    }


    public boolean removeAnimal(Animal animal){
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = animals[animalCount - 1];
            animals[animalCount - 1] = null;
            animalCount--;
            return true;
        }
        return false;
    }
    public int getAnimalCount() {
        return animalCount;
    }

    public boolean isZooFull(){
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1,Zoo z2){
        if(z1.animalCount > z2.animalCount){
            return z1;
        } else if( z1.animalCount < z2.animalCount){
            return z2;
        } else {
            return null;
        }
    }

    // Instruction 26: Add aquatic animal method
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticAnimalCount < aquaticAnimals.length) {
            aquaticAnimals[aquaticAnimalCount] = aquatic;
            aquaticAnimalCount++;
            System.out.println("Aquatic animal " + aquatic.getName() + " added to the zoo.");
        } else {
            System.out.println("Cannot add aquatic animal, aquatic animals array is full.");
        }
    }

    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public int getAquaticAnimalCount() {
        return aquaticAnimalCount;
    }
    // Instruction 29: maxPenguinSwimmingDepth() method
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (int i = 0; i < aquaticAnimalCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > maxDepth) {
                    maxDepth = p.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }
    // Instruction 30: displayNumberOfAquaticsByType() method
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
        for (int i = 0; i < aquaticAnimalCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }
        System.out.println("Number of Dolphins: " + dolphinCount);
        System.out.println("Number of Penguins: " + penguinCount);
    }
}