import sun.awt.X11.XSystemTrayPeer;
import java.util.Scanner;

/**
 * La classe Jeu permet de lancer différents modes de jeu pour jouer contre l'ordinateur.
 * Les modes disponibles sont :
 * - le mode de base avec toutes les pièces,
 * - le mode avec seulement des dominos,
 * - le mode avec seulement des triominos,
 * - le mode avec seulement des tetrominos.
 * Le choix du mode de jeu est effectué par l'utilisateur via la méthode Choose_Game().
 */
 
public class Jeu {
/**
     * Le numéro du mode de jeu choisi.
     */
    private int game;
    /**
     * Constructeur par défaut de la classe Jeu.
     * Initialise le mode de jeu à 1.
     */
    public Jeu() {
        game = 1;
    }
    /**
     * Permet à l'utilisateur de choisir le mode de jeu parmi les modes disponibles.
     * Le choix est effectué via une saisie clavier.
     */
    public void Choose_Game(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choisissez le mode de jeu : ");
            System.out.println("1 : 1 joueur contre l'ordinateur avec toutes les pieces et toujours les mêmes pieces (Jeu de base)");
            System.out.println("2 : 1 joueur contre l'ordinateur avec toutes les pieces");
            System.out.println("3 : 1 joueur contre l'ordinateur avec seulement des dominos");
            System.out.println("4 : 1 joueur contre l'ordinateur avec seulement des triominos");
            System.out.println("5 : 1 joueur contre l'ordinateur avec seulement des tetrominos");
            this.game = sc.nextInt();
        } while (this.game < 1 || this.game > 5);
        // Lance le mode de jeu correspondant au choix de l'utilisateur.
        switch (this.game) {
            case 1: 
                Game_Basic();
                break;
            case 2:
                //Game_All_Pieces();
                break;
            case 3:
                //Game_Dominos();
                break;
            case 4:
                //Game_Triominos();
                break;
            case 5:
                //Game_Tetrominos();
                break;
        }

    }
/**
 * Retourne la valeur de l'attribut game.
 * @return la valeur de l'attribut game.
 */
    public int getGame() {
        return this.game;
    }
/**
 * Modifie la valeur de l'attribut game.
 * @param game la nouvelle valeur de l'attribut game.
 */
    public void setGame(int game) {
        this.game = game;
    }
