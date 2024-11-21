/*
Repartir las palabras de frase1 alternativamente en fraseA y fraseB.
 */
package Primera;

public class Ejercicio089 {
    public static void main(String arg[]) {
        String frase1 = "Había una vez un circo ";
        String fraseA = "";
        String fraseB = "";

        int inicio = 0;
        int fin = frase1.indexOf(" ");
        boolean palabra = true;

        while (fin != -1) {
            if (palabra) {
                fraseA = fraseA.concat(frase1.substring(inicio, fin + 1));
            } else {
                fraseB = fraseB.concat(frase1.substring(inicio, fin + 1));
            }
            inicio = fin + 1;
            fin = frase1.indexOf(" ", inicio);
            palabra = !palabra;
        }
        System.out.println(fraseA);
        System.out.println(fraseB);
    }
}
