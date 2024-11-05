/*
Cargar frase 2 con el contenido de frase1, sustituyendo cada
caracter por la subCadena.
 */
package Primera;

public class Ejercicio067 {
    public static void main(String arg[]){
        char frase1[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char caracter = 'a';
        char subCadena[] = {'A', 'B', 'C', 'D', 'E'};
        char frase2[] = new char[150];

        
        for (int i = 0, j = 0; i < frase1.length; i++ , j++)
            if (frase1[i] != caracter)
                frase2[j] = frase1[i];
            
            else
            {
                for (int z = 0; z < subCadena.length; z++)
                    frase2[j++] = subCadena[z];// j++ es postincrementativo es decir que se incrementa despues de usarse.
                j--;
            }        
        System.out.println(frase2);
    }
}