/**
 * Initialise une partie du jeu.
 * Crée une grille, un joueuret un joueur ordinateur (IA).
 * Crée un tableau de pièces dominos, triominos et tetrominos, et les initialise.
 * Crée un tableau de pièces qui contiendra toutes les pièces et un tableau pour les pièces de l'ordinateur.
 * Demande à l'utilisateur de saisir une pièce à placer et affiche les options possibles.
 * Tant que le joueur n'a pas gagné, continue la partie.
 */
 
    public void Game_Basic() {
        Grille grille = new Grille();
        Joueur joueur = new Joueur();
        Scanner sc = new Scanner(System.in);
        JoueurIA ordinateur = new JoueurIA();
        int answer;
        Piece[] dominos = new Piece[1];
        Piece[] triominos = new Piece[2];
        Piece[] tetrominos = new Piece[7];
        //dominos
        dominos[0] = new Piece(2, "dominos", "O", 0, 0,1);
        dominos[0].dominos();
        dominos[0].setValeur("0");
        //triominos
        triominos[0] = new Piece(3, "triominos", "O", 0, 0,1);
        triominos[0].triominos_barre();
        triominos[0].setValeur("0");
        triominos[1] = new Piece(2, "triominos", "O", 0, 0,1);
        triominos[1].triominos_L();
        triominos[1].setValeur("0");
        //tetrominos
        tetrominos[0] = new Piece(3, "tetrominos", "O", 0, 0,1);
        tetrominos[0].Tetrominos_T();
        tetrominos[0].setValeur("0");
        tetrominos[1] = new Piece(3, "tetrominos", "O", 0, 0,1);
        tetrominos[1].Tetrominos_S();
        tetrominos[1].setValeur("0");
        tetrominos[2] = new Piece(3, "tetrominos", "O", 0, 0,1);
        tetrominos[2].Tetrominos_L();
        tetrominos[2].setValeur("0");
        tetrominos[3] = new Piece(2, "tetrominos", "O", 0, 0,1);
        tetrominos[3].Tetrominos_Carre();
        tetrominos[3].setValeur("0");
        tetrominos[4] = new Piece(3, "tetrominos", "O", 0, 0,1);
        tetrominos[4].Tetrominos_L_inverse();
        tetrominos[4].setValeur("0");
        tetrominos[5] = new Piece(3, "tetrominos", "O", 0, 0,1);
        tetrominos[5].Tetrominos_S_inverse();
        tetrominos[5].setValeur("0");
        tetrominos[6] = new Piece(4, "tetrominos", "O", 0, 0,1);
        tetrominos[6].Tetrominos_Barre();
        tetrominos[6].setValeur("0");
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        System.out.println(dominos[0].getValeur());
        Piece[] pieces = new Piece[10];
        pieces[0] = dominos[0];
        pieces[1] = triominos[0];
        pieces[2] = triominos[1];
        pieces[3] = tetrominos[0];
        pieces[4] = tetrominos[1];
        pieces[5] = tetrominos[2];
        pieces[6] = tetrominos[3];
        pieces[7] = tetrominos[4];
        pieces[8] = tetrominos[5];
        pieces[9] = tetrominos[6];
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces_ordinateur = new Piece[10];
        pieces_ordinateur[0] = dominos[0];
        pieces_ordinateur[1] = triominos[0];
        pieces_ordinateur[2] = triominos[1];
        pieces_ordinateur[3] = tetrominos[0];
        pieces_ordinateur[4] = tetrominos[1];
        pieces_ordinateur[5] = tetrominos[2];
        pieces_ordinateur[6] = tetrominos[3];
        pieces_ordinateur[7] = tetrominos[4];
        pieces_ordinateur[8] = tetrominos[5];
        pieces_ordinateur[9] = tetrominos[6];
        while(!Win_Joueur(joueur,grille)){

                boolean posable = true;
                do {
                    answer = joueur.Saisir_Piece(grille,pieces);
                    if (answer == 11){
                        System.out.println("vous avez quittez la partie");
                        System.exit(0);
                    } else {
                        pieces[answer-1].afficher();
                    }
                    int answer2 = joueur.Saisir_Rotation();
                    if (answer2 == 4){
                        System.out.println("vous avez quittez la partie");
                        System.exit(0);
                    }
                    else {
                        for(int i = 0; i < answer2; i++){
                            pieces[answer-1].rotation();
                        }
                    }
                    int answer3 = joueur.Saisir_Position_X();
                    pieces[answer-1].setPos_x(answer3);
                    int answer4 = joueur.Saisir_Position_Y();
                    pieces[answer-1].setPos_y(answer4);
                    posable = grille.placerPiece(pieces[answer-1]);


                    }while (posable);
                ordinateur.jouer(grille,pieces_ordinateur);
                System.out.println("L'ordinateur a joué : ");
                grille.afficher();

        }
        if (Win_Joueur(joueur,grille)){
            System.out.println("Vous avez gagné");
        }
        else {
            System.out.println("L'ordinateur a gagné");
        }

    }
