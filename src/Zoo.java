public class Zoo {
    Animal [] animals;
    String name;
    String city;
    final int nbrCages=25;
    int animalCount;
    int nbrAnimals;
    public Zoo(){}

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        animals = new Animal[nbrCages];
        animalCount = 0;
    }

    /* public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[nbrCages];
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

    public boolean addAnimal(Animal animal){
        if (animalCount<nbrCages){
            animals[animalCount]=animal;
            animalCount++;
            return true;
        }
        return false;
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

}