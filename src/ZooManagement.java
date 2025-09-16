import java.util.Scanner;

public class ZooManagement {
    int nbrCages;
    String zooName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManagement zoo = new ZooManagement();
        do {
            System.out.print("Entrez le nom du zoo : ");
            zoo.zooName = scanner.nextLine().trim();
            if (zoo.zooName.isEmpty()) {
                System.out.println(" Le nom du zoo ne peut pas etre vide");
            }
        } while (zoo.zooName.isEmpty());
        do {
            System.out.print("entrez le nombre de cages : ");
            while (!scanner.hasNextInt()) {
                System.out.println("  entrer un entier ");
                scanner.next();
            }
            zoo.nbrCages = scanner.nextInt();

            if (zoo.nbrCages <= 0) {
                System.out.println("nombre de cages doit être positif");
            }
        } while (zoo.nbrCages <= 0);

        scanner.close();


        System.out.println("Le zoo " + zoo.zooName + " contient " + zoo.nbrCages + " cages.");
    }
}
