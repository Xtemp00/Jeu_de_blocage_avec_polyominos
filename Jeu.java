import java.util.Scanner;
public class Jeu {
    //il y aura 4 modes de jeu le premier sera le mode 1 joueur contre l'ordinateur avec toutes les pieces, le deuxieme
    // avec seulement des dominos, le troisieme avec que les triominos et le quatrieme avec que les tetrominos
    private int game;
    public Jeu() {
        game = 1;
    }
    public void Choose_Game(){
        scanner sc = new scanner(System.in);
        do {
            System.out.println("Choisissez le mode de jeu : ");
            System.out.println("1 : 1 joueur contre l'ordinateur avec toutes les pieces et toujours les mêmes pieces (Jeu de base)");
            System.out.println("2 : 1 joueur contre l'ordinateur avec toutes les pieces");
            System.out.println("3 : 1 joueur contre l'ordinateur avec seulement des dominos");
            System.out.println("4 : 1 joueur contre l'ordinateur avec seulement des triominos");
            System.out.println("5 : 1 joueur contre l'ordinateur avec seulement des tetrominos");
            this.game = sc.nextInt();
        } while (this.game < 1 || this.game > 5);

    }
    public int getGame() {
        return this.game;
    }
    public void setGame(int game) {
        this.game = game;
    }

    public void Game_Basic() {
        Grille grille = new Grille();
        Joueur joueur = new Joueur();
        Joueur ordinateur = new Joueur();
        Piece[] dominos = new Piece[1];
        Piece[] triominos = new Piece[2];
        Piece[] tetrominos = new Piece[6];
        //dominos
        dominos[0] = new Piece(2, "dominos", "#", 0, 0);
        dominos[0].dominos();
        //triominos
        triominos[0] = new Piece(3, "triominos", "#", 0, 0);
        triominos[1].triominos_barre();
        triominos[1] = new Piece(3, "triominos", "#", 0, 0);
        triominos[1].triominos_L();
        //tetrominos
        tetrominos[0] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[0].Tetrominos_T();
        tetrominos[1] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[1].Tetrominos_S();
        tetrominos[2] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[2].Tetrominos_L();
        tetrominos[3] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[3].Tetrominos_Carre();
        tetrominos[4] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[4].Tetrominos_L_inverse();
        tetrominos[5] = new Piece(4, "tetrominos", "#", 0, 0);
        tetrominos[5].Tetrominos_S_inverse();
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces = new Piece[9];
        pieces[0] = dominos[0];
        pieces[1] = triominos[0];
        pieces[2] = triominos[1];
        pieces[3] = tetrominos[0];
        pieces[4] = tetrominos[1];
        pieces[5] = tetrominos[2];
        pieces[6] = tetrominos[3];
        pieces[7] = tetrominos[4];
        pieces[8] = tetrominos[5];
        //on va creer un tableau de pieces qui contiendra toutes les pieces
        Piece[] pieces_ordinateur = new Piece[9];
        pieces_ordinateur[0] = dominos[0];
        pieces_ordinateur[1] = triominos[0];
        pieces_ordinateur[2] = triominos[1];
        pieces_ordinateur[3] = tetrominos[0];
        pieces_ordinateur[4] = tetrominos[1];
        pieces_ordinateur[5] = tetrominos[2];
        pieces_ordinateur[6] = tetrominos[3];
        pieces_ordinateur[7] = tetrominos[4];
        pieces_ordinateur[8] = tetrominos[5];
    }



}
