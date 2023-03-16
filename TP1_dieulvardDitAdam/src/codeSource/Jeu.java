package codeSource;

import java.util.ArrayList;
import java.util.Arrays;

public class Jeu{
 private final int COLONNE = 10;
 private final int LIGNE = 10;
 private final Case[][] cases = new Case[LIGNE][COLONNE];
 private int position;
 private int indexLigne;
 private int indexColonne;
 private int de;


 public Jeu(){
 }

 /**
  * Cette methode prend en parametre le nom du joueur et le deplace dans la case approprié a son lancé.
  * J'utilise les variables indexLigne et indexColonne pour pouvoir savoir sa position exacte.
  *
  * @param nomJoueur
  */
 public void deplacerJoueur(String nomJoueur){
 //On vérifie tout d'abord la position du joueur avant d'entrer dans la boucle
  if(de+position<=100){
   position +=de;
  }else{
   position-=de;
  }
  //https://livebook.manning.com/concept/java/outer-loop
  // Le break outerloop va permettre à la boucle d'arreter le for exterieur
  outerloop:
  for(indexLigne = 0; indexLigne < cases.length; indexLigne++){
   for(indexColonne = 0; indexColonne < cases[indexLigne].length; indexColonne++){
    if(position == cases[indexLigne][indexColonne].getNumeroDeCase()){
     cases[indexLigne][indexColonne].setNomJoueurs(nomJoueur);
     break outerloop;
    }
    }
   }
   prendrePositionJoueur(cases[indexLigne][indexColonne].getNomJoueurs());
  }


 public void verifierCondition(){
  boolean aucuneCondition = false;
  while(!aucuneCondition){
   int tempLigne   = 0;
   int tempColonne = 0;
   //On vérifie d'abord que la case ne contient pas de condition de jeu
   // Notez que je n'ai pas pu mettre la condition inclure la condition -1 en tant que condition de jeu, cependant elle
   // marche
   //Cependant elle va etre dans la verification des destinations et fonctionnera tres bien.
   if(!cases[indexLigne][indexColonne].getConditionDeJeu().equals("")){
    if(cases[indexLigne][indexColonne].getConditionDeJeu().equalsIgnoreCase("x2")){
     //On remet le nom de joueur à "" à chaque condition qui reussit
     cases[indexLigne][indexColonne].setNomJoueurs("");
     prendrePositionJoueur(cases[indexLigne][indexColonne].getNomJoueurs());
     deplacerJoueur(cases[indexLigne][indexColonne].getNomJoueurs());

    }else if(cases[indexLigne][indexColonne].getConditionDeJeu().equalsIgnoreCase("2d")){
     cases[indexLigne][indexColonne].setNomJoueurs("");
     lancerDe();
     prendrePositionJoueur(cases[indexLigne][indexColonne].getNomJoueurs());
     deplacerJoueur(cases[indexLigne][indexColonne].getNomJoueurs());
    }
    // Si la premiere condition n'est pas remplie alors on passe à la deuxieme condition
   }else if(cases[indexLigne][indexColonne].getDestination() != 0){

    String tempJoueurs = "";
    int    destination = cases[indexLigne][indexColonne].getDestination();
    outerloop:
    for(tempLigne = 0; tempLigne < cases.length; tempLigne++){
     for(tempColonne = 0; tempColonne < cases[indexLigne].length; tempColonne++){
      if(cases[tempLigne][tempColonne].getNumeroDeCase() == destination){
       //Une fois la case de destination identifiee je crée une variable tempJoueurs pour stocker
       // le nom du joueur dans l'ancienne case.
       tempJoueurs = cases[indexLigne][indexColonne].getNomJoueurs();
       //Apres on retire le joueur de la case
       cases[indexLigne][indexColonne].setNomJoueurs("");
       // Apres cela, je donne à la variable indexLigne et indexColonne la nouvelle valeur des
       // nouveaux index de destination.
       indexLigne = tempLigne;
       indexColonne = tempColonne;
       cases[indexLigne][indexColonne].setNomJoueurs(tempJoueurs);
       break outerloop;
      }else if(destination == -1){
       for(tempLigne = 0; tempLigne < cases.length; tempLigne++){
        for(tempColonne = 0; tempColonne < cases[indexLigne].length; tempColonne++){
         if(cases[tempLigne][tempColonne].getNumeroDeCase() ==
                 cases[indexLigne][indexColonne].getNumeroDeCase() - 1){
          //Une fois la condition verifiee on refait les memes etapes que pour la
          //condition precedente
          tempJoueurs = cases[indexLigne][indexColonne].getNomJoueurs();
          indexLigne = tempLigne;
          indexColonne = tempColonne;
          cases[indexLigne][indexColonne].setNomJoueurs(tempJoueurs);
          break outerloop;
         }
        }

       }
      }
     }
    }
   }
   //On revérifie une dernière fois si les cases ne contiennent pas de conditions. Si oui, on recommence les
   // verifications sinon on arrête la boucle et on passe au joueur suivant.
   if(cases[indexLigne][indexColonne].getDestination() == 0 || cases[indexLigne][indexColonne]
           .getConditionDeJeu().equals("")){
    aucuneCondition = true;
    System.out.println("aucune condition");
   }

  }
  //On met à jour la position du joueur
  prendrePositionJoueur(cases[indexLigne][indexColonne].getNomJoueurs());
 }

