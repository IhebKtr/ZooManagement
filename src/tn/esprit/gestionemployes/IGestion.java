package tn.esprit.gestionemployes;

public interface IGestion<T> {
    public void ajouterEmploye(T t);
    public boolean rechercherEmploye(String nom);
    public boolean rechercherEmploye(T t);
    public void supprimerEmploye(T t);
    public void afficherEmploye();
    public void trierEmployeParId(); //Comparable
    public void trierEmployeParNomDépartementEtGrade(); //Comparator
}