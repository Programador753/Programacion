/*
Funciones o métodos
 */
package Primera;

public class Ejercicio045 {
    public static void main(String arg[]){
        String Palabras;
        escribir();
        hablar("Buenos días");
        animalHabla("Me llamo Toby", "Guau, guau");
        Palabras = concatenar("En un lugar ", "de La Mancha");
        System.out.println(Palabras);
        suma(1,2);
    }
    
    public static void escribir(){
        System.out.println("Hola");
    }
    public static void hablar(String frase){
        System.out.println(frase);
    }
    public static void animalHabla(String frase, String onomatopeya){
        System.out.println(frase + " : " + onomatopeya);
    }
    public static String concatenar(String frase1, String frase2){
        System.out.println();
        return (frase1 + frase2); //Cuando se ejecuta el return la funcion termina.
    }
    public static void suma (int numero1, int numero2){
        System.out.println(numero1 + numero2);
    }
}
// En una funcion se puede implementar mas de un return pero no se aconlseja.
//