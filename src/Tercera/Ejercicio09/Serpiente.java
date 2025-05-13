
package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;

public class Serpiente {
    ArrayList<Eslabon> eslabones; // Declaramos la lista de eslabones
    
    public Serpiente(Image img){ // Constructor de la serpiente
        eslabones = new ArrayList<Eslabon>();  // Inicializamos la lista de eslabones
        for(int i = 0; i < 10; i++){ // Creamos 10 eslabones
            eslabones.add(new Eslabon(img, 200 - (Eslabon.TAM * i), 100, Eslabon.DERECHO)); // Creamos el eslabon

        }
    }

    public void paint(Graphics g, Applet a){ // Método para dibujar la serpiente
        for(Eslabon eslabon : eslabones){ // Recorremos la lista de eslabones
            eslabon.paint(g, a); // Dibujamos el eslabon
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
    }
    
    public void moverEslabon(){ // Método para mover el eslabon
        for(int i = eslabones.size() - 1; i > 0; i--){ // Recorremos la lista de eslabones
            Eslabon eslabon = eslabones.get(i); // Obtenemos el eslabon
            Eslabon anterior = eslabones.get(i - 1); // Obtenemos el eslabon anterior
            eslabon.setDireccion(anterior.getDireccion()); // Cambiamos la dirección del eslabon
        }
    }


}
