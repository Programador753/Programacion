/*
Dividir el numero en sus diferentes medidas y calcular binario de un numero 
 */
package Primera;

public class Ejercicio095 {
    public static void main (String arg[]){
        String medidas[] = {"Unidades", "Decenas", "Centenas", "Unidades de Millar", "Decenas de Millar", "Centenas de Millar"};
        int numero = 256809;
        
        descomponer(numero,medidas);
    }
    public static void descomponer (int numero, String medidas[]){
        if(medidas.length > 0){
            medidas.length-1:
            descomponer(numero,medidas);
            
            System.out.println(medidas[medidas.length-1] + " " + numero%10 );
            numero /= 10;
        }
        
        
    }
}
