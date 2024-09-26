/*
Invertir orden de los valores de un vector.
 */
package Primera;

public class Ejercicio017 {
    public static void main(String arg[]){
        int datos[] = {10, 20, 30, 40, 50};
        int auxiliar; 
        for(int i = 0; i <(datos.length / 2); i++)
        {
            auxiliar = datos[i];
            datos[i] = datos[datos.length - i - 1];
            datos[datos.length - i - 1] = auxiliar;  
        }
        //Ahora resta mostrar por pantalla
        for(int i = 0; i < datos.length; i++)
            System.out.println(datos[i]);
    }
}
