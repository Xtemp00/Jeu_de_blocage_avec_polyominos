public class Main {
    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.afficher();
        Piece piece = new Piece();
        piece.setTaille(2);
        piece.setMatrice(new int[][]{{1,1},{1,1}});
        piece.setPos_x(2);
        piece.setPos_y(2);
        grille.placerPiece(piece);
        grille.afficher();
        piece.dominos();
        piece.setPos_x(0);
        piece.setPos_y(0);
        piece.rotation();
        grille.placerPiece(piece);
        grille.afficher();
        piece.triominos();
        piece.setPos_x(5);
        piece.setPos_y(5);
        grille.placerPiece(piece);
        grille.afficher();

    }
}
