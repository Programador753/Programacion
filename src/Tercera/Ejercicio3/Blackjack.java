package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;

public class BlackJack extends Applet implements Runnable {

    public static final int TIEMPO = 50;
    public static final int NUMCARTAS = 52;
    public static final int CPP = 13;
    Image imagenes[];
    Image imagen;
    Graphics noseve;
    Rectangle tablero[][];
    Baraja baraja;
    Mano crupier;
    Mano jugador;
    String palos[] = {"clubs", "diamonds", "hearts", "spades"};
    Button boton1 = new Button("Otra carta");
    Button boton2 = new Button("Paso");
    Panel panel = new Panel();
    TextField apuesta;

    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[NUMCARTAS];

        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio3/Cartas/" + (i % CPP) + "_of_" + palos[i / CPP] + ".png");
        }

        baraja = new Baraja(imagenes);
        crupier = new Mano(50);
        jugador = new Mano(300);
        Panel primerPanel = new Panel();
        Label etiqueta = new Label("Introduce tu apuesta : ", Label.RIGHT);
        apuesta = new TextField("", 10);
        primerPanel.add(etiqueta);
        primerPanel.add(apuesta);
        this.add("North", primerPanel);

        panel.add(boton1);
        panel.add(boton2);
        this.add("South", panel);
        this.resize(700, 500);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);

        crupier.paint(noseve, this);
        jugador.paint(noseve, this);

        g.drawImage(imagen, 0, 0, this);

    }

    public void run() {
        do {

            repaint();

            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public boolean action(Event ev, Object obj) {
        if (ev.target instanceof TextField) {
            apuesta.setEditable(false);
            crupier.anadirCarta(baraja.sacarcarta());
            jugador.anadirCarta(baraja.sacarcarta());
            jugador.anadirCarta(baraja.sacarcarta());
            repaint();
            return true;
        }
         else if (ev.id == Event.ACTION_EVENT) {
            if (ev.target instanceof Button) {
                if (ev.arg.equals("Otra carta")) {
                    jugador.anadirCarta(baraja.sacarcarta());
                    
                    repaint();
                    return true;
                } else if (ev.arg.equals("Paso")) {
                    while (crupier.getValor() < 17) {
                        crupier.anadirCarta(baraja.sacarcarta());
                    }
                    
                    repaint();
                    return true;
                }
            }
        }
        return false;
    }
}

