package tn.esprit.gestionemployes;

import java.util.Map;

public class EmployeManagement {
    public static void main(String[] args) {
        AffectationHashMap affectationHashMap = new AffectationHashMap();

        // Create some Employe and Departement objects
        Employe employe1 = new Employe(1, "Doe", "John", "IT", 1);
        Employe employe2 = new Employe(2, "Smith", "Jane", "HR", 2);
        Employe employe3 = new Employe(3, "Brown", "David", "IT", 1);

        Departement depIT = new Departement(101, "IT");
        Departement depHR = new Departement(102, "HR");
        Departement depFinance = new Departement(103, "Finance");

        System.out.println("--- Adding employees to departments ---");
        affectationHashMap.ajouterEmployeDepartement(employe1, depIT);
        affectationHashMap.ajouterEmployeDepartement(employe2, depHR);
        affectationHashMap.ajouterEmployeDepartement(employe3, depIT);

        System.out.println("\n--- Displaying all employees and their departments (initial) ---");
        affectationHashMap.afficherEmployesEtDepartements();

        //  Test adding the same employee to two different departments
        Employe employe1_finance = new Employe(1, "Doe", "John", "Finance", 3); // Same employee as employe1
        affectationHashMap.ajouterEmployeDepartement(employe1_finance, depFinance);
        System.out.println("\n--- Displaying all employees and their departments after adding employe1 to Finance ---");
        affectationHashMap.afficherEmployesEtDepartements();
        System.out.println("Remark: When adding employe1 (same id and name) to a different department (Finance), the previous entry for employe1 (in IT) is overwritten. This is because HashMap uses the equals() and hashCode() methods of the key (Employe) to determine uniqueness. Since employe1 and employe1_finance are considered equal based on id and nom, the second put operation updates the value associated with that key.");

        System.out.println("\n--- Displaying only employees ---");
        affectationHashMap.afficherEmployes();

        System.out.println("\n--- Displaying only departments ---");
        affectationHashMap.afficherDepartements();

        System.out.println("\n--- Searching for employe1: " + affectationHashMap.rechercherEmploye(employe1));
        System.out.println("--- Searching for a non-existent employee: " + affectationHashMap.rechercherEmploye(new Employe(99, "NonExistent", "Test", "None", 0)));

        System.out.println("\n--- Searching for depIT: " + affectationHashMap.rechercherDepartement(depIT));
        System.out.println("--- Searching for a non-existent department: " + affectationHashMap.rechercherDepartement(new Departement(999, "NonExistentDep")));

        System.out.println("\n--- Deleting employe2 ---");
        affectationHashMap.supprimerEmploye(employe2);
        System.out.println("After deleting employe2:");
        affectationHashMap.afficherEmployesEtDepartements();

        System.out.println("\n--- Deleting employe1 from depFinance (should remove) ---");
        affectationHashMap.supprimerEmployeEtDepartement(employe1, depFinance);
        System.out.println("After deleting employe1 from depFinance:");
        affectationHashMap.afficherEmployesEtDepartements();

        System.out.println("\n--- Deleting employe3 from a wrong department (should not remove) ---");
        affectationHashMap.supprimerEmployeEtDepartement(employe3, depHR);
        System.out.println("After attempting to delete employe3 from depHR:");
        affectationHashMap.afficherEmployesEtDepartements();

        System.out.println("\n--- Sorted Map by Employe ID ---");
        TreeMap<Employe, Departement> sortedMap = affectationHashMap.trierMap();
        for (Map.Entry<Employe, Departement> entry : sortedMap.entrySet()) {
            System.out.println("Employe: " + entry.getKey() + ", Departement: " + entry.getValue());
        }
    }
}