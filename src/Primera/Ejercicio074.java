/*
Eliminar cadena de caracteres de otra cadena tantas veces como aparezca
 */
package Primera;

public class Ejercicio074 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'E', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char subcad1[] = {'E', 'n', ' '};
        int longitud = frase.length;
        
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
                    for( int z = 0; z < subcad1.length; z++){
                        for(int x = i; x < longitud-1; x++)
                            frase[x] = frase[x+1];
                        frase[longitud-1] = ' ';
                        longitud--;
                    }
            }
        }
        System.out.println(frase);
    }
}
