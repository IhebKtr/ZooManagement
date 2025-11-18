package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.InvalidAgeException;
import tn.esprit.gestionzoo.entities.ZooFullException;
import tn.esprit.gestionzoo.entities.Food;

public class ZooManagement {
    public static void main(String[] args) {
        //int nbrCages = 20;
        // String zooName = "my zoo";
        // System.out.println(zooName+" comporte "+nbrCages+" cages");
/*
        Scanner sc = new Scanner(System.in);
        System.out.println("enter le nombre de cages ");
        int nbrCages = sc.nextInt();
        System.out.println("enter le nom du zoo");
        String zooName = sc.next();
        System.out.println(zooName+" comporte "+nbrCages+" cages");
*/

        Animal lion = new Animal("cats","simba",10,true);
      /*  lion.family="cats";
        lion.name="lion";
        lion.age=10;
        lion.isMammal=true;
    */

        Zoo myZoo = new Zoo("tounes","ben arous");

        /*
        myZoo.name="tounes";
        myZoo.city="ben arous";
        myZoo.nbrCages=25;
         myZoo.animals = new tn.esprit.gestionzoo.entities.Animal[25]*/

        // myZoo.displayZoo();
        // System.out.println(myZoo);
        // System.out.println(myZoo.toString());

        //  lion.displayAnimal();
        // System.out.println(lion.toString());
        Animal tiger = new Animal("cats","tiger",11,true);
        try {
            myZoo.addAnimal(tiger);
            System.out.println("Animal count: " + myZoo.getAnimalCount());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        try {
            myZoo.addAnimal(lion);
            System.out.println("Animal count: " + myZoo.getAnimalCount());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        Animal tigerNoir = new Animal("cats","tiger",11,true);
        try {
            myZoo.addAnimal(tigerNoir);
            System.out.println("Animal count: " + myZoo.getAnimalCount());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        try {
            myZoo.addAnimal(new Animal("Canine", "Snoopy", 2, true));
            System.out.println("Animal count: " + myZoo.getAnimalCount());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        // Test with negative age
        Animal invalidAgeAnimal = new Animal("Invalid", "Invalid", -5, true);
        try {
            myZoo.addAnimal(invalidAgeAnimal);
            System.out.println("Animal count: " + myZoo.getAnimalCount());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        myZoo.displayAnimals();
        System.out.println(myZoo.searchAnimal(tiger));
        Animal dog2 = new Animal("Canine", "Snoopy", 2, true);
        System.out.println(myZoo.searchAnimal(lion));
        System.out.println(myZoo.removeAnimal(lion));

        System.out.println(myZoo.isZooFull());

        Zoo myZoo2 = new Zoo("usazoo","los angles");
        Zoo myZoo3 = new Zoo("tunzoo","ariana");

        System.out.println(Zoo.comparerZoo(myZoo2,myZoo3));

        Aquatic aquaticAnimal = new Dolphin("Fish", "Nemo", 1, false, "Ocean", 5.0f); // Changed to Dolphin as Aquatic is abstract
        Terrestrial terrestrialAnimal = new Terrestrial("Mammal", "Elephant", 15, true, 4);
        Dolphin dolphin = new Dolphin("Fish", "Flipper", 5, true, "Ocean", 25.5f);
        Penguin penguin = new Penguin("Bird", "Skipper", 3, false, "Antarctica", 10.2f);

        System.out.println(aquaticAnimal);
        System.out.println(terrestrialAnimal);
        System.out.println(dolphin);
        System.out.println(penguin);

        // Instruction 26: Add aquatic animals to the zoo
        myZoo.addAquaticAnimal(aquaticAnimal);
        myZoo.addAquaticAnimal(dolphin);
        myZoo.addAquaticAnimal(penguin);

        // Instruction 27: Display swim() method for all aquatic animals
        System.out.println("\n--- Aquatic Animals Swimming ---");
        for (int i = 0; i < myZoo.getAquaticAnimalCount(); i++) {
            myZoo.getAquaticAnimals()[i].swim();
        }
        System.out.println("--- End Aquatic Animals Swimming ---\n");
        // Instruction 29: Display max penguin swimming depth
        System.out.println("Max Penguin Swimming Depth: " + myZoo.maxPenguinSwimmingDepth() + " meters");

        // Instruction 30: Display number of aquatics by type
        myZoo.displayNumberOfAquaticsByType();

        // Instruction 31: Test equals method
        Aquatic aquaticAnimal2 = new Dolphin("Fish", "Nemo", 1, false, "Ocean", 5.0f);
        System.out.println("aquaticAnimal.equals(aquaticAnimal2): " + aquaticAnimal.equals(aquaticAnimal2));

        Aquatic aquaticAnimal3 = new Dolphin("Fish", "Dory", 1, false, "Ocean", 5.0f);
        System.out.println("aquaticAnimal.equals(aquaticAnimal3): " + aquaticAnimal.equals(aquaticAnimal3));
        // Instruction 38: Test implemented methods
        Aquatic testAquatic = new Dolphin("Fish", "TestDolphin", 2, true, "Ocean", 10.0f);
        Terrestrial testTerrestrial = new Terrestrial("Mammal", "TestElephant", 10, true, 4);
        Penguin testPenguin = new Penguin("Bird", "TestPenguin", 4, false, "Antarctica", 8.5f);

        System.out.println("\n--- Testing Carnivore and Omnivore methods ---");
        testAquatic.eatMeat(Food.MEAT);
        testTerrestrial.eatPlant(Food.PLANT);
        testTerrestrial.eatMeat(Food.MEAT);
        testTerrestrial.eatPlantAndMeet(Food.BOTH);
        // Penguin also implements Carnivore through Aquatic
        testPenguin.eatMeat(Food.MEAT);
        System.out.println("--- End Testing Carnivore and Omnivore methods ---");
    }