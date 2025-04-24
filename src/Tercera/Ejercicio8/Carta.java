package Tercera.Ejercicio8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle {
    public static final int ANCHO = 70;
    public static final int ALTO = 120;
    public static final int ROJO = 1;
    public static final int NEGRO = 2;
    public static final int PICAS = 0;
    public static final int ROMBOS = 1;
    public static final int TREBOLES = 2; 
    public static final int CORAZONES = 3; 
    Image imagen;
    private int valor;
    private int color;
    private int palo;

    public Carta(Image img, int valor, int color, int palo) {
        super(-200, -200, ANCHO, ALTO);
        this.imagen = img;
        this.valor = valor;
        this.color = color;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public int getColor() {
        return color;
    }

    public int getPalo() {
        return palo;
    }

    public void paint(Graphics g) {
        g.drawImage(imagen, x, y, ANCHO, ALTO, null);
    }

    public void update(int PosX, int PosY) { // Metodo para mover las cartas 

        this.x = PosX;
        this.y = PosY;
    }


}

