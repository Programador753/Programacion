package Segunda.Ejercicio10;

import java.awt.Canvas; // Importo clase Canvas
import java.awt.Event; // Importo clase Event
import java.awt.Graphics; // Importo clase Graphics
import java.util.ArrayList; // Importo clase ArrayList
import java.util.List; // Importo clase lista

public class MiCanvas extends Canvas{ // Clase MiCanvas extendida de Canvas
    private List<DosPuntos> lista; // Objeto de la clase lista 
    DosPuntos actual; // Objeto de la clase DosPuntos 
    private int tipo; // Variable de tipo entero para almacenar el tipo de figura a dibujarç

    public MiCanvas(int tipo) { // Metodo constructor de MiCanvas
        super(); // Se llama al constructor de la superclase
        this.tipo = tipo; // Se asigna el valor de tipo a la variable de clase tipo
        lista = new ArrayList<DosPuntos>(); // Se instancia un objeto de la clase ArrayList
    }
    
    public int getTipo() { // Metodo para obtener el valor de la variable de clase tipo
        return tipo; // Se retorna el valor de la variable de clase tipo
    }
    
    public void setTipo(int tipo) { // Metodo para asignar un valor a la variable de clase tipo
        this.tipo = tipo; // Se asigna el valor de tipo a la variable de clase tipo
    }
    
    public List<DosPuntos> getLista() { // Metodo para obtener el valor de la variable de clase lista
        return lista; // Metodo para obtener el valor de la variable de clase lista
    }

    public void setLista(List<DosPuntos> lista) { // Metodo para asignar un valor a la variable de clase lista 
        this.lista = lista; // Se asigna el valor de lista a la variable de clase lista 
    }
    
    public void paint(Graphics g){ // Metodo para pintar en el canvas
        if(actual != null)// Si el objeto actual es diferente de nulo
            actual.dibujar(g); // Se llama al metodo dibujar del objeto actual con el objeto Graphics
        for(int i = 0; i< lista.size(); i++) // Bucle para recorrer la lista 
            lista.get(i).dibujar(g); // Se llama al metodo dibujar del objeto en la posicion i de la lista con el objeto Graphics
    }
    
    public boolean mouseDown(Event ev, int x, int y){ // Metodo para cuando se presiona el boton del mouse 
        actual = new DosPuntos(x, y, tipo); // Se crea un objeto de la clase DosPuntos con los valores de x, y y el objeto Graphics
        return true; // Se retorna verdadero 
    }
    
    public boolean mouseDrag(Event ev, int x, int y){ // Metodo para cuando se arrastra el mouse para modificar los valores de X e Y
        actual.finX = x; // Se asigna el valor de x a la variable de clase finX 
        actual.finY = y; // Se asigna el valor de y a la variable de clase finY
        repaint(); // Llamada al metodo paint
        return true; // Se retorna verdadero
    }
    
    public boolean mouseUp(Event ev, int x, int y){ // Metodo para guardar el elemento en la lista 
        lista.add(actual); // Se añade el objeto actual a la lista
        actual = null; // Vacio actual 
        return true; // Se retorna verdadero
    }
}
