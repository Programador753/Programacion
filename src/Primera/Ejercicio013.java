/*
Division con restas
 */
package Primera;

public class Ejercicio013 {
    public static void main (String arg[]){
        int divisor = 2;    
        int dividendo = 8;  
        int acum = 0;       
        int residuo = dividendo; 

        for (; residuo >= divisor; residuo -= divisor) 
            acum++;

        System.out.println("El cociente de dividir " + dividendo + " entre " + divisor + " es: " + acum);
        System.out.println("El residuo es: " + residuo);
    }
}
