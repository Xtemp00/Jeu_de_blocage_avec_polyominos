public class Main {
    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.afficher();
        Piece piece = new Piece();
        grille.placerPiece(piece);
        grille.afficher();
        piece.dominos();
        piece.setPos_x(0);
        piece.setPos_y(0);
        piece.rotation();
        grille.placerPiece(piece);
        grille.afficher();
        piece.triominos_barre();
        piece.setPos_x(2);
        piece.setPos_y(2);
        grille.placerPiece(piece);
        grille.afficher();
        piece.triominos_L();
        piece.setPos_x(4);
        piece.setPos_y(4);
        grille.placerPiece(piece);
        grille.afficher();
        piece.Tetrominos_T();
        piece.setPos_x(6);
        piece.setPos_y(6);
        grille.placerPiece(piece);
        grille.afficher();
        piece.Tetrominos_S();
        piece.setPos_x(8);
        piece.setPos_y(8);
        grille.placerPiece(piece);
        grille.afficher();
        piece.Tetrominos_L();
        piece.setPos_x(8);
        piece.setPos_y(8);
        grille.placerPiece(piece);
        grille.afficher();

    }
}
