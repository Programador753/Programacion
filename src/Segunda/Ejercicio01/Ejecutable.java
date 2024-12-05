package Segunda.Ejercicio01;

public class Ejecutable {
    public static void main(String arg[]){
        Casa casa1, casa2; // Casa es una clase y defino que casa1 es un objeto de la clase Casa. 
        
        casa1 = new Casa("C/. María Auxiliadora nº 59", 1200, "Ladrillo", 200); // Instancio y cargo valores en el objeto casa1 de la clase Casa.
        casa2 = new Casa("Plaza del Pilar Nº1", 2000, "Piedra"); // Instancio y cargo valores en el objeto casa2 de la clase Casa.
        
        System.out.println(casa2.getDireccion()); // Devuelvo la direecion con getDireccion creado en la clase Casa.
    }
}
// Al llamar al getDireccion lo llamo a traves del objeto  
