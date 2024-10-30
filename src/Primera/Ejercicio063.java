/*
Sustituir un caracter por una cadena de caracteres, sin utilizar 
una cadena auxiliar.
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
        
        //modificar(frase2, sustituir, sustituto);
        
        int longitud = frase.length;
        int i = 0;
        while(i < longitud)
        {
            if(frase2[i] == sustituir)
            {
                frase2[i] = sustituto[0];
                for(int j=1; j < sustituto.length; j++)
                {
                    for(int x = longitud-1 ; x > i; x--)
                        frase2[x+1] = frase2[x];
                    longitud++;
                    frase2[i+j] = sustituto[j];
                }
            }
            i++;
        }  
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
                for (int x = 0; x < sustituto.length; x++) 
                {
                    cadena[i + x] = sustituto[x];
                }
                i += 2; 
            }
        }
    System.out.println(cadena);
    }       
}
