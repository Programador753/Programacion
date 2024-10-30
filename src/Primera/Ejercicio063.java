/*
desplazar los caracteres 2 posiciones a la derecha para poder cambiar la n por la cadena de caracteres.
 */
package Primera;

public class Ejercicio063 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z'};
        char frase2[] = new char[100];

        for(int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        
        modificar(frase2, sustituir, sustituto);
        
        System.out.println(frase2);
    }
    public static void modificar(char cadena[], char sustituir, char sustituto[])
    {
        for (int i = 0; i < cadena.length; i++)
        {
            if (cadena[i] == sustituir) 
            {
                for (int j = (cadena.length - sustituto.length); j > i; j--)
                {
                    cadena[j + (sustituto.length-1)] = cadena[j];
                }
                for (int j = 0; j < sustituto.length; j++) 
                {
                    cadena[i + j] = sustituto[j];
                }
                i += 2; 
            }
        }
    }
}
