package Segunda.Ejercicio03;

public class Ejecutable {
    public static void main(String arg[]) throws Exception {
        Nif dni1;
        Nif dni2;
        
        dni1 = new Nif(17171717, 'D');
        dni2 = new Nif(17171717);
        
        dni1.mostrar();
        dni2.mostrar();
        
        try // Inicio de tratamiento de excepciones
        {
            System.out.println("Hola" + (20/0));
        }
        catch(ArithmeticException e) // definir excepcion a tratar
        {
            System.out.println("Se a producido un ERROR");
        }

    }
}
// Hay ciertas clases de java que te obliiga a someterla a tratamiento de excepciones