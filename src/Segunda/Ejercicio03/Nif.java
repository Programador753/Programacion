package Segunda.Ejercicio03;

public class Nif {
    public int dni;
    public char letra;
    public final char tabla[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public Nif(int dni, char letra) {
        this.dni = dni;
        this.letra = letra;
    }

    public Nif(int dni) {
        this.dni = dni;
        this.letra = tabla[(dni%23)];
    }
    
    public void mostrar() {
        System.out.printf("El Nif con numero %d tiene la letra %s\n", dni, letra);
    }
}
