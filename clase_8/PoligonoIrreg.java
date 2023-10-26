import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class PoligonoIrreg {

    private static final int MAX_VERTICES = 20;
    private Coordenada[] vertices;
    private ArrayList<Coordenada> vertices_a;
    private int numVertices;

    public PoligonoIrreg() {
        this.vertices = new Coordenada[MAX_VERTICES];
        this.vertices_a = new ArrayList<Coordenada>();
        this.numVertices = 0;
    }

    public void anadeVertice(Coordenada vertice) {
        // if (numVertices < MAX_VERTICES) {
        //     this.vertices[numVertices++] = vertice;
        // } else {
        //     System.out.println("Se ha alcanzado el máximo de vértices para el polígono.");
        // }
        this.vertices_a.add(vertice);
    }

    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < numVertices; i++) {
    //         sb.append(vertices[i].toString()).append("\n");
    //     }
    //     return sb.toString();
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < numVertices; i++) {
        //     sb.append(vertices[i].toString()).append("\n");
        // }

        for (Coordenada vertice : vertices_a) {
            sb.append(vertice);
        }
        return sb.toString();
    }

    public double calculaArea() {
        double suma1 = 0, suma2 = 0;
        for (int i = 0; i < numVertices - 1; i++) {
            suma1 += vertices[i].abcisa() * vertices[i + 1].ordenada();
            suma2 += vertices[i + 1].abcisa() * vertices[i].ordenada();
        }
        suma1 += vertices[numVertices - 1].abcisa() * vertices[0].ordenada();
        suma2 += vertices[0].abcisa() * vertices[numVertices - 1].ordenada();
        return 0.5 * Math.abs(suma1 - suma2);
    }

    
}