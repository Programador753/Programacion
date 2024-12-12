package Segunda.Ejercicio02;

public class Ejecutable {
    public static void main(String arg[]){
        Perro animal1;
        Pato animal2;
        
        animal1 = new Perro("Salchicha", true, 120, "12/11/2024", true, "Tintín");
        animal2 = new Pato(1.2, 121, "10/11/2024", false, "Donald");
        
        animal1.habla();
        animal2.habla();
        
        
    }
}
