//Proyecto 2 -- Alan Axel Dominguez Duran -- 4CM12
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleGui2 extends JFrame {
    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.setVisible(true);
    }

    public SimpleGui2() {
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        add(p);
    }

    private class Panel extends JPanel {
        private ArrayList<Asteroide> asteroides;
    
        public Panel() {
            int num_asteroides = 10;
            asteroides = new ArrayList<Asteroide>();
            for (int i = 0; i < num_asteroides; i++) {
                Asteroide asteroide = new Asteroide(rand(3, 10));
                asteroide.generarVertices();
                asteroides.add(asteroide);
            }
        }
    
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            for (Asteroide asteroide : asteroides) {
                Polygon poligono = new Polygon();
                for (Coordenada vertice : asteroide.getVertices()) {
                    int x = (int) vertice.abcisa() + rand(-100, 100);
                    int y = (int) vertice.ordenada() + rand(-100, 100);
                    poligono.addPoint(x, y);
                }
                g.drawPolygon(poligono);
            }
            ordenarAsteroides(asteroides);
        }
    }

    public static void ordenarAsteroides(ArrayList<Asteroide> objetos) {
        Collections.sort(objetos, new NumeroComparator());
    }

    private static class NumeroComparator implements Comparator<Asteroide> {
        @Override
        public int compare(Asteroide a, Asteroide b) {
            return Double.compare(a.calcularPerimetro(), b.calcularPerimetro());
        }
    }

    public static int rand(int minimo, int maximo) {
        Random random = new Random();
        return random.nextInt(maximo - minimo + 1) + minimo;
    }
}