package Segunda.Ejercicio03;

public class Ejecutable {
    public static void main(String arg[]){
        Nif dni1;
        Nif dni2;
        
        dni1 = new Nif(17171717, 'D');
        dni2 = new Nif(17171717);
        
        dni1.mostrar();
        dni2.mostrar();
    }
}
