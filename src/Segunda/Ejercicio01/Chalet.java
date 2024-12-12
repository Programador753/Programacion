package Segunda.Ejercicio01;
// Clausula extends
public class Chalet extends Casa{
    int numJardin;
    boolean piscina;

    public Chalet(String direccion, double nm, String material, int nH,int numJardin, boolean piscina) {
        super(direccion, nm, material, nH);
        this.numJardin = numJardin;
        this.piscina = piscina;
    }
    public Chalet(String direccion, double nm, String material,int numJardin, boolean piscina) {
        super(direccion, nm, material);
        this.numJardin = numJardin;
        this.piscina = piscina;
    }
    public void mostrar(){
        super.mostrar();
        if(piscina)
            System.out.println("Tiene piscina");
        System.out.printf("Y además tiene %d metros de jardín\n", numJardin);
    }
    
}
