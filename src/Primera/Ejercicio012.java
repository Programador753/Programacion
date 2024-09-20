/*
Cálculo de variaciones matemáticas
Variaciones de tantos elementos tomadas de tantos en tantos
 */
package Primera;

public class Ejercicio012 {
    public static void main (String arg[]){
        int elemento = 7; // Número de elementos 
        int toma = 4;     // Elementos tomados de tantos en tantos 
        int acum = 1;     // Variable para acumular el resultado de la variación
        for (int cont = 0; cont < toma; cont++) 
            acum *= (elemento - cont);       
        System.out.println("Las variaciones de " + elemento + " elementos tomados de " + toma + " en " + toma + " son: " + acum);
    }
}