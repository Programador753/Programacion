package Tercera.Examen2023;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


public class Pedal extends Rectangle {
    Image imgPedal;

    public Pedal(Image img, int x, int y, int width, int height) {
        super(x, y, width, height); // Inicializa el rectángulo con la posición y tamaño del pedal
        imgPedal = img; // Asigna la imagen del pedal
    }

    public void paint(Graphics g) {
        g.drawImage(imgPedal, x, y, width, height, null); // Dibuja el pedal
    }

    public void acelerar() {
        if(Juego.velocidad > 10 ) Juego.velocidad -= 10; // Acelera el coche
    }

    public void frenar() {
        if(Juego.velocidad < 200) Juego.velocidad += 10; // Frenar el coche
    }

}
