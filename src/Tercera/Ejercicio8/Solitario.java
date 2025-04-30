package Tercera.Ejercicio8;

import java.applet.Applet;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;

public class Solitario extends Applet {
    public static final int NUMCARTAS = 52;
    public static final int CPP = 13;
    public static final int NUM_PALOS = 4;
    Image imagen;
    Graphics noseve;
    Image imagenes[];
    Image reverso;
    Baraja baraja;
    MazoSecundario mazoSecundario;
    Carta cartaArrastrada;

    @Override
    public void init() {
        String palos[] = {"clubs", "diamonds", "hearts", "spades"};
        imagen = this.createImage(1920, 1080);
        noseve = imagen.getGraphics();

        imagenes = new Image[NUMCARTAS];

        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/" + (i % CPP) + "_of_" + palos[i / CPP] + ".png");
        }

        reverso = this.getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/reverso.png");

        baraja = new Baraja(imagenes, reverso);
        mazoSecundario = new MazoSecundario(100, 100);

        this.setSize(1920, 1080);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        noseve.setColor(Color.green.darker());
        noseve.fillRect(0, 0, 1920, 1080);

        noseve.drawImage(reverso, 10, 10, this);

        mazoSecundario.paint(noseve);

        g.drawImage(imagen, 0, 0, this);
    }

    public boolean mouseDown(MouseEvent evt, int x, int y) {
        if (x >= 10 && x <= 10 + Carta.ANCHO && y >= 10 && y <= 10 + Carta.ALTO) {
            Carta carta = baraja.sacarcarta();
            if (carta != null) {
                mazoSecundario.agregarCarta(carta);
                repaint();
            }
        } else if (cartaArrastrada == null && !mazoSecundario.isEmpty()) {
            Carta ultimaCarta = mazoSecundario.extraerUltimaCarta();
            if (ultimaCarta.contains(x, y)) {
                cartaArrastrada = ultimaCarta;
            }
        }
        return true;
    }

    public boolean mouseDrag(MouseEvent evt, int x, int y) {
        if (cartaArrastrada != null) {
            cartaArrastrada.setPosition(x - Carta.ANCHO / 2, y - Carta.ALTO / 2);
            repaint();
        }
        return true;
    }

    public boolean mouseUp(MouseEvent evt, int x, int y) {
        if (cartaArrastrada != null) {
            mazoSecundario.recolocarCarta(cartaArrastrada);
            cartaArrastrada = null;
            repaint();
        }
        return true;
    }
}