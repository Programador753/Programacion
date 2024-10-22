/*
Método de ordenación en una función 
 */
package Primera;

public class Ejercicio049 {
    public static void main(String arg[]){
        int vector[] = { 25, 2, 73, 81, 16, 4, 33};
        ordenar(vector);
        
        for(int i = 0; i < vector.length; i++)
            System.out.print(vector[i] + " ");
    }
    public static void ordenar(int v1[]){
        int inter;
        for(int j=0; j<v1.length-1; j++)
            for(int i=v1.length-1; i>j; i--)
                if(v1[i] <v1[i-1]){
                    inter = v1[i];
                    v1[i] = v1[i-1];
                    v1[i-1] = inter;
            }
    }
}
