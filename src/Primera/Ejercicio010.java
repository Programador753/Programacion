/*
Calcular el factorial de un número
 */
package Primera;

public class Ejercicio010 {
    public static void main (String arg[]){
        int numero = 5;
        int acum = 1;
        int desc = 1;
        for(int cont = 1; cont <= numero; cont++ )
            acum = acum * cont;
        System.out.println("El factorial de " + numero + " es " + acum);
        System.out.println(numero +"! = " + acum);
        
        for(int cont = numero; cont >= 1; cont-- )
            desc = desc * cont;
        System.out.println("El factorial de " + numero + " es " + desc);
        System.out.println(numero +"! = " + desc);
    }
    
}
