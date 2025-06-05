/* Piezas, que constarán de un número y un color de fondo, cada número está relacionado con un color. El número máximo es el 10.
 * El número máximo es el 10.
 * El color lo asocio con un número del array de colores. */


package AntonioHernandezCaveroTerceraProgramacion;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Pieza {
    public int x, y; // Posición de la pieza
    private int ancho; // Ancho de la pieza
    private int numero; // Número de la pieza (del 1 al 10)
    private Color colorFondo; // Color de fondo de la pieza
    
    // Array de colores para asociar a cada número (del 1 al 10)
    private static final Color[] COLORES = {
        new Color(255, 200, 200), // 1 - Rojo claro
        new Color(255, 255, 200), // 2 - Amarillo claro
        new Color(200, 255, 200), // 3 - Verde claro
        new Color(200, 200, 255), // 4 - Azul claro
        new Color(255, 200, 255), // 5 - Púrpura claro
        new Color(200, 255, 255), // 6 - Cian claro
        new Color(255, 150, 150), // 7 - Rojo más intenso
        new Color(255, 255, 150), // 8 - Amarillo más intenso
        new Color(150, 255, 150), // 9 - Verde más intenso
        new Color(150, 150, 255)  // 10 - Azul más intenso
    };
    
    public Pieza(int x, int y, int ancho, int numero) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        setNumero(numero); // Establecer el número y el color apropiado
    }
    
    // Establecer el número y actualizar el color
    public void setNumero(int numero) {
        // Asegurar que el número esté entre 1 y 10
        this.numero = Math.max(1, Math.min(10, numero));
        // Establecer el color correspondiente al número
        this.colorFondo = COLORES[this.numero - 1];
    }
    
    // Incrementar el número en 1 y actualizar el color
    public void incrementarNumero() {
        if (numero < 10) { // No incrementar si ya está en el máximo
            numero++;
            this.colorFondo = COLORES[numero - 1];
        }
    }
    
    // Obtener el número actual
    public int getNumero() {
        return numero;
    }
    
    // Establecer la posición
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Verificar si un punto (x, y) está dentro de la pieza
    public boolean contains(int px, int py) {
        return px >= x && px < x + ancho && py >= y && py < y + ancho;
    }
    
    // Dibujar la pieza
    public void paint(Graphics g, Applet applet) {
        // Dibujar el fondo
        g.setColor(colorFondo);
        g.fillRect(x, y, ancho, ancho);
        
        // Dibujar el borde
        g.setColor(Color.black);
        g.drawRect(x, y, ancho, ancho);
        
        // Dibujar el número
        g.setColor(Color.black);
        g.drawString(Integer.toString(numero), x + ancho/2 - 5, y + ancho/2 + 5);
    }
}
