/*
Modificar los caracteres de una cadena, de manera que las 
vocales se conviertan de mínusculas a mayúsculas y viceversa.
El resto de los caracteres se sustituyen por '-'
 */
package Primera;

public class Ejercicio076 {
    public static void main(String arg[]) {
        char cadena[] = {'E', 'n', ' ', 'U', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};

        for(int i=0; i < cadena.length; i++)
            switch(cadena[i]){
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    cadena[i] = Character.toLowerCase(cadena[i]);
                    break;
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    cadena[i] = Character.toUpperCase(cadena[i]);
                    break;
                default:
                    cadena[i] = '-';
            }
        System.out.println(cadena);
    }
}
