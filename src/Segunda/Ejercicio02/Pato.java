package Segunda.Ejercicio02;

public class Pato extends Animal{
    double tamanoPico;

    public Pato(double tamanoPico, int ID, String fnac, boolean vacunado, String nombre) {
        super(ID, fnac, vacunado, nombre);
        this.tamanoPico = tamanoPico;
    }

    public void habla(){
        System.out.printf("Cuac, cuac, soy un pato, el pico me mide %.1f cts., nací el %s y me llamo %s\n", tamanoPico, fnac, this.getNombre());
    }
    
}
