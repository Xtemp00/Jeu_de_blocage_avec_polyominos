import java.util.Scanner;

/**
   La classe Joueur représente un joueur du jeu de Tetrominos.
   Chaque joueur possède un nombre spécifique de pièces, soit :
     -1 domino
     -2 triominos
     -6 tétrominos différents
   La classe contient des attributs représentant le nombre de chaque type de pièces possédées par le joueur,
   ainsi que des tableaux pour stocker les pièces elles-mêmes.
   Les méthodes getters et setters permettent d'accéder aux attributs de l'objet et de les modifier au besoin.
    */
public class Joueur {
    private int nb_pieces;
    private int nb_triominos;
    private int nb_tetrominos;
    private int nb_dominos;
    //chaque joueur a 1 dominos, 2 triominos et 6 tetrominos tous differents
    private Piece[] dominos;
    private Piece[] triominos;
    private Piece[] tetrominos;
    /**
    Constructeur par défaut de la classe Joueur.
    Initialise les attributs du joueur avec des valeurs prédéfinies.
    */
    Joueur() {
        nb_pieces = 9;
        nb_triominos = 2;
        nb_tetrominos = 6;
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

    public int Saisir_Piece(Grille grille, Piece [] pieces){
        int answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Veuillez saisir la piece que vous voulez placer : ");
            System.out.println("1 : Domino");
            System.out.println("2 : Triomino barre");
            System.out.println("3 : Triomino L");
            System.out.println("4 : Tetromino T");
            System.out.println("5 : Tetromino S");
            System.out.println("6 : Tetromino L");
            System.out.println("7 : Tetromino Carre");
            System.out.println("8 : Tetromino L inverse");
            System.out.println("9 : Tetromino S inverse");
            System.out.println("10 : tetromino barre");
            System.out.println("11 : quittez le jeu");
            answer = sc.nextInt();
        }while(answer < 1 || answer > 11);
        return answer = sc.nextInt();
    }

    public int Saisir_Rotation(){
        int answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Veuillez saisir la rotation que vous voulez faire : ");
            System.out.println("1 : 0°");
            System.out.println("2 : 90°");
            System.out.println("3 : 180°");
            System.out.println("4 : 270°");
            System.out.println("5 : quittez le jeu");
            answer = sc.nextInt();
        }while(answer < 1 || answer > 5);
        return answer = sc.nextInt();
    }
    public int Saisir_Position_X(){
        int answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Veuillez saisir la position en x de la piece que vous voulez placer : ");
            answer = sc.nextInt();
        }while(answer < 0 || answer > 12);
        return answer = sc.nextInt();
    }
    public int Saisir_Position_Y(){
        int answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Veuillez saisir la position en y de la piece que vous voulez placer : ");
            answer = sc.nextInt();
        }while(answer < 0 || answer > 10);
        return answer = sc.nextInt();
    }

}
