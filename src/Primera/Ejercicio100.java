/*
Ejercicio 3 
En una variable introducir un numero de 3 cifras y mostrar por pantalla ese mismo numero pero con letras
 */
package Primera;

public class Ejercicio100 {
    public static String unidades[][] = {
                                {"", "y uno", "y dos", "y tres", "y cuatro", "y cinco", "y seis", "y siete", "y ocho", "y nueve"},
                                {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"},
                                {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"}
                              };
    public static void main(String[] arg) {
        letras(437, 0);
    }
    public static void letras (int numero, int i){
        if (numero > 0){
            letras((numero / 10), i+1);
            System.out.print(unidades[i][(numero % 10)] + " ");
        }  
    }
}
