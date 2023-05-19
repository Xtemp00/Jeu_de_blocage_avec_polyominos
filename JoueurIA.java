public class JoueurIA {
    private int nb_pieces;
    private int nb_triominos;
    private int nb_tetrominos;
    private int nb_dominos;
    private Piece[] dominos;
    private Piece[] triominos;
    private Piece[] tetrominos;


    JoueurIA() {
        nb_pieces = 10;
        nb_triominos = 2;
        nb_tetrominos = 7;
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

   /**
     * Choisit une pièce aléatoire parmis celles disponibles puis la fait tourner ou non et la positionne au hasard sur le plateau de jeu.
     *
     * @param plateau           Le plateau de jeu.
     * @param pieces_ordinateur
     */
   public void jouer(Grille plateau, Piece[] pieces_ordinateur) {
        int nb_pieces = this.getNb_pieces();
        int nb_triominos = this.getNb_triominos();
        int nb_tetrominos = this.getNb_tetrominos();
        int nb_dominos = this.getNb_dominos();
        Piece[] dominos = this.getDominos();
        Piece[] triominos = this.getTriominos();
        Piece[] tetrominos = this.getTetrominos();
        Piece piece;
        int piece_aleatoire;
        boolean piece_placer;
        do {
            piece_aleatoire = (int) (Math.random() * pieces_ordinateur.length);

            piece = pieces_ordinateur[piece_aleatoire];
            int rotation_aleatoire = (int) (Math.random() * 2);
            if (rotation_aleatoire == 1) {
                piece.rotation();
            }
            int position_x_aleatoire = (int) (Math.random() * 12);
            int position_y_aleatoire = (int) (Math.random() * 10);
            piece.setPos_x(position_x_aleatoire);
            piece.setPos_y(position_y_aleatoire);
            piece_placer = plateau.placerPiece(piece);
        } while(pieces_ordinateur[piece_aleatoire].getEstjouer()<0 && piece_placer);
        pieces_ordinateur[piece_aleatoire].setEstjouer((pieces_ordinateur[piece_aleatoire].getEstjouer())-1);
        System.out.println(pieces_ordinateur[piece_aleatoire].getEstjouer());
    }

}



