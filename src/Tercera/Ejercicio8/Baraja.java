/*
La línea clave aquí es la del constructor donde se crean las cartas. Para cada imagen:

El valor es (i%Solitario.CPP)+1, lo que da valores del 1 al 13 (As al Rey)
El color se determina según el palo: picas y tréboles son negros (palos 0 y 3), 
mientras que diamantes y corazones son rojos (palos 1 y 2)
El palo se calcula con (i/Solitario.CPP), dando valores de 0 a 3 
*/
package Tercera.Ejercicio8;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;
    
    
    public Baraja(Image imagenes[]) { // Constructor que inicializa la baraja con imágenes
        cartas = new ArrayList<Carta>();
        // Crea cartas basadas en las imágenes proporcionadas
        for(int i=0; i<imagenes.length; i++)
            cartas.add(new Carta(imagenes[i], (i%Solitario.CPP)+1, ((i/Solitario.CPP==0)||(i/Solitario.CPP==3))?Carta.NEGRO:Carta.ROJO, (i/Solitario.CPP)));
        Collections.shuffle(cartas); // Baraja las cartas aleatoriamente
    }
    
    // Método para sacar una carta de la baraja
    public Carta sacarCarta() {
        return cartas.remove(0);
    }

    // Getters y setters
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
}

