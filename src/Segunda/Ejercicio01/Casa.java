package Segunda.Ejercicio01;

public class Casa {
    private String direccion; // Atributo Dirección con private para encapsular impidiendo que puedas acceder desde otras clases.
    private double numMetros; // Atributo Numero Metros
    private String material; // Atributo Material
    private int numHabitaciones; // Atributo Numero Habitaciones
    public Casa(String direccion, double nM, String material, int nH) // Metodo constructor 
    {
        this.direccion = direccion; // Para hacer referencia a un atributo global de la clase publica usamos this.atributo
        numMetros = nM;
        this.material = material;
        this.numHabitaciones = nH;
    }   
    public Casa(String direccion, double nM, String material) // Metodo constructor 
    {
        this.direccion = direccion; 
        numMetros = nM;
        this.material = material;
        this.numHabitaciones = 1;
    }
    
    public String getDireccion() // Metodo para devolver la direccion de la casa.
    {
        return this.direccion; // El this es el objeto mediante el que llamas al metodo.
    }
    
    public void setDireccion(String nuevaDireccion) // Metodo para modificar la direccion de la casa.
    {
         direccion = nuevaDireccion;
    }
    
    public double getMetros() // Metodo para devolver el numero de metros de la casa.
    {
        return numMetros;
    }
    
    public void setMetros(double nMetros ) // Metodo para modificar el numeros de metros de la casa.
    {
         numMetros = nMetros;
    }
    
    public String getMaterial() // Metodo para devolver el material de la casa.
    {
        return this.material; 
    }
    
    public void setMaterial(String Material) // Metodo para modificar el material de la casa.
    {
         material = Material;
    }    

    public int getHabitaciones() // Metodo para devolver el numero de habitaciones de la casa.
    {
        return numHabitaciones;
    }
    
    public void setMetros(int Habitaciones) // Metodo para modificar el numeros de habitaciones de la casa.
    {
         numHabitaciones = Habitaciones;
    }     
    
    public void mostrar()
    {
        System.out.printf("Dirección : %s, número de metros : %.2f, material : %s, número de habitaciones : %d\n", direccion, numMetros, material, numHabitaciones);
    }
}
