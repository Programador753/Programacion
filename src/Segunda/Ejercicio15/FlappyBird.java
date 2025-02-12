package Segunda.Ejercicio15;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase Graphics
import java.awt.Event; // Importo clase Image
import java.awt.Graphics; // Importo clase Color
import java.awt.Image; // Importo clase Event
import java.util.ArrayList; // Importo clase ArrayList


public class FlappyBird extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Creo una constante de tiempo
    Thread animacion; // Creo un hilo de ejecucion
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics
    Pajaro pajaro; // Creo un objeto de la clase Pajaro
    ArrayList<Columna> columnas; // Creo un objeto de la clase Columna
    boolean continua = true; // Creo una variable booleana
    int contador = 0; // Creo una variable contador
    
    
    @Override
    public void init() { // Metodo init para inicializar
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        pajaro = new Pajaro(); // Creo un objeto de la clase Pajaro
        columnas = new ArrayList<Columna>(); // Creo un objeto de la clase Columna
        columnas.add(new Columna()); // Añado una nueva columna
        this.setSize(300, 300); // Asigno tamaño al applet
        
    }
    @Override
    public void update (Graphics g) { // Metodo update para actualizar
        paint(g); // Llamo al metodo paint
    }

    @Override
    public void start() { // Metodo start para iniciar el hilo
        animacion = new Thread(this); // Creo un hilo de ejecucion
        animacion.start(); // Inicio el hilo
    }

    @Override
    public void paint(Graphics g) { // Metodo paint para dibujar
        noseve.setColor(Color.black); // Asigno color negro
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo de negro
        pajaro.paint(noseve); // Llamo al metodo paint de la clase Pajaro
        for(Columna columna : columnas) // Foreach para recorrer la lista
            columna.paint(noseve); // Llamo al metodo paint de la clase columna 
        if(!continua) noseve.drawString("GAME OVER", 120,140); // Compruebo si continua
            g.drawImage(imagen, 0, 0, this); // Dibujo la imagen
    }

    @Override
    public boolean keyDown(Event e, int tecla) { // Metodo keyDown para mover el pajaro
        if(tecla == 32) // Si pulso la tecla espacio
            pajaro.saltar();  // LLamo a saltar 
        return true; // retorno verdadero 
    }

    @Override
    public void run() { // Metodo run para ejecutar el hilo
        do {
            contador += TIEMPO; // Incremento contador 
            if(contador > 3000){ // Compruebo vlaor contador
                columnas.add(new Columna()); // Añado nueva columna 
                contador = 0; // Reinicio contador 
            }
            pajaro.update(); // LLamo a actualizar de la clase pajaro

            for(Columna columna : columnas) // Foreach para recorrer la lista
                columna.update(); // LLamo a actualizar 

            if(!columnas.isEmpty()) // Compruebo si la columna esta vacia
                if(columnas.get(0).rect1.x < -Columna.ANCHURA) // Compruebo si la columna esta fuera de la pantalla
                    columnas.remove(0); // Elimino la columna
            
            continua = !pajaro.colision(columnas.get(0)); // Continua es falso
            
            if(pajaro.y > 300 || pajaro.y < 0) // Compruebo si el pajaro esta fuera de la antalla
                continua = false; // Continua es falsop
            
            if(!continua){ // Si continua es falso
                repaint(); // Repinto
                animacion.stop(); // Paro el hilo de ejecucion 
            }

            repaint(); // repinto 
            try {
                Thread.sleep(TIEMPO); // Hago una pausa de 20 milisegundos
            } catch (InterruptedException e) {} // Capturo excepcion 
        } while (true); // Bucle infinito
    }
}
