/*
Implementar una funcion que devuelva el valor máximo de un vector.
 */
package Primera;

public class Ejercicio046 {
    public static void main(String arg[]){
        int vector[]= { 25, 2, 73, 81, 16, 4, 33};
        System.out.printf("El valor maximo del vector es : %d\n",Maximo(vector));
    }
    
    public static int Maximo (int v1[]){
        int mayor = v1[0];
        for(int i=0; i < v1.length; i++)
            if(v1[i] > mayor)
                mayor = v1[i];
        return (mayor);
    }
}
