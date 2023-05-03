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
    }
}
