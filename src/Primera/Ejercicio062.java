/*
Implementar un metodo que reciba una cadena de caracteres y 
sustituya en ella un caracter por otra cadena de carcteres.
Lo haremos sobre una cadena de caracteres auxiliar.
 */
package Primera;

public class Ejercicio062 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir = 'n';
        char sustituto[] = {'X', 'X', 'V'};
        
        System.out.println(modificar(frase, sustituir, sustituto));
    }
    public static char[] modificar (char cadena[], char sustituir, char sustituto[]){
        int x = 0;
        char nueva[] = new char [180];
        for (int i = 0; i < cadena.length; i++)
            if (cadena[i] == sustituir){
            for (int j = 0; j < sustituto.length; j++)
            {
                nueva[i+x] = sustituto[j];
                i++;
                
            }
            x += sustituto.length-1;
            i -= sustituto.length;
            }
            else
                nueva[i+x] = cadena[i];
        return nueva;
        }
}
