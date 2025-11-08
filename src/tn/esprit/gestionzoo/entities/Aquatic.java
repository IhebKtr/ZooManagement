package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.entities.Food;
import tn.esprit.gestionzoo.entities.Carnivore;

public abstract class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Aquatic{" +
                "habitat='" + habitat + '\'' +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}';
    }

    public abstract void swim(); // Instruction 28: Make swim() abstract
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aquatic aquatic = (Aquatic) obj;
        return name.equals(aquatic.name) &&
               age == aquatic.age &&
               habitat.equals(aquatic.habitat);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + habitat.hashCode();
        return result;
    }
    @Override
    public void eatMeat(Food meat) {
        System.out.println("Aquatic animal " + name + " is eating " + meat);
    }
}