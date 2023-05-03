public class Joueur {
    private int nb_pieces;
    private int nb_triominos;
    private int nb_tetrominos;
    private int nb_dominos;
    //chaque joueur a 1 dominos, 2 triominos et 6 tetrominos tous differents
    private Piece[] dominos;
    private Piece[] triominos;
    private Piece[] tetrominos;
    Joueur() {
        nb_pieces = 9;
        nb_triominos = 2;
        nb_tetrominos = 6;
        nb_dominos = 1;
        dominos = new Piece[1];
        triominos = new Piece[2];
        tetrominos = new Piece[6];


    }
    public int getNb_pieces() {
        return nb_pieces;
    }
    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }
    public int getNb_triominos() {
        return nb_triominos;
    }
    public void setNb_triominos(int nb_triominos) {
        this.nb_triominos = nb_triominos;
    }
    public int getNb_tetrominos() {
        return nb_tetrominos;
    }
    public void setNb_tetrominos(int nb_tetrominos) {
        this.nb_tetrominos = nb_tetrominos;
    }
    public int getNb_dominos() {
        return nb_dominos;
    }
    public void setNb_dominos(int nb_dominos) {
        this.nb_dominos = nb_dominos;
    }
    public Piece[] getDominos() {
        return dominos;
    }
    public void setDominos(Piece[] dominos) {
        this.dominos = dominos;
    }
    public Piece[] getTriominos() {
        return triominos;
    }
    public void setTriominos(Piece[] triominos) {
        this.triominos = triominos;
    }
    public Piece[] getTetrominos() {
        return tetrominos;
    }
    public void setTetrominos(Piece[] tetrominos) {
        this.tetrominos = tetrominos;
    }


}
