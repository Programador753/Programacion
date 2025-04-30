package Tercera.Ejercicio8;

import java.awt.Graphics;
import java.util.ArrayList;

public class MazoSecundario {
    private ArrayList<Carta> cartas;
    private int x, y; // Position of the secondary deck

    public MazoSecundario(int x, int y) {
        this.cartas = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public void agregarCarta(Carta carta) {
        carta.setPosition(x, y);
        cartas.add(carta);
    }

    public Carta extraerUltimaCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(cartas.size() - 1);
        }
        return null;
    }

    public void recolocarCarta(Carta carta) {
        carta.setPosition(x, y);
        cartas.add(carta);
    }

    public void paint(Graphics g) {
        if (!cartas.isEmpty()) {
            Carta ultimaCarta = cartas.get(cartas.size() - 1);
            ultimaCarta.paint(g);
        }
    }

    // New method to check if the deck is empty
    public boolean isEmpty() {
        return cartas.isEmpty();
    }
}