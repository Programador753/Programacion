/*
Cálculo de variaciones matemáticas
Variaciones de tantos elementos tomadas de tantos en tantos
\n -> Secuencia de escape en este caso retorno de carro (Salto de linea)
 */
package Primera;

public class Ejercicio012 {
    public static void main (String arg[]){
        int numero = 6; // Número de elementos 
        int tomados = 4;     // Elementos tomados de tantos en tantos 
        int acum = 1;     // Variable para acumular el resultado de la variación
        for (int valor = numero; valor > tomados; valor--) 
            acum *= valor;       
        System.out.printf("Variaciones de %d elementos tomados de %d en %d son %d\n", numero, tomados, tomados, acum);
    }
}