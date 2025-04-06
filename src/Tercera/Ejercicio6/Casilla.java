package Tercera.Ejercicio6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle {

    public static final int DIM = 85; // Dimensiones de la casilla
    int valor; // Valor de la casilla
    Color color; // Color de la casilla

    public Casilla(int x, int y, int valor, Color color) {
        super(x, y, DIM, DIM); // Llama al constructor de Rectangle con las dimensiones de la casilla
        this.color = color; // Establece el color de la casilla
        this.valor = valor; // Establece el valor de la casilla
    }

    public void paint(Graphics g) {
        g.setColor(Color.black); // Establece el color del borde
        g.drawRect(x, y, width, height); // Dibuja el borde de la casilla
        g.setFont(new Font("TimesRoman", Font.BOLD, 24)); // Establece la fuente
        g.setColor(color); // Establece el color de la casilla
        g.fillOval(x + 5, y + 5, width - 10, height - 10); // Dibuja la casilla
        g.setColor(Color.WHITE); // Establece el color del texto
        g.drawString(String.valueOf(valor), x + 30, y + 50); // Dibuja el valor de la casilla

    }
}
