package mates;
import java.util.Random;

public class Matematicas {
    /**
     * Genera una aproximación al número Pi mediante el método de
     * Montecarlo. El parámetro `pasos` indica el número de puntos
     * generado.
     */
    public static double generarNumeroPiRecursivo(long pasos) {
        return generarNumeroPiRecursivoAux(pasos, 0, 0);
    }
    
    private static double generarNumeroPiRecursivoAux(long pasos, long puntosDentroCirculo, long totalPuntos) {
        // Caso base: cuando hemos generado todos los puntos
        if (totalPuntos == pasos) {
            return 4.0 * puntosDentroCirculo / pasos;
        }
        
        // Generar un punto aleatorio
        Random rand = new Random();
        double x = rand.nextDouble(); // Genera un punto aleatorio en el eje x
        double y = rand.nextDouble(); // Genera un punto aleatorio en el eje y

        // Calcula la distancia desde el origen (0,0)
        double distancia = Math.sqrt(x * x + y * y);

        // Comprueba si el punto está dentro del círculo (radio=1)
        if (distancia <= 1) {
            puntosDentroCirculo++;
        }
        
        // Llamada recursiva para generar el siguiente punto
        return generarNumeroPiRecursivoAux(pasos, puntosDentroCirculo, totalPuntos + 1);
    }
}

