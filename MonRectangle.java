
public class MonRectangle {
    private int x, y, largeur, hauteur;

    public MonRectangle(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getLargeur() { return largeur; }
    public int getHauteur() { return hauteur; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setLargeur(int largeur) { this.largeur = largeur; }
    public void setHauteur(int hauteur) { this.hauteur = hauteur; }

    public int surface() {
        return largeur * hauteur;
    }

    public int perimetre() {
        return 2 * (largeur + hauteur);
    }
}
