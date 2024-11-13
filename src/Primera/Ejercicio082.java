/*
Reemplazar una subcadena por ellla misma en mayúsculas.
 */
package Primera;

public class Ejercicio082 {
    public static void main(String arg[]) {
        String frase[] ={ "en un lugar", "lugar de La Mancha,", "de cuyo nombre", "no quiero acordarme"};
        String subCadena = "en";
        
        for (int i = 0; i < frase.length; i++)
                frase[i] = frase[i].replace(subCadena, subCadena.toUpperCase());
        
        frase[0] = frase[0].concat("HOLA");
        for (int j = 0; j < frase.length; j++)
                System.out.print(frase[j] + " ");
        System.out.println();
    }    
}
