
import codeSource.Case;
import codeSource.Fichier;
import codeSource.Jeu;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] tabJoueurs;
            int     reponse = 0;
            boolean valide = false;
            Scanner s      = new Scanner(System.in);
            do {
                System.out.println("Entrer le nombre de joueurs qui vont jouer");
                try {
                    System.out.println("Le nombre de joueur doit etre entre 1 et 5");
                    reponse = s.nextInt();
                    valide = true;
                } catch (InputMismatchException ime) {
                    System.out.println("Attention il faut entrer un nombre valide ");
                    s.nextLine();
                }
            } while ((reponse <= 0 || reponse > 5) || !valide);
            tabJoueurs = new String[reponse];
        String  nom = " ";
        System.out.println("Entrer le nom du joueur");
        for (int i = 0; i < tabJoueurs.length; i++) {
            do {
                System.out.println("Le nom du joueur " + (i + 1) + " doit contenir deux caracteres(Pas d'espaces)");
                nom = s.nextLine();
                nom = nom.trim();
            } while (nom.length() != 2);
            tabJoueurs[i] = nom;

        }
             Fichier fichier = new Fichier();
            fichier.ouvrirFichierLecture("info-cases.txt");
            fichier.lireFichier();




    }

}