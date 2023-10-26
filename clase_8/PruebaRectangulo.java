//PruebaRectangulo
import java.util.Random;
public class PruebaRectangulo {
    public static void main (String[] args) {
        // Rectangulo rect3 = new Rectangulo(2, 3, 5, 1);
        // System.out.println("Calculando el área de un rectángulo dadas sus coordenadas en un plano cartesiano:");
        // System.out.println(rect3);
        // rect3.area();
        // Rectangulo rect1 = new Rectangulo(2,3,5,1);
        // double ancho, alto;
        // System.out.println("Calculando el área de un rectángulo dadas sus coordenadas en un plano cartesiano:");
        // System.out.println(rect1);
        // alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();
        // ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();
        // System.out.println("El área del rectángulo es = " + ancho*alto);
        // Coordenada c1 = new Coordenada(2, 3);
        // Coordenada c2 = new Coordenada(5, 1);
        // rect1 = new Rectangulo(c1, c2);
        // alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();
        // ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();
        // System.out.println("El área del rectángulo es = " + ancho*alto);
        
        // //Código nuevo (Polígono Irregular):
        PoligonoIrreg poligono = new PoligonoIrreg();
        Random rand = new Random();
        double minValue = -100.00;
        double maxValue = 100.00;
        for (int i = 0; i < 10; i++) {
            double x = minValue + (maxValue - minValue) * rand.nextDouble();
            double y = minValue + (maxValue - minValue) * rand.nextDouble();
            Coordenada vertice = new Coordenada(x, y);
            System.out.println("Generando vértice: " + vertice);
            poligono.anadeVertice(vertice);
        }
        System.out.println("\nConjunto de vértices del polígono:\n" + poligono);
        // System.out.println("Área del polígono: " + poligono.calculaArea());
    }
}