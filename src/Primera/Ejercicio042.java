/*
Metodo de ordenacion de la burbuja 
{25} - 0
{2}  - 1
{73} - 2
{85} - 3
{16} - 4
{4} - 5
{33} - 6
*/
package Primera;

public class Ejercicio042 {
    public static void main(String arg[]){
        int vector[]= { 25, 2, 73, 81, 16, 4, 33};
        int inter;
        
        for(int j=0; j<vector.length-1; j++)
            for(int i=vector.length-1; i>j; i--)
                if(vector[i] < vector[i-1]){
                    inter = vector[i];
                    vector[i] = vector[i-1];
                    vector[i-1] = inter;
            }        
    }
}
