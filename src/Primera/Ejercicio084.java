/*
Modificar frase, de manera que sus palabras (se separan por un 
espacio en blanco) queden ordenadas alfabéticamente.
 */
package Primera;

public class Ejercicio084 {
    public static void main(String arg[]) {
        String frase = "5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        String vector[];        
        int cont = 0;
        int posicion = frase.indexOf(" ");
        while(posicion != -1){
            cont++;
            posicion = frase.indexOf(" ", posicion+1);
        }
        vector = new String[cont];
        
        int fin = frase.indexOf(" ");
        int inicio = 0;
        int i = 0;
        while(fin != -1){
            vector[i] = frase.substring(inicio, fin);
            inicio = fin+1;
            fin = frase.indexOf(" ", fin+1);
            i++;
        }
        
        String inter;
        
        for(i=0; i<vector.length-1; i++)
            for(int j=vector.length-1; j>i; j--)
                if(vector[j].compareTo(vector[j-1]) < 0){
                    inter = vector[j];
                    vector[j] = vector[j-1];
                    vector[j-1] = inter;
            }
        frase = "";
        for(int j=0; j<vector.length; j++)
            frase += (vector[j] + " ");
        System.out.println(frase);
    }
}