/**
 * Cette méthode initialise une nouvelle partie de domino avec une grille, un joueur, un ordinateur et une pièce de domino.
 * 
 * @return void
 */
    public void Game_Dominos() {
        //fonction qui va initialiser lap artie mais dans lequel il y aura que des dominos c'est a dire pas de triominos ni de tetrominos
        int answer;
        //on va creer un joueur et un ordinateur
        Joueur joueur = new Joueur();
        JoueurIA ordinateur = new JoueurIA();
        //on va creer une grille
        Grille grille = new Grille();
        //on va creer un tableau de dominos
        Piece[] dominos = new Piece[1];
        dominos[0] = new Piece(2, "dominos", "O", 0, 0, 29);
        dominos[0].dominos();
        dominos[0].setValeur("0");
        Piece[] dominos_ordinateur = new Piece[1];
        dominos_ordinateur[0] = new Piece(2, "dominos", "O", 0, 0, 29);
        dominos_ordinateur[0].dominos();
        dominos_ordinateur[0].setValeur("1");
        //on va creer un tableau de pieces qui contiendra toutes les pieces;
        Piece[] pieces = new Piece[1];
        pieces[0] = dominos[0];
        //on va creer un tableau de pieces qui contiendra toutes les pieces;
        Piece[] pieces_ordinateur = new Piece[1];
        pieces_ordinateur[0] = dominos_ordinateur[0];

        while (!Win_Joueur(joueur, grille)) {

            boolean posable = true;
            do {
                answer = joueur.Saisir_Piece_Domino(grille, pieces);
                if (answer == 2) {
                    System.out.println("vous avez quittez la partie");
                    System.exit(0);
                } else {
                    pieces[answer - 1].afficher();
                }
                int answer2 = joueur.Saisir_Rotation();
                if (answer2 == 4) {
                    System.out.println("vous avez quittez la partie");
                    System.exit(0);
                } else {
                    for (int i = 0; i < answer2; i++) {
                        pieces[answer - 1].rotation();
                    }
                }
                int answer3 = joueur.Saisir_Position_X();
                pieces[answer - 1].setPos_x(answer3);
                int answer4 = joueur.Saisir_Position_Y();
                pieces[answer - 1].setPos_y(answer4);
                posable = grille.placerPiece(pieces[answer - 1]);


            } while (posable);
            ordinateur.jouer(grille, pieces_ordinateur);
            System.out.println("L'ordinateur a joué : ");
            grille.afficher();
        }
        if (Win_Joueur(joueur, grille)) {
            System.out.println("Vous avez gagné");
        } else {
            System.out.println("l'Ordinateur avez a gagné");
        }
    }

    public void Game_Triominos(){
        //fonction qui va initialiser lap artie mais dans lequel il y aura que des triominos c'est a dire pas de dominos ni de tetrominos
        int answer;
        //on va creer un joueur et un ordinateur
        Joueur joueur = new Joueur();
        JoueurIA ordinateur = new JoueurIA();
        //on va creer une grille
        Grille grille = new Grille();
        //on va creer un tableau de triominos
        Piece[] triominos = new Piece[2];
        triominos[0] = new Piece(3, "triominos", "O", 0, 0, 6);
        triominos[0].triominos_barre();
        triominos[0].setValeur("0");
        triominos[1] = new Piece(3, "triominos", "O", 0, 0, 6);
        triominos[1].triominos_L();
        triominos[1].setValeur("0");
        Piece[] triominos_ordinateur = new Piece[2];
        triominos_ordinateur[0] = new Piece(3, "triominos", "O", 0, 0, 6);
        triominos_ordinateur[0].triominos_barre();
        triominos_ordinateur[0].setValeur("1");
        triominos_ordinateur[1] = new Piece(3, "triominos", "O", 0, 0, 6);
        triominos_ordinateur[1].triominos_L();
        triominos_ordinateur[1].setValeur("1");
        //on va creer un tableau de pieces qui contiendra toutes les pieces;
        Piece[] pieces = new Piece[2];
        pieces[0] = triominos[0];
        pieces[1] = triominos[1];
        //on va creer un tableau de pieces qui contiendra toutes les pieces;
        Piece[] pieces_ordinateur = new Piece[2];
        pieces_ordinateur[0] = triominos_ordinateur[0];
        pieces_ordinateur[1] = triominos_ordinateur[1];

        while(!Win_Joueur(joueur,grille)) {

            boolean posable = true;
            do {
                answer = joueur.Saisir_Piece_Triominos(grille, pieces);
                if (answer == 3) {
                    System.out.println("vous avez quittez la partie");
                    System.exit(0);
                } else {
                    pieces[answer - 1].afficher();
                }
                int answer2 = joueur.Saisir_Rotation();
                if (answer2 == 4) {
                    System.out.println("vous avez quittez la partie");
                    System.exit(0);
                } else {
                    for (int i = 0; i < answer2; i++) {
                        pieces[answer - 1].rotation();
                    }
                }
                int answer3 = joueur.Saisir_Position_X();
                pieces[answer - 1].setPos_x(answer3);
                int answer4 = joueur.Saisir_Position_Y();
                pieces[answer - 1].setPos_y(answer4);
                posable = grille.placerPiece(pieces[answer - 1]);
            } while (posable);
            ordinateur.jouer(grille, pieces_ordinateur);
            System.out.println("L'ordinateur a joué : ");
            grille.afficher();
        }
        if(Win_Joueur(joueur,grille)){
            System.out.println("Vous avez gagné");
        }
        else{
            System.out.println("l'Ordinateur avez a gagné");
        }
    }

/**
 * Cette méthode vérifie si un joueur a gagné en regardant si aucun joueur ne peut placer de pièce.
 * 
 * @param joueur Le joueur actuel.
 * @param grille La grille actuelle.
 * @return boolean indique si le joueur a gagné (true) ou non (false).
 */
    public boolean Win_Joueur(Joueur joueur,Grille grille) {
        //pour detecter si il y a un gangant il faut que le joueur adverse ne puisse plus placer aucune pieces
        //on va donc regarder si les deux joueurs ne peuvent plus placer de pieces
        // Vérification si les dominos peuvent être placés
        if (grille.Dominos_possible() == false) {
            return true;
        }
        else {
            // Vérification si les triominos peuvent être placés
            if (grille.Triominos_barre_possible() == false && grille.Triominos_L_possible() == false) {
                return true;
            }
            else {
            // Vérification si les tetrominos peuvent être placés
                if (grille.Tetrominos_Carre_possible() == false && grille.Tetrominos_L_possible() == false
                        && grille.Tetrominos_S_possible() == false && grille.Tetrominos_S_inverse_possible() == false
                        && grille.Tetrominos_T_possible() == false && grille.Tetrominos_L_inverse_possible() == false
                        && !grille.Tetrominos_barre_possible()) {
                    return true;
                }
                else {
                    return false;
                }
            }

        }
    }
}
