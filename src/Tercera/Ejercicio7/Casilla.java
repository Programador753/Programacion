package Tercera.Ejercicio7;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int DIM = 180; // Dimensiones de la casilla
    private boolean descubierta; // Indica si la casilla es visible o no
    private Image imagen; // Imagen de la casilla
    Image reverso; // Imagen del reverso de la casilla
    

    public Casilla(int posX, int posY, Image img1, Image img2) {
        super(posX, posY, DIM, DIM); // Llama al constructor de Rectangle con las dimensiones de la casilla
        imagen = img1; // Establece la imagen de la casilla
        reverso = img2; // Establece la imagen del reverso de la casilla
        descubierta = false; // Inicializa la visibilidad de la casilla como no visible
    }

    public boolean isDescubierta() {
        return descubierta; // Devuelve si la casilla es visible o no
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta; // Establece la visibilidad de la casilla
    }

    public Image getImagen() {
        return imagen; // Devuelve la imagen de la casilla
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen; // Establece la imagen de la casilla
    }

    
    public void paint(Graphics g, Applet applet) {
        if (descubierta) { // Si la casilla es visible
            g.drawImage(imagen, x, y, width, height, applet); // Dibuja la imagen de la casilla
        } else { // Si la casilla no es visible
            g.drawImage(reverso, x, y, width, height, applet); // Dibuja la imagen del reverso de la casilla
        }
        g.setColor(Color.BLACK); // Establece el color de la casilla
        g.drawRect(x, y, width, height); // Dibuja el borde de la casilla
    }
}
