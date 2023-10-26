//Proyecto 2 -- Alan Axel Dominguez Duran -- 4CM12
import java.util.ArrayList;

public class PoligonoIrreg {

    private ArrayList<Coordenada> vertices_a;
    // private int numVertices;

    public PoligonoIrreg() {
        this.vertices_a = new ArrayList<Coordenada>();
        // this.numVertices = 0;
    }

    public void anadeVertice(Coordenada vertice) {
        this.vertices_a.add(vertice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coordenada vertice : vertices_a) {
            sb.append(vertice);
        }
        return sb.toString();
    }
    
}