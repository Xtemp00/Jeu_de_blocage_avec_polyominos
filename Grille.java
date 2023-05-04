public class Grille {
    /*Matrices d'objets obligatoire
      jeu de blocage avec des polyominos
      pieces de dominos, triominos et tetrominos
      grille de 10*12
        10 lignes et 12 colonnes
        3 pieces de chaque
        3*2 + 3*3 + 3*4 = 3*(2+3+4) = 27
        27 pieces
     */
    private Position[][] grille;

    /**
     * Constructeur de la classe Grille
     * @param
     * @return
     */
    Grille () {
        grille = new Position[10][12]; // 10 lignes et 12 colonnes
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                grille[i][j] = new Position(); // chaque case de la grille est un objet de type Position
            }
        }
    }

    /**
     * @return
     */
    public void afficher() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            System.out.print("| "); // debut de ligne
            for (int j = 0; j < 12; j++) { // 12 colonnes
                System.out.print(grille[i][j].getValeur() + " "); // affichage de la valeur de chaque case
                if (j == 11){ // fin de ligne
                    System.out.print("|"); // fin de ligne
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * @param piece
     */
    public void placerPiece(Piece piece) { // placer une piece sur la grille
        int x = piece.getPos_x();
        int y = piece.getPos_y();
        int[][] matrice = piece.getMatrice();
        for (int i = 0; i < piece.getTaille(); i++) {
            for (int j = 0; j < piece.getTaille(); j++) {
                if ((matrice[i][j] == 1) && (Est_dans_la_grille(y+i,x+j)) && (Est_vide(y+i,x+j))) {
                    grille[y+i][x+j].setValeur(piece.getValeur());
                }
            }
        }
    }
    public boolean Est_vide(int x, int y) {
        if (grille[x][y].getValeur() == "#") {
            return true;
        }
        return false;
    }
    public boolean Est_Occupe(int x, int y) {
        if (grille[x][y].getValeur() != "#") {
            return true;
        }
        return false;
    }
    public boolean Est_dans_la_grille(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 12) {
            return true;
        }
        return false;
    }
    public boolean Piece_Est_dans_la_grille(Piece piece) {
        int x = piece.getPos_x();
        int y = piece.getPos_y();
        int[][] matrice = piece.getMatrice();
        for (int i = 0; i < piece.getTaille(); i++) {
            for (int j = 0; j < piece.getTaille(); j++) {
                if (matrice[i][j] == 1) {
                    if (!Est_dans_la_grille(x+i, y+j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean Piece_Est_libre(Piece piece) {
        int x = piece.getPos_x();
        int y = piece.getPos_y();
        int[][] matrice = piece.getMatrice();
        for (int i = 0; i < piece.getTaille(); i++) {
            for (int j = 0; j < piece.getTaille(); j++) {
                if (matrice[i][j] == 1) {
                    if (!Est_vide(x+i, y+j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean Est_libre(int x, int y) {
        if (Est_dans_la_grille(x, y)) {
            if (Est_vide(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void vider() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                grille[i][j].setValeur("#"); // chaque case de la grille est un objet de type Position
            }
        }
    }
    public boolean Dominos_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        return true;
                    }
                    if (Est_libre(i+1, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean Triominos_barre_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i, j+2)) {
                            return true;
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Triominos_L_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i+1, j+1)) {
                            return true;
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+1, j+1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_barre_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i, j+2)) {
                            if (Est_libre(i, j+3)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            if (Est_libre(i+3, j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_L_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i, j+2)) {
                            if (Est_libre(i+1, j+2)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            if (Est_libre(i+2, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_T_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i, j+2)) {
                            if (Est_libre(i+1, j+1)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            if (Est_libre(i+1, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_Z_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i+1, j+1)) {
                            if (Est_libre(i+1, j+2)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+1, j-1)) {
                            if (Est_libre(i+2, j-1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_Carre_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i+1, j)) {
                            if (Est_libre(i+1, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_S_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j-1)) {
                        if (Est_libre(i+1, j-1)) {
                            if (Est_libre(i+1, j-2)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+1, j+1)) {
                            if (Est_libre(i+2, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_L_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j-1)) {
                        if (Est_libre(i, j-2)) {
                            if (Est_libre(i+1, j-2)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            if (Est_libre(i+2, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_T_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j-1)) {
                        if (Est_libre(i, j-2)) {
                            if (Est_libre(i+1, j-1)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+2, j)) {
                            if (Est_libre(i+1, j+1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean Tetrominos_S_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i+1, j+1)) {
                            if (Est_libre(i+1, j+2)) {
                                return true;
                            }
                        }
                    }
                    if (Est_libre(i+1, j)) {
                        if (Est_libre(i+1, j-1)) {
                            if (Est_libre(i+2, j-1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
