/*
Dividir el numero en sus diferentes medidas 
 */
package Primera;

public class Ejercicio095 {
    public static String medidas[] = {"Unidades", "Decenas", "Centenas", "Unidades de Millar", "Decenas de Millar", "Centenas de Millar"};
    public static void main (String arg[]){
        descomponer(256809, 0);
    }
    public static void descomponer (int numero, int i){
        if( numero > 0)
        {
            descomponer((numero / 10), i+1);
            System.out.println((numero % 10) + " " + medidas[i]);
        }
    }
}
