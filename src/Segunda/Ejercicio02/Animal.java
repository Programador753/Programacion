package Segunda.Ejercicio02;
/* 
Cuando no se quiera permitir instanciar objetos de esa clase se declara como 
abstracta con el modificador abstract y no se podran crear objeto de esa clase.
El modificador abstract tambien se puede aplicar a un metodo para declararlo sin tener que instanciar
e implica obligatoriedad de implementar el metodo "habla" en la clase.
*/
abstract class Animal {
    int ID;
    String fnac;
    boolean vacunado;
    private String nombre;

    public Animal(int ID, String fnac, boolean vacunado, String nombre) { // Metodo Constructor clase Animal
        this.ID = ID;
        this.fnac = fnac;
        this.vacunado = vacunado;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    abstract void habla();
    
}
