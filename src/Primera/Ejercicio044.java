/*

 */
package Primera;

public class Ejercicio044 {
    public static void main(String arg[]){
        int vector[]= { 25, 2, 73, 81, 16, 4, 33};
        int inter; 

        for (int i = 1; i < vector.length; i++) {
            inter = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > inter) {
                vector[j + 1] = vector[j];  
                j--;
            }
            vector[j + 1] = inter;
        }
    }
}