package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.entities.Food;
import tn.esprit.gestionzoo.entities.Omnivore;

public class Terrestrial extends Animal implements Omnivore<Food> {
    protected int nbrLegs;

    public Terrestrial() {
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return "Terrestrial{" +
                "nbrLegs=" + nbrLegs +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}';
    }
    @Override
    public void eatMeat(Food meat) {
        System.out.println("Terrestrial animal " + name + " is eating " + meat);
    }

    @Override
    public void eatPlant(Food plant) {
        System.out.println("Terrestrial animal " + name + " is eating " + plant);
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        System.out.println("Terrestrial animal " + name + " is eating " + food + " (both plant and meat)");
    }
}