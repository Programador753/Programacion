/* Clase abstracta, aqui NO DEFINIMOS ATRIBUTOS SOLO SE DEFINEN METODOS
Esta clase abstracta proporciona la funcionalidad básica para todos los tipos de mazos en el juego. 
Cada subclase debe implementar su propia lógica para añadir cartas (anadir) y recolocarlas (recolocar).
*/
package Tercera.Ejercicio8;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Mazo extends Rectangle {
    ArrayList<Carta> cartas;
    
    public Mazo(int posX, int posY, int anchura, int altura) { // Constructor
        super(posX, posY, anchura, altura);
        cartas = new ArrayList<Carta>();
    }
    // Getter y Setter
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    // Método para dibujar el mazo y sus cartas
    public void paint(Graphics g, Applet app) { 
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        for(Carta carta : cartas)
            carta.paint(g, app);
    }
    // Métodos abstractos que deben implementar las subclases
    public abstract boolean anadir(Carta carta);
    public abstract void recolocar();
    
    // Método para obtener la carta superior sin extraerla
    public Carta extraer() {
        return cartas.get(cartas.size() - 1);
    }
    
    // Método para eliminar la carta superior
    public void eliminar() {
        cartas.remove(cartas.size() - 1);
    }
}