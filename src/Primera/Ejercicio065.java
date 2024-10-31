/*
Invertir orden de las palabras 
nE nu ragul ed al ahcnaM
 */
package Primera;

public class Ejercicio065 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char intercambio;
        int inicio, fin;
        inicio = fin = 0;
        
        while(fin < frase.length){
            while(frase[fin] != ' ')
                fin++;
            for(int i = 0; i <= ((fin - inicio)/2); i++){
                intercambio = frase[inicio];
                frase[inicio] = frase[fin-i-1];
                frase[fin-i-1] = intercambio;
                inicio++;            
            }
            inicio = fin = fin+1;
        }
        System.out.println(frase);
    }
}
        /*
        for(int i = 0; i <= frase.length; i++){
            if (i == frase.length || frase[i] == ' '){
                fin = i - 1;
                
                while (inicio < fin)
                {
                    char temp = frase[inicio];
                    frase[inicio] = frase[fin];
                    frase[fin] = temp;
                    inicio++;
                    fin--;
                }
                inicio = i + 1;
            }
        }   
        System.out.println(frase);
    }
}
*/
