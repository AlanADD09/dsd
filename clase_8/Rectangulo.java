//Rectangulo
public class Rectangulo extends Figura{
    private Coordenada superiorIzq, inferiorDer;
    public Rectangulo(double xSupIzq, double ySupIzq, double xInfDer, double yInfDer) {
        super(4); // Un rectángulo tiene 4 lados
        superiorIzq = new Coordenada(xSupIzq, ySupIzq);
        inferiorDer = new Coordenada(xInfDer, yInfDer);        
    }
    public Rectangulo(Coordenada A, Coordenada B){
        super(4); // Un rectángulo tiene 4 lados
        superiorIzq = A;
        inferiorDer = B;
    }
    //Metodo getter de la coordenada superior izquierda
    public Coordenada superiorIzquierda( ) { return superiorIzq; }
    //Metodo getter de la coordenada inferior derecha
    public Coordenada inferiorDerecha( ) { return inferiorDer; }
    @Override
    public void area() {
        double ancho = inferiorDer.abcisa() - superiorIzq.abcisa();
        double alto = superiorIzq.ordenada() - inferiorDer.ordenada();
        System.out.println("El área del rectángulo es = " + ancho * alto);
        System.out.println("Número de lados: " + numeroLados);
    }
    //Sobreescritura del método de la superclase objeto para imprimir con System.out.println( )
    @Override
    public String toString( ) {
        return "Esquina superior izquierda: " + superiorIzq + "\tEsquina superior derecha:" + inferiorDer + "\n";
    }
}