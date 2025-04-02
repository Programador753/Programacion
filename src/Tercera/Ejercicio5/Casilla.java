package Tercera.Ejercicio5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle {    
    public static final int TAM = 17; // Tamaño de la casilla
    private Image mina; // Imagen de la mina
    private Image bandera; // Imagen de la bandera
    Image reverso; // Imagen del reverso de la mina
    private boolean tapada; // Indica si la mina está oculta o no
    private int alrededor; // Número de minas alrededor de la casilla

    public Casilla(int posX, int posY, Image rev) {
        super(posX, posY, TAM, TAM); // Inicializa la casilla con su posición y tamaño
        reverso = rev;
        tapada = true; // Inicialmente la mina está tapada
        alrededor = 0; // Inicialmente no hay minas alrededor


    }
    
    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
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
    
        // Si la casilla está tapada
        if (tapada) {
            // Si tiene una bandera, dibuja la bandera escalada al tamaño de la casilla
            if (bandera != null) {
                g.drawImage(bandera, x, y, TAM, TAM, applet); // Escala la bandera a 17x17 píxeles
            } else {
                g.drawImage(reverso, x, y, TAM, TAM, applet); // Escala el reverso al tamaño de la casilla
            }
        } else if (mina != null) {
            // Si la casilla no está tapada y tiene una mina, dibuja la mina
            g.drawImage(mina, x, y, TAM, TAM, applet); // Escala la mina al tamaño de la casilla
        } else {
            // Si no hay mina, dibuja el número de minas alrededor
            g.drawString("" + alrededor, x + 4, y + 13); // Dibuja el número de minas alrededor
        }
    }
}
