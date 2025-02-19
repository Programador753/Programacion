package Segunda.Ejercicio17;


import java.awt.Color; // Importo clase Color
import java.awt.Graphics; // Importo clase Graphics
import java.awt.Rectangle; // Importo clase Rectangle

public class Dinosaurio extends Rectangle{ // Clase Dinosaurio extendida de rectangle
    public static final int TOPE = 170; // Variable para el tope del dinosaurio
    public int velY = -1; // Variable para la velocidad en Y del dinosaurio
    private  boolean saltando = false; // Variable booleana para saber si el dinosaurio esta saltando
    
    public Dinosaurio() { // Constructor de la clase dinosaurio
        super(20, 230, 20, 50);  // Posicion y tamaño del dinosaurio 
    }
    
    public void dibujar(Graphics g){ // Metodo para dibujar el dinosaurio 
        g.setColor(Color.black); // Color negro
        g.fillRect(x, y, width, height); // Dibujamos el dinosaurio 
    }

    public boolean isSaltando() { // Metodo booleano para saber si esta saltando 
        return saltando; // Retorno el estado de saltando
    }

    public void setSaltando(boolean saltando){ // Metodo para establecer el estado de saltando 
        this.saltando = saltando; // Cambio el valor de saltando segun lo recibido 
    }
    
    public void actualizar(){ 
        if(saltando){
            y += velY; // Cambio el valor de Y para que suba y baje
            if(y <= TOPE) // Si la Y es menor o igual que el tope cambio de dirección.
                velY = -velY; // Cambio la direccion de la velocidad de Y
            if(y >= 230){  // Compruebo si ya ha llegado al limite inferior
                velY = -velY; // Cambio direccion velY 
                setSaltando(false); // Pongo a Falso el salto porque ya ha llegado al suelo.
            }
        }
    }
    
    public boolean colision(Obstaculo c){ // Metodo colision para comprobar si el pajaro colisiona con un objeto
        return this.intersects(c.rect1); // Si el pajaro colisiona con la columna
    }
}
