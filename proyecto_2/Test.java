import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test extends JFrame {
    private ArrayList<Asteroide> asteroides;
    private boolean finished;

    public static void main(String[] args) {
        Test gui = new Test();
        gui.setVisible(true);
    }

    public Test() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        add(p);
        asteroides = new ArrayList<>();
        Random rand = new Random();
        int numAsteroides = 2;
        for (int i = 0; i < numAsteroides; i++) {
            asteroides.add(new Asteroide(rand.nextInt(10) + 1));
        }
        finished = false;
        Timer timer = new Timer(1000, e -> {
            if (!finished) {
                if (asteroides.size() > 0) {
                    Asteroide asteroide = asteroides.remove(0);
                    asteroide.generarVertices();
                    asteroides.add(asteroide);
                    repaint();
                } else {
                    finished = true;
                    Collections.sort(asteroides, Comparator.comparingDouble(Asteroide::calcularPerimetro));
                    repaint();
                }
            }
        });
        timer.start();
    }

    private class Panel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (!finished) {
                if (asteroides.size() > 0) {
                    Asteroide asteroide = asteroides.get(asteroides.size() - 1);
                    g.setColor(Color.blue);
                    Polygon poligono = new Polygon();
                    for (Coordenada vertice : asteroide.getVertices()) {
                        poligono.addPoint((int) vertice.abcisa(), (int) vertice.ordenada());
                    }
                    g.drawPolygon(poligono);
                }
            } else {
                int x = getWidth() / 2;
                int y = getHeight() / 2;
                int size = asteroides.size() * 50;
                for (Asteroide asteroide : asteroides) {
                    g.setColor(Color.blue);
                    Polygon poligono = new Polygon();
                    for (Coordenada vertice : asteroide.getVertices()) {
                        poligono.addPoint((int) vertice.abcisa() + x - size / 2, (int) vertice.ordenada() + y - size / 2);
                    }
                    g.drawPolygon(poligono);
                }
            }
        }
    }
}