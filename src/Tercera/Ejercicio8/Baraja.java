// hacer clase mano que sera una lista hacer en ese metodo constructor y recibir carta.
package Tercera.Ejercicio8;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    ArrayList<Carta> cartas;

    public Baraja(Image[] imgs, Image reverso) {
        cartas = new ArrayList<Carta>();
        for (int i = 0; i < Solitario.NUMCARTAS; i++) {
            cartas.add(new Carta(imgs[i], ((i % Solitario.CPP) + 1), ((i / Solitario.CPP == 0) || (i / Solitario.CPP == 3)) ? Carta.ROJO : Carta.NEGRO, i / Solitario.CPP));
        }
        Collections.shuffle(cartas); // Baraja las cartas al azar
        
    }

    public Carta sacarcarta() {
        Carta carta = cartas.get(0);
        cartas.remove(0);
        return carta;
    }
}
