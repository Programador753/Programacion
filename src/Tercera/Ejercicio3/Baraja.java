// hacer clase mano que sera una lista hacer en ese metodo constructor y recibir carta.
package Tercera.Ejercicio3;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;


public class Baraja {
    ArrayList<Carta> cartas;
    public Baraja(Image[] imgs){
        cartas = new ArrayList<Carta>();
        for(int i = 0; i < Blackjack.NUMCARTAS;i++)
            cartas.add(new Carta((i%Blackjack.CPP)+1,imgs[i]));
            Collections.shuffle(cartas);
    }
    public Carta sacarcarta(){
        Carta carta = cartas.get(0);
        cartas.remove(0);
        return carta;
        
        
    }

}
