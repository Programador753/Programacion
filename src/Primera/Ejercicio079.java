/*
Metodo substring de la clase String.
 */
package Primera;

public class Ejercicio079 {
    public static void main(String arg[]) {
        String frase = "En un lugar de La Mancha, de cuyo nombre no quiero acordarme";
        int inicio = 7;
        int fin = 17;
        
        System.out.println( "La subcadena contiene: " + frase.substring(inicio, fin));
        
        for(int i=1; i< frase.length();i++)
            System.out.printf("%s\n", frase.substring(0, i+1));
    }
}
