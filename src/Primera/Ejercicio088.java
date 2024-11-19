/*
Eliminar exceso de espacios en blanco 
boolean -> tipo de dato
Boolean -> Clase
 */
package Primera;

public class Ejercicio088 {
    public static void main(String arg[]) {
        String frase1 = "Había              una                vez, un   circo,                   que alegraba siempre el            corazón ";
        String frase2 = "Había              una                vez, un   circo,                   que alegraba siempre el            corazón ";
        
        //frase1 = frase1.replaceAll(" +", "-");
        //System.out.println(frase1);
        
        int posicion = frase1.indexOf(" ");
        while(posicion != -1)
        {
            frase1 = frase1.substring(0, posicion).concat(frase1.substring(posicion+1));
            posicion = frase1.indexOf("  ", frase1.indexOf(" "));
        }
        System.out.println(frase1);
        
        boolean primero = true;
        int i = 0;
        while(i < frase2.length())
            if(frase2.charAt(i) == ' '){
                if(primero){
                    i++;
                    primero = false;
                }else{
                    frase2 = frase2.substring(0, i).concat(frase2.substring(i+1));
                }
            }else{
                i++;
                primero = true;
            }
        System.out.println(frase2);
    }
}
