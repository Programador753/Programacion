package Tercera.Ejercicio1;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics 
import java.awt.Image; // Importo clase Image
import java.awt.Event; // Importamos la clase Event




public class Camina extends Applet implements Runnable {
    public static final int TIEMPO = 100; // Variable de tiempo
    public static final int GUERRILLERO = 0; // Variable de guerrillero
    public static final int HAMPON = 1; // Variable de hampon
    public static final int VAQUERO = 2; // Variable de vaquero

    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics
    Image fotogramas[] []; // Imagenes para la animacion
    String lugares[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"}; // Array de lugares
    DibujoAnimado dibujos; // Array de dibujos



    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(500, 300); // Creo una imagen de 500x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        fotogramas = new Image[3][4]; // Creo un array de 4x4 para los fotogramas
        for(int i = 0; i < 3; i++) // Bucle para recorrer el array de lugares
            for(int j = 0; j < 4; j++) // Bucle para recorrer el array de lugares
                fotogramas[i][j] = getImage(getCodeBase(), "Tercera/Ejercicio1/Sprites/" + lugares[i] + (j+1) + ".gif"); // Asigno las imagenes a los fotogramas
       
        
        dibujos = new DibujoAnimado(fotogramas[0]); // Asigno las imagenes a los dibujos
        this.setSize(500,300); // Establezco el tamaño del applet
    }

    
    public void update(Graphics g){ // Metodo update que recibe un objeto de la clase Graphics
        paint(g); // Llamo al metodo paint con el objeto g 
    }
    public void start(){ // Metodo start para iniciar el hilo de animacion 
        animacion = new Thread(this); // Creo un hilo de animacion 
        animacion.start(); // Inicio el hilo de animacion 
    }
    
    public void paint(Graphics g){ // Metodo paint que recibe un objeto de la clase Graphics 
        noseve.setColor(Color.BLACK); // Fondo de color negro
        noseve.fillRect(0, 0, 300, 300); // Pinto rectangulo 300 * 300
        dibujos.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this); // Pinto la imagen 
    }

    
    public void run(){ // Metodo run para el hilo de animacion 
        do{
            dibujos.update();
            repaint(); // Llamo al metodo repaint

            try{ // Capturo la excepcion InterruptedException
                Thread.sleep(TIEMPO); // Hago que el hilo de animacion duerma durante el tiempo establecido
            }catch(InterruptedException e){}  // Capturo la excepcion InterruptedException
        }while(true); // Bucle infinito 
    }

    public boolean keyDown(Event e, int tecla) {
    switch(tecla){
        case 103: 
        case 71:
            dibujos.setImagenes(fotogramas[GUERRILLERO]);
            break;
        case 104:
        case 72:
            dibujos.setImagenes(fotogramas[HAMPON]);
            break;
        case 118:
        case 86:
            dibujos.setImagenes(fotogramas[VAQUERO]);
            break;
        }
        return true;
    }
}