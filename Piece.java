public class Piece {
    private int pos_x;
    private int pos_y;
    private String valeur;
    private int[][] matrice;
    private int taille;
    Piece() {
        valeur = "O";
        pos_x = 0;
        pos_y = 0;
        taille = 0;
        matrice = new int[taille][taille];

    }

    public int[][] getMatrice() {
        return matrice;
    }
    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }
    public int getTaille() {
        return taille;
    }
    public void setTaille(int taille) {
        this.taille = taille;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public int getPos_x() {
        return pos_x;
    }
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
    public int getPos_y() {
        return pos_y;
    }
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public void rotation() {
        int[][] matrice = this.getMatrice();
        int[][] matrice2 = new int[this.getTaille()][this.getTaille()];
        for (int i = 0; i < this.getTaille(); i++) {
            for (int j = 0; j < this.getTaille(); j++) {
                matrice2[i][j] = matrice[this.getTaille()-j-1][i];
            }
        }
        this.setMatrice(matrice2);
    }
    public void afficher() {
        int[][] matrice = this.getMatrice();
        for (int i = 0; i < this.getTaille(); i++) {
            for (int j = 0; j < this.getTaille(); j++) {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }
    }
    public void dominos() {
        this.setTaille(2);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        matrice[0][0] = 1;
        matrice[0][1] = 1;
        this.setMatrice(matrice);
    }

    public  void triominos() {
        this.setTaille(3);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        matrice[0][0] = 1;
        matrice[0][1] = 1;
        matrice[0][2] = 1;
        this.setMatrice(matrice);
    }
    public void tetrominos() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        matrice[0][0] = 1;
        matrice[0][1] = 1;
        matrice[0][2] = 1;
        matrice[0][3] = 1;
        this.setMatrice(matrice);
    }



}
