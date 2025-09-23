import java.util.Scanner;

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
         myZoo.animals = new Animal[25]*/

        // myZoo.displayZoo();
        // System.out.println(myZoo);
        // System.out.println(myZoo.toString());

        //  lion.displayAnimal();
        // System.out.println(lion.toString());
        Animal tiger = new Animal("cats","tiger",11,true);
        System.out.println(myZoo.addAnimal(tiger));
        System.out.println(myZoo.addAnimal(lion));
        Animal tigerNoir = new Animal("cats","tiger",11,true);
        myZoo.displayAnimals();
        System.out.println(myZoo.searchAnimal(tiger));
        Animal dog2 = new Animal("Canine", "Snoopy", 2, true);
        System.out.println(myZoo.searchAnimal(lion));
        System.out.println(myZoo.removeAnimal(lion));

        System.out.println(myZoo.isZooFull());

        Zoo myZoo2 = new Zoo("usazoo","los angles");
        Zoo myZoo3 = new Zoo("tunzoo","ariana");

        System.out.println(Zoo.comparerZoo(myZoo2,myZoo3));

    }
}