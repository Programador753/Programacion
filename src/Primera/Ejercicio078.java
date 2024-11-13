/*
Ordenar el nombres en orden alfabético.
La comparacion es una resta y segun el resultado sabemos si ambos son iguales ya que si da 0 son iguales.
Si es negativo el primero es inferior al segundo
Si es 0 son iguales.
Si es positivo el primero es mayor que el segundo.
 */
package Primera;

public class Ejercicio078 {
    public static void main(String arg[]) {
        String nombres[] = {"Pepe", "Juan", "María", "Antonio", "Luisa"};
        String inter;
        
        for(int i=0; i<nombres.length-1; i++)
            for(int j=nombres.length-1; j>i; j--)
                if(nombres[j].compareTo(nombres[j-1]) < 0){
                    inter = nombres[j];
                    nombres[j] = nombres[j-1];
                    nombres[j-1] = inter;
            }
        for(int j=0; j<nombres.length; j++)
        System.out.println(nombres[j]);
    }    
}
