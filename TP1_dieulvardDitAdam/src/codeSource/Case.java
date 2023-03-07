package codeSource;

public class Case {
    public static Fichier fichier;
    private String nomJoueurs;
    private int numeroDeCase;
    private String conditionDeJeu;

    private int destination;
    public Case(String nomJoueurs, int destination,int numeroDeCase,String conditionDeJeu) {
        this.nomJoueurs = nomJoueurs;
        this.numeroDeCase= numeroDeCase;
        this.conditionDeJeu = conditionDeJeu;
        this.destination = destination;
    }

    public int getNumeroDeCase() {

        return numeroDeCase;
    }

    public String getConditionDeJeu() {
        return conditionDeJeu;
    }

    public int getDestination() {
        return destination;
    }

    public String getNomJoueurs() {
        return nomJoueurs;
    }

    public void setNomJoueurs(String nomJoueurs) {
        this.nomJoueurs = nomJoueurs;
    }

    public void setNumeroDeCase(int numeroDeCase) {
        this.numeroDeCase = numeroDeCase;
    }

    public void setConditionDeJeu(String conditionDeJeu) {
        this.conditionDeJeu = conditionDeJeu;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
