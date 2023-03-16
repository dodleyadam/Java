package codeSource;

public  class Case {
    private String nomJoueurs;
    private int numeroDeCase;
    private String conditionDeJeu;
    private int destination;


    /**
     * Ce constructeur prend en parametre les elements composant la case, c'est-a-dire: nom des joueurs,la destination
     * les numeros de cases et les condtions de jeu
     * @param nomJoueurs
     * @param destination
     * @param numeroDeCase
     * @param conditionDeJeu
     */
    public Case(String nomJoueurs, int destination, int numeroDeCase, String conditionDeJeu) {
        this.nomJoueurs=   nomJoueurs ;
        this.numeroDeCase= numeroDeCase;
        this.conditionDeJeu = conditionDeJeu;
        this.destination = destination;

    }

    /**
     * Cette methode retourne le numero de case
     * @return
     */
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

    @Override
    public
    String toString() {
        return "Case numero: "+numeroDeCase+" condition:"+conditionDeJeu +" Destination: "+destination
                +" nom du joueur: "+nomJoueurs;
    }
}
