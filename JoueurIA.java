public class JoueurIA {
    private int nb_pieces;
    private int nb_triominos;
    private int nb_tetrominos;
    private int nb_dominos;
    private Piece[] dominos;
    private Piece[] triominos;
    private Piece[] tetrominos;


    JoueurIA() {
        nb_pieces = 9;
        nb_triominos = 2;
        nb_tetrominos = 6;
        nb_dominos = 1;
        dominos = new Piece[1];
        triominos = new Piece[2];
        tetrominos = new Piece[6];
    }
    /**
     Retourne le nombre total de pièces possédées par le joueur.
     @return Le nombre total de pièces possédées par le joueur.
     */
    public int getNb_pieces() {
        return nb_pieces;
    }
    /**
     Modifie le nombre total de pièces possédées par le joueur.
     @param nb_pieces Le nouveau nombre total de pièces possédées par le joueur.
     */

    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }
    /**
     Retourne le nombre de triominos possédés par le joueur.
     @return Le nombre de triominos possédés par le joueur.
     */
    public int getNb_triominos() {
        return nb_triominos;
    }
    /**
     Modifie le nombre de triominos possédés par le joueur.
     @param nb_triominos Le nouveau nombre de triominos possédés par le joueur.
     */
    public void setNb_triominos(int nb_triominos) {
        this.nb_triominos = nb_triominos;
    }
    /**
     Retourne le nombre de tétrominos possédés par le joueur.
     @return Le nombre de tétrominos possédés par le joueur.
     */
    public int getNb_tetrominos() {
        return nb_tetrominos;
    }
    /**
     Modifie le nombre de tétrominos possédés par le joueur.
     @param nb_tetrominos Le nouveau nombre de tétrominos possédés par le joueur.
     */
    public void setNb_tetrominos(int nb_tetrominos) {
        this.nb_tetrominos = nb_tetrominos;
    }
    /**

     Retourne le nombre de dominos possédés par le joueur.
     @return Le nombre de dominos possédés par le joueur.
     */
    public int getNb_dominos() {
        return nb_dominos;
    }

    /**
     Définit le nombre de dominos du joueur.
     @param nb_dominos le nouveau nombre de dominos du joueur.
     */
    public void setNb_dominos(int nb_dominos) {
        this.nb_dominos = nb_dominos;
    }
    /**
     Retourne le tableau de dominos du joueur.
     @return le tableau de dominos du joueur.
     */
    public Piece[] getDominos() {
        return dominos;
    }
    /**
     Définit le tableau de dominos du joueur.
     @param dominos le nouveau tableau de dominos du joueur.
     */
    public void setDominos(Piece[] dominos) {
        this.dominos = dominos;
    }
    /**
     Retourne le tableau de triominos du joueur.
     @return le tableau de triominos du joueur.
     */
    public Piece[] getTriominos() {
        return triominos;
    }
    /**
     Définit le tableau de triominos du joueur.
     @param triominos le nouveau tableau de triominos du joueur.
     */
    public void setTriominos(Piece[] triominos) {
        this.triominos = triominos;
    }

    /**
     Retourne le tableau de tetrominos du joueur.
     @return le tableau de tetrominos du joueur.
     */
    public Piece[] getTetrominos() {
        return tetrominos;
    }
    /**
     Définit le tableau de tetrominos du joueur.
     @param tetrominos le nouveau tableau de tetrominos du joueur.
     */
    public void setTetrominos(Piece[] tetrominos) {
        this.tetrominos = tetrominos;
    }

    //on voudrais crée une ou plusieurs foction qui permet a l'ai de jouer et de placer des pieces en fonction de ce qui a deja ete placer sans trop d'aleatoire
    // l'ia devrais apprendre de ses erreurs et ne pas les refaire
    // l'ia devrais aussi essayer de bloquer l'adversaire
    // l'ia devrais aussi essayer de faire des coups qui lui permette de placer plusieurs pieces d'un coup
    // elle apprendra tout sa en jouant contre elle meme via apprentisage par renforcement

    //on voudrais aussi crée une fonction qui permet a l'ia de choisir quelle piece elle va jouer en fonction de ce qui a deja ete jouer
    public void learn(){
        //on voudrais que l'ia choisisse la piece qu'elle va jouer en fonction de ce qui a deja ete jouer
        //on voudrais aussi que l'ia choisisse la position de la piece qu'elle va jouer en fonction de ce qui a deja ete jouer
        //on voudrais aussi que l'ia choisisse la rotation de la piece qu'elle va jouer en fonction de ce qui a deja ete jouer
        //on voudrais aussi que l'ia choisisse la piece qu'elle va jouer en fonction de ce qui a deja ete jouer

    }
}

