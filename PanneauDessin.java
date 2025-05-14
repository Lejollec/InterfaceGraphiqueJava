
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanneauDessin extends JPanel {
    private List<MonRectangle> rectangles;

    public PanneauDessin(List<MonRectangle> rectangles) {
        this.rectangles = rectangles;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MonRectangle rect : rectangles) {
            g.setColor(Color.BLUE);
            g.fillRect(rect.getX(), rect.getY(), rect.getLargeur(), rect.getHauteur());
            g.setColor(Color.BLACK);
            g.drawRect(rect.getX(), rect.getY(), rect.getLargeur(), rect.getHauteur());
        }
    }

    public void refresh() {
        repaint();
    }
}
