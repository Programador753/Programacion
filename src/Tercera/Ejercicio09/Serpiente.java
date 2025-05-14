
package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Event;


public class Serpiente {
    ArrayList<Eslabon> eslabones; // Declaramos la lista de eslabones

    public Serpiente(Image img){ // Constructor de la serpiente
        eslabones = new ArrayList<Eslabon>();  // Inicializamos la lista de eslabones
        for(int i = 0; i < 10; i++){ // Creamos 10 eslabones
            eslabones.add(new Eslabon(img, 200 - (Eslabon.TAM * i), 100, Event.RIGHT)); // Creamos el eslabon
        }
    }

    public void paint(Graphics g, Applet a) { // Sobrescribimos el método paint
        for (Eslabon eslabon : eslabones) { // Dibujamos la serpiente
            eslabon.paint(g, a);
        }
    }
   
    public void agregarEslabon(Image img){ // Método para agregar un eslabon
        int direccion = ultimoEslabon().getDireccion(); // Obtenemos la dirección del último eslabon
        switch (direccion) { // Cambiamos la dirección del eslabon
            case Event.UP:
                eslabones.add(new Eslabon(img, (int) ultimoEslabon().getX(), (int) ultimoEslabon().getY() + Eslabon.TAM, direccion));
                break;
            case Event.DOWN:
                eslabones.add(new Eslabon(img, (int) ultimoEslabon().getX(), (int) ultimoEslabon().getY() - Eslabon.TAM, direccion));
                break;
            case Event.RIGHT:
                eslabones.add(new Eslabon(img, (int) ultimoEslabon().getX() - Eslabon.TAM, (int) ultimoEslabon().getY(), direccion));
                break;
            case Event.LEFT:
                eslabones.add(new Eslabon(img, (int) ultimoEslabon().getX() + Eslabon.TAM, (int) ultimoEslabon().getY(), direccion));
                break;
        }
    }

    public void cambiarDireccion(int direccion){ // Método para cambiar la dirección de la serpiente
        this.primerEslabon().setDireccion(direccion);
    }

    public Eslabon primerEslabon(){ // Método para obtener el primer eslabon
        return eslabones.get(0); // Devolvemos el primer eslabon
    }

    public Eslabon ultimoEslabon(){ // Método para obtener el último eslabon
        return eslabones.get(eslabones.size() - 1); // Devolvemos el último eslabon
    }

    public void update(){ // Método para actualizar la serpiente
        for(Eslabon eslabon : eslabones){ // Recorremos la lista de eslabones
            eslabon.update(); // Actualizamos el eslabon
        }
        moverEslabon(); // Movemos el eslabon
    }
        
    public void moverEslabon(){ // Método para mover el eslabon
        for(int i = eslabones.size() - 1; i > 0; i--){ // Recorremos la lista de eslabones
            Eslabon eslabon = eslabones.get(i); // Obtenemos el eslabon
            Eslabon anterior = eslabones.get(i - 1); // Obtenemos el eslabon anterior
            eslabon.setDireccion(anterior.getDireccion()); // Cambiamos la dirección del eslabon
        }
    }

}
