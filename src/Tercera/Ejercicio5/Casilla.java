package Tercera.Ejercicio5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle {    
    public static final int TAM = 17; // Tamaño de la casilla
    private Image mina; // Imagen de la mina
    Image reverso; // Imagen del reverso de la mina
    private boolean tapada; // Indica si la mina está oculta o no
    private int alrededor; // Número de minas alrededor de la casilla

    public Casilla(int posX, int posY, Image rev) {
        super(posX, posY, TAM, TAM); // Inicializa la casilla con su posición y tamaño
        reverso = rev;
        tapada = true; // Inicialmente la mina está tapada
        alrededor = 0; // Inicialmente no hay minas alrededor

    }   

    public Image getMina() {
        return mina;
    }

    public void setMina(Image mina) {
        this.mina = mina;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }

    // Metodo paint
    public void paint(Graphics g, Applet applet) {
        // Dibuja el fondo de la casilla
        g.setColor(Color.BLACK); // Establece el color de fondo

        // Dibuja el contorno de la casilla
        g.drawRect(x, y, width, height);
        // Si la mina está tapada, dibuja el reverso de la mina
        if (tapada) {
            g.drawImage(reverso, x, y, applet); // Dibuja el reverso de la mina
        } else if (mina != null) {
            // Si la mina no está tapada, dibuja la mina
            g.drawImage(mina, x, y, applet); // Dibuja la mina
        } else {
            g.drawString("" + alrededor, x + 4, y + 13); // Dibuja el número de minas alrededor
        }
    }
}
