import java.util.Scanner;

public class Jeu {
    public void ajouter_piece(Piece piece, Position position, Grille grille) {
        int position_x = 0;
        int position_y = 0;
        System.out.println("Saissisez les position de la piece");
        Scanner sc = new Scanner(System.in);
        System.out.println("Saissisez la position x de la piece");
        position_x = sc.nextInt();
        System.out.println("Saissisez la position y de la piece");
        position_y = sc.nextInt();
        position.setValeur("X");
        position.setPos_x(position_x);
        position.setPos_y(position_y);

        grille.afficher();
    }
}
