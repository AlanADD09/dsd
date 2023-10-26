//Figura
public abstract class Figura {
    protected int numeroLados;
    public Figura(int numeroLados) {
        this.numeroLados = numeroLados;
    }
    public abstract void area();
}