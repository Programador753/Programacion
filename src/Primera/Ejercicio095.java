/*
Dividir el numero en sus diferentes medidas y calcular binario de un numero 
 */
package Primera;

public class Ejercicio095 {
    public static void main (String arg[]){
        String medidas[] = {"Unidades", "Decenas", "Centenas", "Unidades de Millar", "Decenas de Millar", "Centenas de Millar"};
        int numero = 256809;

        descomponer(numero,medidas,1);
    }
    public static void descomponer (int numero, String medidas[], int i){
        if( i == medidas.length)
            System.out.println(numero%10 + " " + medidas[i-1]);
        else
        {
            descomponer(numero/10,medidas, i+1);
            System.out.println(numero%10 + " " + medidas[i-1]);
        }
    }
}
