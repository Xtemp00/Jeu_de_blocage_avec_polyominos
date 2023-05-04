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
    /**
 * Vérifie si la case à la position (x, y) de la grille est vide.
 * @param x La coordonnée x de la case.
 * @param y La coordonnée y de la case.
 * @return true si la case est vide, false sinon.
 */
    public boolean Est_vide(int x, int y) {
        if (grille[x][y].getValeur() == "#") {
            return true;
        }
        return false;
    }
    /**
 * Vérifie si la case à la position (x, y) de la grille est occupée.
 * @param x La coordonnée x de la case.
 * @param y La coordonnée y de la case.
 * @return true si la case est occupée, false sinon.
 */
    public boolean Est_Occupe(int x, int y) {
        if (grille[x][y].getValeur() != "#") {
            return true;
        }
        return false;
    }
    /**
 * Vérifie si la position (x, y) est dans la grille.
 * @param x La coordonnée x de la position.
 * @param y La coordonnée y de la position.
 * @return true si la position est dans la grille, false sinon.
 */
    public boolean Est_dans_la_grille(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 12) {
            return true;
        }
        return false;
    }
    /**
 * Vérifie si une pièce est entièrement dans la grille.
 * @param piece La pièce à vérifier.
 * @return true si la pièce est entièrement dans la grille, false sinon.
 */
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
    /**
 * Vérifie si une pièce est libre en regardant chaque case qu'elle occupe.
 *
 * @param piece la pièce à vérifier.
 * @return true si chaque case occupée par la pièce est vide, false sinon.
 */
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
    /**
 * Vérifie si une position donnée est libre dans la grille de jeu.
 *
 * @param x la position x de la case à vérifier.
 * @param y la position y de la case à vérifier.
 * @return true si la case est dans la grille et vide, false sinon.
 */
    public boolean Est_libre(int x, int y) {
        if (Est_dans_la_grille(x, y)) {
            if (Est_vide(x, y)) {
                return true;
            }
        }
        return false;
    }
/**
 * Remplit chaque case de la grille de jeu avec une valeur "#" pour la vider.
 */
    public void vider() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                grille[i][j].setValeur("#"); // chaque case de la grille est un objet de type Position
            }
        }
    }
    /**
 * Vérifie si au moins un domino peut être placé sur la grille de jeu.
 *
 * @return true si au moins un domino peut être placé sur la grille, false sinon.
 */
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
    /**

    Vérifie s'il est possible de placer un Triomino en forme de barre dans la grille.

    @return true si un Triomino en forme de barre peut être placé, false sinon.
    */
    public boolean Triominos_barre_possible() {
        // Parcours toutes les cases de la grille pour vérifier s'il est possible de placer un Triomino en forme de barre.
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
    /**

    Vérifie s'il est possible de placer un Triomino en forme de L dans la grille.

    @return true si un Triomino en forme de L peut être placé, false sinon.
    */
    public boolean Triominos_L_possible() {
        // Parcours toutes les cases de la grille pour vérifier s'il est possible de placer un Triomino en forme de L.
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
    /**
    Vérifie s'il est possible de placer un Tétromino en forme de barre dans la grille.
    @return true si un Tétromino en forme de barre peut être placé, false sinon.
    */
    public boolean Tetrominos_barre_possible() {
        // Parcours toutes les cases de la grille pour vérifier s'il est possible de placer un Tétromino en forme de barre.
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
    /**
    Vérifie si un Tetromino de forme L peut être placé sur le plateau de jeu.
    Parcourt les cases du plateau pour trouver un emplacement possible pour le Tetromino de forme L.
    @return true si un Tetromino de forme L peut être placé, false sinon.
    */
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
        return false;  // Renvoie false si aucune position possible n'a été trouvée.
    }
    /**
    Vérifie si un Tetromino de forme T peut être placé sur le plateau de jeu.
    Parcourt les cases du plateau pour trouver un emplacement possible pour le Tetromino de forme T.
    @return true si un Tetromino de forme T peut être placé, false sinon.
    */
    public boolean Tetrominos_T_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                if (Est_libre(i, j)) {
                    if (Est_libre(i, j+1)) {
                        if (Est_libre(i, j+2)) {
                            if (Est_libre(i+1, j+1)) {
                                return true; // Renvoie true si toutes les cases sont libres.
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
    /**
 * Vérifie si un Tetromino de type Z peut être placé sur la grille.
 * @return true si le Tetromino peut être placé, sinon false.
 */
    public boolean Tetrominos_Z_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false; // Si aucun placement n'est possible, retourne false
    }
    /**
 * Vérifie si un Tetromino de type Carré peut être placé sur la grille.
 * @return true si le Tetromino peut être placé, sinon false.
 */
    public boolean Tetrominos_Carre_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false; // Si aucun placement n'est possible, retourne false
    }
    /**
 * Vérifie si un Tetromino de type S peut être placé sur la grille.
 * @return true si le Tetromino peut être placé, sinon false.
 */
    public boolean Tetrominos_S_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false; // Si aucun placement n'est possible, retourne false
    }
        /**
 * Vérifie si un Tetromino de type L inversé peut être placé sur la grille.
 * @return true si le Tetromino L inversé peut être placé, sinon false.
 */
    public boolean Tetrominos_L_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false; // Si aucun placement n'est possible, retourne false
    }
     /**
 * Vérifie si un Tetromino de type T inversé peut être placé sur la grille.
 * @return true si le Tetromino T inversé peut être placé, sinon false.
 */
    public boolean Tetrominos_T_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 1; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false; // Si aucun placement n'est possible, retourne false
    }
       /**
 * Vérifie si un Tetromino de type S inversé peut être placé sur la grille.
 * @return true si le Tetromino S inversé peut être placé, sinon false.
 */
    public boolean Tetrominos_S_inverse_possible() {
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                // Vérifie si la case actuelle et les cases adjacentes sont libres
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
        return false;  // Si aucun placement n'est possible, retourne false
    }
}
