class Rectangle {
    int longueur;
    int largeur;
    int origin_x;
    int origin_y;

    void deplace(int x, int y) {
        this.origin_x = this.origin_x + x;
        this.origin_y = this.origin_y + y;
    }
    
    public class Main {
        public static void main(String[] args){
            Rectangle rect = new Rectangle(15, 5);

            Rectangle(int longueur, int largeur) {
                this.longueur = lon;
                this.largeur = lar;
                this.origin_x = 0;
                this.origin_y = 0;     
            }
            int surface() {
                return longueur * largeur;
            }
        }
    }
}