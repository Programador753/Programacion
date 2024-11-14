/*
Recorer alternativamente frase1 y frase2 para cargar en frase3.
 */
package Primera;

public class Ejercicio085 {
    public static void main(String arg[]) {
        String frase1 = "Había vez circo alegraba el sin temer jamás ";
        String frase2 = "una un que siempre corazón ";
        String frase3 = "";
        
        int inicio1 = 0;
        int inicio2 = 0;
        int fin1 = frase1.indexOf(" ");
        int fin2 = frase2.indexOf(" ");
            
        while((fin1 != -1 && fin2 != -1)){
            frase3 = frase3.concat(frase1.substring(inicio1,fin1) + " ");
            frase3 = frase3.concat(frase2.substring(inicio2,fin2) + " ");
            inicio1 = fin1+1;
            inicio2 = fin2+1;
            fin1 = frase1.indexOf(" ", inicio1);
            fin2 = frase2.indexOf(" ", inicio2);
        }
        if(frase1.length() - inicio1 == 0)
            frase3 = frase3.concat(frase2.substring(inicio2));
        else
            frase3 = frase3.concat(frase1.substring(inicio1));
        
        System.out.println(frase3);
    }   
}
