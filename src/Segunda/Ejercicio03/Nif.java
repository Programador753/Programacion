package Segunda.Ejercicio03;

public class Nif {
    public int dni;
    public char letra;
    public final char tabla[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public Nif(int dni, char letra) throws Exception{
        this.dni = dni;
        if(letra != tabla[dni%23])
            throw new Exception("Has calculado mal la letra");
        this.letra = letra;
    }

    public Nif(int dni) {
        this.dni = dni;
        this.letra = tabla[dni%23];
    }
    
    public void mostrar() {
        System.out.printf(" %d - %s\n", dni, letra);
    }
}
