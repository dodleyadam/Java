package codeSource;

import java.util.Random;

public class Jeu {
    private final int COLONNE =10;
    private final int LIGNE = 10;
    private Jeu [][] tabJeu;
    private int de;
  private static Case c;

    public Jeu(int destination, String nomJoueurs,String condition,int numeroDeCase) {
        tabJeu = new Jeu[LIGNE][COLONNE];
    }
    public void deplacerJoueur(){
       Random random = new Random();
       de = random.nextInt(0,6);
       for (int ligne=0; ligne< tabJeu.length; ligne++){
           for (int colonne=0; colonne<tabJeu[ligne].length;colonne++){
               tabJeu [ligne][colonne]= new Jeu(c.getDestination(),c.getNomJoueurs(),c.getConditionDeJeu(),
                       c.getNumeroDeCase());
           }
       }
    }
}
