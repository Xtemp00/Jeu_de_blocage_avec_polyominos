    /**
    Classe représentant une pièce.
    */
public class Piece {
    private int pos_x;
    private int pos_y;
    private String valeur;
    private int[][] matrice;
    private int taille;
    private String Type;
    private int Estjouer;
    
    /**
    Constructeur par défaut de la classe Piece.
    Initialise les valeurs par défaut pour les attributs.
    */
    Piece() {
        valeur = "O";
        pos_x = 0;
        pos_y = 0;
        taille = 0;
        matrice = new int[taille][taille];
        Type = "dominos";
        Estjouer = 1;


    }
    /**

    Constructeur de la classe Piece avec paramètres.
    Initialise les attributs avec les valeurs données en paramètres.
    @param taille la taille de la pièce
    @param Type le type de la pièce
    @param valeur la valeur de la pièce
    @param pos_x la position x de la pièce
    @param pos_y la position y de la pièce
    */
    Piece(int taille, String Type, String valeur, int pos_x, int pos_y, int Estjouer) {
        valeur = "O";
        pos_x = 0;
        pos_y = 0;
        this.taille = taille;
        matrice = new int[taille][taille];
        this.Type = Type;
        this.Estjouer = Estjouer;
    }
    /**
    Getter pour la matrice de la pièce
    @return la matrice de la pièce
    */
    public int[][] getMatrice() {
        return matrice;
    }
    /**
    Setter pour la matrice de la pièce
    @param matrice la nouvelle matrice de la pièce
    */
    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }
    /**
    Getter pour la taille de la pièce
    @return la taille de la pièce
    */
    public int getTaille() {
        return taille;
    }
    /**
    Setter pour la taille de la pièce
    @param taille la nouvelle taille de la pièce
    */
    public void setTaille(int taille) {
        this.taille = taille;
    }
    /**
    Getter pour la valeur de la pièce
    @return la valeur de la pièce
    */
    public String getValeur() {
        return valeur;
    }


    /**
    Setter pour la valeur de la pièce
    @param valeur la nouvelle valeur de la pièce
    */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    /**
    Getter pour la position x de la pièce
    @return la position x de la pièce
    */
    public int getPos_x() {
        return pos_x;
    }
    /**
    Setter pour la position x de la pièce
    @return la position x de la pièce
    */
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
    /**
    Getter pour la position y de la pièce
    @return la position y de la pièce
    */
    public int getPos_y() {
        return pos_y;
    }
    /**
    Setter pour la position y de la pièce
    @return la position y de la pièce
    */
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int getEstjouer() {
        return Estjouer;
    }
    public void setEstjouer(int Estjouer) {
        this.Estjouer = Estjouer;
    }
    /**
    Cette méthode permet de faire une rotation de la matrice de la pièce dans le sens des aiguilles d'une montre.
    La matrice est modifiée directement dans l'objet courant.
    */
    public void rotation() {
        int[][] matrice = this.getMatrice();
        int[][] matrice_rotation = new int[this.getTaille()][this.getTaille()];
        for (int i = 0; i < this.getTaille(); i++) {
            for (int j = 0; j < this.getTaille(); j++) {
                matrice_rotation[i][j] = matrice[this.getTaille() - j - 1][i];
            }
        }
        this.setMatrice(matrice_rotation);
    }

    /**
    Cette méthode permet d'afficher la matrice de la pièce dans la console.
    */
    public void afficher() {
        int[][] matrice = this.getMatrice();
        for (int i = 0; i < this.getTaille(); i++) {
            for (int j = 0; j < this.getTaille(); j++) {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }
    }
    /**
    Cette méthode permet de créer une pièce de domino qui est représentée par une matrice de taille 2x2 contenant des 1.
    La matrice est ensuite stockée dans l'attribut "matrice" de l'objet TetrisPiece courant et la taille est définie à 2.
    */
    public void dominos() {
        this.setTaille(2);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 1 0
        // 0 1 0
        matrice[0][0] = 1;
        matrice[1][0] = 1;
        this.setMatrice(matrice);
    }
    /**
    Cette méthode permet de créer une pièce en forme de "L" qui est représentée par une matrice de taille 4x4 contenant des 1.
    La matrice est ensuite stockée dans l'attribut "matrice" de l'objet TetrisPiece courant et la taille est définie à 4.
    */
    public void Tetrominos_L() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 0 1 0
        // 0 0 1 0
        // 0 0 1 1
        matrice[0][0] = 1;
        matrice[1][0] = 1;
        matrice[2][0] = 1;
        matrice[2][1] = 1;
        this.setMatrice(matrice);
    }
    /**
    Cette méthode permet de créer une pièce en forme de "L" inversé qui est représentée par une matrice de taille 4x4 contenant des 1.
    La matrice est ensuite stockée dans l'attribut "matrice" de l'objet TetrisPiece courant et la taille est définie à 4.
    */
    public void Tetrominos_L_inverse() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 0 1 0
        // 0 0 1 0
        // 0 1 1 0
        matrice[0][2] = 1;
        matrice[1][2] = 1;
        matrice[2][1] = 1;
        matrice[2][2] = 1;
        this.setMatrice(matrice);
    }
