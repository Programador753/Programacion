/*
Realiza una funcion que reciba una cadena de caracteres y devuelva el numero de palabras que contienen al menos una vocal
 */
package Primera;

public class Ejercicio101 {
    public static void main(String[] arg) {
        char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        String frase = "En un lugar de La Mancha ";
        
        System.out.printf("Hay %d de palabras con vocales\n", vocales(cadena));
        
        System.out.printf("Hay %d de palabras con vocales\n", vocales2(frase));
    }
    public static int vocales (char cadena[]){
        char vocales[] = {'a', 'e', 'i', 'o', 'u'};
        int contador = 0;
        int palabras = 0;
        for (int i = 0; i < cadena.length; i++){
            if ((cadena[i] == ' ') && contador > 0){
                contador = 0;
                palabras++;
            }
            for (int j = 0; j < vocales.length; j++)
                if ((Character.toLowerCase(cadena[i])) == vocales[j])
                    contador++;
            }
        return palabras;
    }
    public static int vocales2 (String frase){
        char vocales[] = {'a', 'e', 'i', 'o', 'u'};
        int contador = 0;
        int palabras = 0;
        
        for (int i = 0; i < frase.length(); i++){
            if ((frase.charAt(i) == ' ') && contador > 0){
                contador = 0;
                palabras++;
            }
            for (int j = 0; j < vocales.length; j++)
                if ((Character.toLowerCase(frase.charAt(i))) == vocales[j])
                    contador++;
            }
        return palabras;
    }
}
