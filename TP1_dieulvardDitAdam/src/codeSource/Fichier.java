package codeSource;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Fichier {
    private static int numeroCase;
    private static String condition;
     private String nomFic;
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

    public void lireFichier() {
        FileInputStream fichier = ouvrirFichierLecture("info-cases.txt");
        Scanner lecteurFichier = new Scanner(fichier);
        int nbreLigne = 0;
        String ligne;
        while (lecteurFichier.hasNext()) {
            ligne = lecteurFichier.nextLine();
            nbreLigne++;
            String[] temp = ligne.split(";");
            int numeroCase = Integer.parseInt(temp[0]);
            String condition = temp[1];
            System.out.println( numeroCase+ " " + condition);

        }
        System.out.println("Le fichier contient " + nbreLigne + " lignes");
        fermerFichier(fichier);

    }

    public  void fermerFichier ( Closeable fichier ) {
        try {
            fichier.close();
        } catch (IOException ex) {
            System.out.println("Erreur de fermeture de fichier");
        }
    }


}
