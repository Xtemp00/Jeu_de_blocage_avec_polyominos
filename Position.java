/**
 * La classe Position représente une position dans un système de coordonnées cartésiennes.
 * Elle possède une valeur (par défaut "#") ainsi que deux coordonnées entières : pos_x et pos_y.
 */
public class Position {
     /**
     * La valeur de la position (par défaut "#").
     */
    private String valeur;
      /**
     * La coordonnée x de la position.
     */
    private int pos_x;
     /**
     * La coordonnée y de la position.
     */
    private int pos_y;
     /**
     * Constructeur par défaut de la classe Position.
     * Initialise la valeur à "#" et les coordonnées à (0,0).
     */
    Position() {
         /**
     * Retourne la valeur de la position.
     * @return la valeur de la position.
     */
        valeur = "#";
        pos_x = 0;
        pos_y = 0;
    }
      /**
     * Retourne la valeur de la position.
     * @return la valeur de la position.
     */
    public String getValeur() {
        return valeur;
    }
     /**
     * Modifie la valeur de la position.
     * @param valeur la nouvelle valeur de la position.
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
     /**
     * Retourne la coordonnée x de la position.
     * @return la coordonnée x de la position.
     */
    public int getPos_x() {
        return pos_x;
    }
      /**
     * Modifie la coordonnée x de la position.
     * @param pos_x la nouvelle coordonnée x de la position.
     */
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
      /**
     * Retourne la coordonnée y de la position.
     * @return la coordonnée y de la position.
     */
    public int getPos_y() {
        return pos_y;
    }
    /**
     * Modifie la coordonnée y de la position.
     * @param pos_y la nouvelle coordonnée y de la position.
     */
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
}
