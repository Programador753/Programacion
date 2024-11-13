/*
Función charAt
Mostrar por pantalla cuántas 'a' hay en frase.
 */
package Primera;

public class Ejercicio081 {
    public static void main(String arg[]) {
        String frase[] ={ "En un lugar", "lugar de La Mancha", ",de cuyo nombre", "no quiero acordarme"};
        int cont = 0;
        char caracter = 'a';
        for (int i = 0; i < frase.length; i++)
            for (int j = 0; j < frase[i].length(); j++)
                if (frase[i].charAt(j) == caracter){
                    cont++;
                    
                }
        System.out.printf("El caracter '%s' esta %d veces en frase\n", caracter, cont);
    }
}
