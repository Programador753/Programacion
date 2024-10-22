/*
Implementar una funcion que devuelva el valor máximo de un vector.
 */
package Primera;

public class Ejercicio046 {
    public static void main(String arg[]){
        int vector[]= {24, 45, 65, 12, 7, 123, 16, 50};
        int vector2[]= {4, 49, 165, 12, 17, 123, 16, 50};
        System.out.printf("El valor máximo del primer vector es : %d\n",Maximo(vector));
        System.out.printf("El valor máximo del segundo vector es : %d\n",Maximo(vector2));
    }
    
    public static int Maximo (int v1[]){
        int mayor = v1[0];
        for(int i=0; i < v1.length; i++)
            if(v1[i] > mayor)
                mayor = v1[i];
        return (mayor);
    }
}
