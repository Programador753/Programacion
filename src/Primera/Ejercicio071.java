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

        for(int i = 0; i < frase.length ; i++)
        {
            if(subcad1[0] == frase[i])
            {
                int j = 1;
                while((j < subcad1.length) && (frase[i + j] == subcad1[j]))
                {
                    j++;
                }
                if (j == subcad1.length)
                {
                    for(int z = 0; z < subcad2.length; z++)
                        cadena2[k++] = subcad2[z]; // k++ es post incrementativo porque primero se usa el valor y luego se incrementa el valor.
                    i += (subcad1.length-1); // Modifico el indice i 
                }
                else
                    cadena2[k++] = frase[i]; // Cargo el valor correspondiente de frase en cadena2 y incremento k.
            }
            else
            {
                cadena2[k++] = frase[i]; // Cargo el valor correspondiente de frase en cadena2 si no coincide el primer caracter
            } 
        }
        System.out.println(cadena2); // Imprimo la cadena resultante.
    }
}