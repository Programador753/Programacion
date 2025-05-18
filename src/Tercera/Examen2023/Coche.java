package Tercera.Examen2023;

import java.awt.Graphics;
import java.awt.Image; // Importo la clase Image
import java.awt.Rectangle; // Importo la clase Graphics

public class Coche extends Rectangle{
    Image imagecoche; // Imagen del coche
    Image imageluz; // Imagen de la luz
    boolean encendida = false; // Luz encendida o apagada

    public Coche(Image imagecoche, Image imageluz) {
        super(20, 140, 250, 200); // Inicializo el rectángulo con la posición y tamaño del coche
        this.imagecoche = imagecoche;
        this.imageluz = imageluz;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }   

    public void turn(){
        encendida = !encendida; // Cambia el estado de la luz
    }

    public void paint(Graphics g) {
        g.drawImage(imagecoche, x, y, width, height, null); // Dibuja el coche
        if (encendida) { // Si la luz está encendida
            g.drawImage(imageluz, x + 220, y + 60, width / 2, height / 2, null); // Dibuja la luz
        }
    }
}