/*
Función replace
Función indexOf
 */
package Primera;

public class Ejercicio080 {
    public static void main(String arg[]) {
        String frase = "En un lugar lugar de La Mancha, de cuyo nombre no quiero acordarme";
        frase = frase.replace('a', 'X');
        System.out.println(frase);
        
        frase = frase.replace("lugXr", "sitio");
        System.out.println(frase);
        
        System.out.printf("La palabra se encuentra en la posición %d\n", frase.indexOf("sitio"));
        
        int cont = 0;
        int posicion = frase.indexOf("sitio");
        while(posicion != -1){
            cont++;
            System.out.printf("Encontrado en la poscion: %d\n", posicion);
            posicion = frase.indexOf("sitio", posicion+1);
            
        }
        System.out.printf("La palabra se encuentra un total de %d veces\n",cont);
    }
}
