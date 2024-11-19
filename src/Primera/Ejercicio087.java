/*
Meter una 'a' despues de cada palabra sabiendo que cada palabra se separa de la 
siguiente con un espacio en blanco.
 */
package Primera;

public class Ejercicio087 {
    public static void main(String arg[]) {
        String frase1 = "Había una vez, un circo, que alegraba siempre el corazón ";
        
        //frase1 = frase1.replace(" ", "a ");
        //System.out.println(frase1);
        
       
       int posicion = frase1.indexOf(" ");
        while(posicion != -1){
            frase1 = frase1.substring(0, posicion).concat("a").concat(frase1.substring(posicion));
            posicion = frase1.indexOf(" ", posicion+2);
        }
        System.out.println(frase1);  
    }
}
