package codeSource;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {

    private final ArrayList <String>  alCondition = new ArrayList<>();

    private final ArrayList <Integer> alNumeroCaseCondition = new ArrayList<>();

    private final ArrayList <Integer> alNumeroCaseDestination = new ArrayList<>();
    private final ArrayList <Integer> alDestination = new ArrayList<>();
     private String nomFic;
     private int nbreLigne ;
     public Fichier (String nomFic){
        this.nomFic=nomFic;
     }



    public  FileInputStream ouvrirFichierLecture(String nomFic){
        this.nomFic = nomFic;
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream(nomFic);
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur d'ouverture de fichier");
        }
        return fichier;
    }

    public int getNbreLigne() {
        return nbreLigne;
    }

    /**
     * Cette methode lit le fichier en entier tout remplissant les listes avec les informations correspondantes
     */
    public void lireFichier() {
        FileInputStream fichier = ouvrirFichierLecture("info-cases.txt");
        Scanner lecteurFichier = new Scanner(fichier);
         nbreLigne = 0;
        String ligne;
        while (lecteurFichier.hasNext()) {
            ligne = lecteurFichier.nextLine();
            nbreLigne++;
            String[] temp = ligne.split(";");
             try {
                 alDestination.add(Integer.parseInt(temp[1]));
                 alNumeroCaseDestination.add(Integer.parseInt(temp[0]));
             }catch (NumberFormatException nfe){
                 alCondition.add(temp[1]);
                 alNumeroCaseCondition.add(Integer.parseInt(temp[0]));
             }
        }
        System.out.println("Le fichier contient " + nbreLigne + " lignes");
        fermerFichier(fichier);

    }

    /**
     * Cette methode retourne les donnees de la liste des cases contenant les conditions
     * @return
     */
    public ArrayList<Integer> getAlNumeroCaseCondition() {
        return alNumeroCaseCondition;
    }

    /**
     * Cette methode retourne les donnees de la liste des cases contenant les serpents et echelles
     * @return
     */
    public ArrayList<Integer> getAlNumeroCaseDestination() {
        return alNumeroCaseDestination;
    }

    public  void fermerFichier (Closeable fichier ) {
        try {
            fichier.close();
        } catch (IOException ex) {
            System.out.println("Erreur de fermeture de fichier");
        }
    }


    /**
     * Cette methode retourne les donnees de la liste des conditions
     * @return
     */
    public ArrayList<String>getCondition (){
         return alCondition;
    }
    /**
     * Cette methode retourne les donnees de la liste des serpents et echelles, donc des destinations
     * @return
     */
    public ArrayList<Integer> getAlDestination() {
        return alDestination;
    }

    @Override
    public
    String toString() {
        return "Numero de case: "+" condition de jeu:"+alCondition;
    }
}
