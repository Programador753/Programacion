/*
Meter en cadena2 el contenido de frase, sustituyendo la subcadena1 
por la subcadena2.
 */
package Primera;

public class Ejercicio071 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char subcad1[] = {'E', 'n', ' '};
        char subcad2[] = {'X', 'X', 'X', 'X', 'X'};
        char cadena2[] = new char[150];
        
        int k = 0; 
  
        for (int i = 0; i < frase.length; i++) 
        {
            // Verificamos si hay una coincidencia con subcad1 
            if (i <= (frase.length - subcad1.length) && frase[i] == subcad1[0])
            {
                int j = 1; // inicializamos y delcaramos j  =  1 porque ya hemos verificado la posicion 0.
                while (j < subcad1.length && frase[i + j] == subcad1[j]) 
                // Mientras j sea menor que la longitud de la subcadena a buscar y coincidan los caracteres incrementamos j. 
                {
                    j++;
                }
                if (j == subcad1.length) // Si hay una coincidencia, añade la subcadena2
                {
                    for (int z = 0; z < subcad2.length; z++) // Recorremos la subcadena 
                    {
                        cadena2[k++] = subcad2[z]; // Incrementamos k mientras recorremos la subcadena 
                    }
                    i += subcad1.length - 1; // Avanza el índice i
                }
                else 
                {
                    // Si no coincide, copia el carácter actual y incrementamos k.
                    cadena2[k++] = frase[i];
                }
            }
            else
            {
                // Si el primer carácter no coincide, copia el carácter actual y incrementamos k.
                cadena2[k++] = frase[i];
            }
        }

        System.out.println(cadena2); // Imprimo la cadena resultante.
    }
}