/*
Modificar el vector de tal manera que todos los elementos del vector se muevan una posicion a la izq y el
primero al final.
Mover todos los elementos una posicion a la izq y  el primero al final
 */
package Primera;

public class Ejercicio020 {
    public static void main(String arg[]) {
        int datos[] = {10, 20, 30, 40, 50};
        int primerElemento = datos[0];
        for (int i = 1; i < datos.length; i++) 
            datos[i - 1] = datos[i];
        
        datos[datos.length - 1] = primerElemento;
        for (int i = 0; i < datos.length; i++) 
            System.out.println(datos[i]);
    }
}
