package Segunda.Ejercicio10;

import java.awt.Canvas; // Importo clase Canvas
import java.awt.Event; // Importo clase Event

public class MiCanvas extends Canvas{ // Clase MiCanvas extendida de Canvas
    DosPuntos actual; // Objeto de la clase DosPuntos 
    private int tipo; // Variable de tipo entero para almacenar el tipo de figura a dibujarç

    public MiCanvas() { // Metodo constructor de MiCanvas
        super(); // Se llama al constructor de la superclase
        this.tipo = tipo; // Se asigna el valor de tipo a la variable de clase tipo
    }
    public int getTipo() { // Metodo para obtener el valor de la variable de clase tipo
        return tipo; // Se retorna el valor de la variable de clase tipo
    }
    public void setTipo(int tipo) { // Metodo para asignar un valor a la variable de clase tipo
        this.tipo = tipo; // Se asigna el valor de tipo a la variable de clase tipo
    }
    public boolean mouseDown(Event ev, int x, int y){ // Metodo para cuando se presiona el boton del mouse 
        actual = new DosPuntos(x, y, tipo); // Se crea un objeto de la clase DosPuntos con los valores de x, y y el objeto Graphics
        return true; // Se retorna verdadero 
    }
    public boolean mouseDrag(Event ev, int x, int y){ // Metodo para cuando se arrastra el mouse para modificar los valores de X e Y
        actual.finX = x; // Se asigna el valor de x a la variable de clase finX 
        actual.finY = y; // Se asigna el valor de y a la variable de clase finY
        return true; // Se retorna verdadero
    }

}
