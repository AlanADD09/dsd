//Proyecto 2 -- Alan Axel Dominguez Duran -- 4CM12
import java.util.ArrayList;
import java.util.Random;

public class Asteroide extends PoligonoIrreg {
    private ArrayList<Coordenada> vertices;
    private int numVertices;

    public Asteroide(int n){
        this.vertices = new ArrayList<Coordenada>();
        this.numVertices = n;
    }

    public ArrayList<Coordenada> getVertices(){
        return this.vertices;
    }

    public void generarVertices(){
        double anguloTotal = 0;
        Coordenada verticeAnterior = null;
        for (int i = 0; i < this.numVertices; i++) {
            Coordenada verticeActual;
            do {
                double x = rand(0, 500);
                double y = rand(0, 500);
                verticeActual = new Coordenada(x, y);
                if (verticeAnterior != null) {
                    double angulo = calcularAngulo(verticeAnterior, verticeActual);
                    if (anguloTotal + angulo > 360) {
                        verticeActual = null;
                    } else {
                        anguloTotal += angulo;
                    }
                }
            } while (verticeActual == null);
            this.vertices.add(verticeActual);
            verticeAnterior = verticeActual;
        }
    }
    
    private double calcularAngulo(Coordenada verticeAnterior, Coordenada verticeActual) {
        double dx = verticeActual.abcisa() - verticeAnterior.abcisa();
        double dy = verticeActual.ordenada() - verticeAnterior.ordenada();
        double angulo = Math.atan2(dy, dx);
        if (angulo < 0) {
            angulo += 2 * Math.PI;
        }
        return Math.toDegrees(angulo);
    }

    public double calcularPerimetro() {
        double perimetro = 0;
        Coordenada verticeAnterior = vertices.get(numVertices - 1);
        for (Coordenada verticeActual : vertices) {
            double distancia = Math.sqrt(Math.pow(verticeActual.abcisa() - verticeAnterior.abcisa(), 2) +
                                         Math.pow(verticeActual.ordenada() - verticeAnterior.ordenada(), 2));
            perimetro += distancia;
            verticeAnterior = verticeActual;
        }
        return perimetro;
    }

    public static double rand(double minimo, double maximo) {
        Random random = new Random();
        return minimo + (maximo - minimo) * random.nextDouble();
    }

}
