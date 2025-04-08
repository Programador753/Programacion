package Tercera.Ejercicio6;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;
import java.util.ArrayList;


public class Ficha extends Rectangle {

    public static final int DIM = 76;
    public Image fichaImage;
    public int precio;
    
    ArrayList<Integer> lCasillas; // Lista para almacenar los números de las casillas

    // Constructor de la clase Ficha
    public Ficha(int x, int y, int v, Image fichaImage) {
        super(x, y, DIM, DIM);
        this.fichaImage = fichaImage;
        this.precio = v;
        lCasillas = new ArrayList<Integer>(); // Inicializa la lista de casillas
    }

    public void paint(Graphics g, Applet applet) {
        g.drawImage(fichaImage, x, y, width, height, applet);
    }

    // Método para mover la ficha
    public void mover(int PosX, int PosY) {
        x = PosX - (DIM / 2);
        y = PosY - (DIM / 2);
    }
    // Método para añadir una casilla a la lista de casillas
    public void cargarApostados(Casilla casillas[][]) {
        lCasillas.clear(); // Limpia la lista de casillas antes de cargar nuevas
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].intersects(this)) {
                    lCasillas.add(casillas[i][j].valor); // Añade el número de la casilla a la lista
                }
            }
        }
    }
}
