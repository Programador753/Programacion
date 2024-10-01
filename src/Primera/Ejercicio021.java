/*
Desplazar los elementos del vector una posicion a la derecha 
y el ultimo pasa al primero.
 */
package Primera;

public class Ejercicio021 {
    public static void main(String arg[]) {
        int datos[] = {10, 20, 30, 40, 50};
        int ultimoElemento = datos[datos.length - 1];
            for (int i = datos.length - 1; i > 0 ; i--)
                datos[i] = datos[i - 1];
            datos[0] = ultimoElemento;
    }
}
