public class Position {
    private String valeur;
    private int pos_x;
    private int pos_y;
    Position() {
        valeur = "O";
        pos_x = 0;
        pos_y = 0;
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
}