 public int prendrePositionJoueur(String nomJoueur){
  for(int ligne = 0; ligne < cases.length; ligne++){
   for(int colonne = 0; colonne < cases[ligne].length; colonne++){
    if(cases[ligne][colonne].getNomJoueurs().equals(nomJoueur)){
     position = cases[ligne][colonne].getNumeroDeCase();
     break;
    }
   }
  }
  return position;
 }


 public int getPosition(){
  return position;
 }

 public void remplirCases(){
  Fichier fichier = new Fichier("infos-case.txt");
  fichier.lireFichier();
  ArrayList<String>  condition         = fichier.getCondition();
  ArrayList<Integer> numeroDestination = fichier.getAlNumeroCaseDestination();
  ArrayList<Integer> numeroCondition   = fichier.getAlNumeroCaseCondition();
  ArrayList<Integer> destination       = fichier.getAlDestination();
  //Cette variable va compter le nombre de cases instancée à la fin de chaque boucle
  int compteurDeCase = 0;
  //Cette variable va permettre de traverser la liste des conditions
  int compteurCondition = 0;
  //Cette variable va permettre de traverser la liste des destinations
  int compteurDestination = 0;
  for(int ligne = 0; ligne < cases.length; ligne++){
   for(int colonne = 0; colonne < cases[ligne].length; colonne++){
    compteurDeCase++;
    if(compteurCondition < numeroCondition.size() && compteurDeCase == numeroCondition.get(compteurCondition)){
     cases[ligne][colonne] = new Case("", 0, compteurDeCase, condition.get(compteurCondition));
     compteurCondition++;
    }else if(compteurDestination < numeroDestination.size() && compteurDeCase == numeroDestination.
            get(compteurDestination)){
     cases[ligne][colonne] = new Case("", destination.get(compteurDestination), compteurDeCase,
             "");
     compteurDestination++;
    }else{
     cases[ligne][colonne] = new Case("", 0, compteurDeCase, "");
    }
   }
  }
 }

 public int lancerDe(){
  de = (int) (Math.random() * (6 - 1 + 1)) + 1;
  return de;
 }


 public void afficherLesCases(){
  for(int ligne = 0; ligne < cases.length; ligne++){
   for(int colonne = 0; colonne < cases[ligne].length; colonne++){
    System.out.println(cases[ligne][colonne]);
   }
  }
 }

 @Override
 public
 String toString(){
  return "Joueur:"+cases[indexLigne][indexColonne].getNomJoueurs()+" Lancer:"+de+" arrivée:"+cases[indexLigne]
          [indexColonne].getNumeroDeCase();
 }
}