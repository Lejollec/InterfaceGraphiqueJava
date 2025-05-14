
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceRectangle {
    private JFrame frame;
    private PanneauDessin panneau;
    private ArrayList<MonRectangle> rectangles = new ArrayList<>();

    public InterfaceRectangle() {
        rectangles.add(new MonRectangle(50, 50, 100, 60));
        rectangles.add(new MonRectangle(200, 80, 120, 80));
        rectangles.add(new MonRectangle(100, 200, 90, 70));

        frame = new JFrame("Gestion des Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panneau = new PanneauDessin(rectangles);
        frame.add(panneau, BorderLayout.CENTER);

        JPanel panelForm = new JPanel(new GridLayout(0, 2));
        JTextField[] fields = new JTextField[4];
        String[] labels = {"X:", "Y:", "Largeur:", "Hauteur:"};

        for (int i = 0; i < 4; i++) {
            panelForm.add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            panelForm.add(fields[i]);
        }

        JButton btnUpdate = new JButton("Mettre à jour Rectangle 1");
        JLabel surfaceLabel = new JLabel("Surface: ");
        JLabel perimetreLabel = new JLabel("Périmètre: ");
        btnUpdate.addActionListener(e -> {
            try {
                int x = Integer.parseInt(fields[0].getText());
                int y = Integer.parseInt(fields[1].getText());
                int l = Integer.parseInt(fields[2].getText());
                int h = Integer.parseInt(fields[3].getText());
                MonRectangle r = rectangles.get(0);
                r.setX(x); r.setY(y); r.setLargeur(l); r.setHauteur(h);
                surfaceLabel.setText("Surface: " + r.surface());
                perimetreLabel.setText("Périmètre: " + r.perimetre());
                panneau.refresh();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Valeurs invalides");
            }
        });

        panelForm.add(btnUpdate);
        panelForm.add(new JLabel());
        panelForm.add(surfaceLabel);
        panelForm.add(perimetreLabel);

        // Ajout d’un nouveau rectangle
        JTextField xField = new JTextField(); JTextField yField = new JTextField();
        JTextField lField = new JTextField(); JTextField hField = new JTextField();
        JButton addButton = new JButton("Ajouter rectangle");
        addButton.addActionListener(e -> {
            try {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                int l = Integer.parseInt(lField.getText());
                int h = Integer.parseInt(hField.getText());
                rectangles.add(new MonRectangle(x, y, l, h));
                panneau.refresh();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Valeurs invalides");
            }
        });

        panelForm.add(new JLabel("X (new):")); panelForm.add(xField);
        panelForm.add(new JLabel("Y (new):")); panelForm.add(yField);
        panelForm.add(new JLabel("Largeur:")); panelForm.add(lField);
        panelForm.add(new JLabel("Hauteur:")); panelForm.add(hField);
        panelForm.add(addButton);
        panelForm.add(new JLabel());

        frame.add(panelForm, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceRectangle::new);
    }
}
