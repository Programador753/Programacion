/*
Metodo de ordenacion de un vector por selección directa
{25} {2} {73} {85} {16} {4} {33}
 */
package Primera;

public class Ejercicio043 {
    public static void main(String arg[]){
        int vector[]= { 25, 2, 73, 81, 16, 4, 33};
        int inter;

        for(int i=0; i < vector.length-1; i++){
            int posmin = i;      
            for(int j=i+1; j < vector.length; j++)
                if(vector[j] < vector[posmin])
                    posmin = j;
            inter = vector[posmin];
            vector[posmin] = vector[i];
            vector[i] = inter;
        }
    }
}