/**
    Crée un Tetrominos en forme de T.
    La matrice de ce Tetrominos est :
    0 1 0
    1 1 1
    */
    public void Tetrominos_T() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 1 0
        // 1 1 1
        matrice[0][1] = 1;
        matrice[1][0] = 1;
        matrice[1][1] = 1;
        matrice[1][2] = 1;
        this.setMatrice(matrice);
    }
    /**
    Crée un Tetrominos en forme de S.
    La matrice de ce Tetrominos est :
    0 1 1
    1 1 0
    */
    public void Tetrominos_S() {
        // 0 1 1
        // 1 1 0
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        matrice[0][1] = 1;
        matrice[0][2] = 1;
        matrice[1][0] = 1;
        matrice[1][1] = 1;
        this.setMatrice(matrice);
    }
    /**
    Crée un Tetrominos en forme de carré.
    La matrice de ce Tetrominos est :
    1 1
    1 1
    */
    public void Tetrominos_Carre() {
        // 1 1
        // 1 1
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        matrice[0][0] = 1;
        matrice[0][1] = 1;
        matrice[1][0] = 1;
        matrice[1][1] = 1;
        this.setMatrice(matrice);
    }
/**
    Crée un Tetrominos en forme de barre.
    La matrice de ce Tetrominos est :
    0 0 1 0
    0 0 1 0
    0 0 1 0
    0 0 1 0
    */
    public void Tetrominos_Barre() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 0 1 0
        // 0 0 1 0
        // 0 0 1 0
        // 0 0 1 0
        matrice[0][0] = 1;
        matrice[1][0] = 1;
        matrice[2][0] = 1;
        matrice[3][0] = 1;
        this.setMatrice(matrice);
    }
/**
    Crée un Tetrominos en forme de S inversé.
    La matrice de ce Tetrominos est :
    1 1 0
    0 1 1
    */
    public void Tetrominos_S_inverse() {
        this.setTaille(4);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 1 1 0
        // 0 1 1
        matrice[0][0] = 1;
        matrice[0][1] = 1;
        matrice[1][1] = 1;
        matrice[1][2] = 1;
        this.setMatrice(matrice);
    }
/**
    Crée un triominos en forme de L.
    La matrice de ce triominos est :
    0 1 0
    0 1 1
    */
    public void triominos_L() {
        this.setTaille(3);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 1 0
        // 0 1 1
        matrice[0][0] = 1;
        matrice[1][0] = 1;
        matrice[1][1] = 1;
        this.setMatrice(matrice);
    }
/**
    Crée un triomino de type "barre" avec une taille de 3x3 et initialise sa matrice représentative
    selon le modèle suivant :
    0 1 0
    0 1 0
    0 1 0
    Les cases contenant le chiffre 1 représentent les cellules du triomino.
    @return void
    */

    public void triominos_barre() {
        this.setTaille(3);
        int[][] matrice = new int[this.getTaille()][this.getTaille()];
        // 0 1 0
        // 0 1 0
        // 0 1 0
        matrice[0][0] = 1;
        matrice[1][0] = 1;
        matrice[2][0] = 1;
        this.setMatrice(matrice);
    }

}
