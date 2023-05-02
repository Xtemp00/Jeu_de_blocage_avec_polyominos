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
    Grille () {
        grille = new Position[10][12]; // 10 lignes et 12 colonnes
        for (int i = 0; i < 10; i++) { // 10 lignes
            for (int j = 0; j < 12; j++) { // 12 colonnes
                grille[i][j] = new Position(); // chaque case de la grille est un objet de type Position
            }
        }
    }

    public void afficher() {
        for (int i = 0; i < 10; i++) {
            System.out.print("| ");
            for (int j = 0; j < 12; j++) {
                System.out.print(grille[i][j].getValeur() + " ");
                if (j == 11){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
