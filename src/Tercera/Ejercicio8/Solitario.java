/* Es la clase principal:
Inicializa todos los componentes del juego (baraja, mazos, etc.)
Maneja los eventos del ratón para permitir la interacción
Implementa la lógica del juego (robar cartas, mover cartas entre mazos)
Dibuja el estado actual del juego
*/
package Tercera.Ejercicio8;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Solitario extends Applet { // Solitario de cartas
    public static final int NUMCARTAS = 52; // 4 palos de 13 cartas
    public static final int CPP = 13; // Cartas Por Palo
    public static final int NUM_PALOS = 4;
    public static final int NUM_COLUMNAS = 7; // 7 columnas de cartas
    Image imagen;
    Graphics noseve;
    Image imagenes[];
    Image reverso;
    Baraja baraja;
    MazoSecundario mazoSecundario;
    Rectangle rectangulo;
    Carta activa;
    MazoPalo mazoPalos[];
    MazoJuego mazoJuegos[];
    
    public void init() { // Inicializa el applet
        imagen = this.createImage(700, 800); // Crea la imagen
        noseve = imagen.getGraphics();  // Crea el objeto Graphics para dibujar en la imagen
        String palos[] = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"}; // Palos de las cartas
        // Crea las cartas y las guarda en un array de imagenes
        
        imagenes = new Image[NUMCARTAS]; // Array de imagenes
        for(int i=0; i<NUMCARTAS; i++) // Crea las cartas
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/" + ((i%CPP)+1) + palos[i/CPP]); // Crea la imagen de la carta

        reverso = getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/reverso.png");    // Crea la imagen del reverso de la carta
        rectangulo = new Rectangle(20, 20, Carta.ANCHURA, Carta.ALTURA); // Crea el rectangulo donde se puede hacer click para sacar una carta
        baraja = new Baraja(imagenes);  // Crea la baraja de cartas
        mazoSecundario = new MazoSecundario();  // Crea el mazo secundario donde se guardan las cartas que se sacan de la baraja
        
        mazoPalos = new MazoPalo[NUM_PALOS]; // Array de mazos de palos
        for(int i=0; i<NUM_PALOS; i++) // Crea los mazos de palos
            mazoPalos[i] = new MazoPalo((i*(Carta.ANCHURA+30))+300); // Crea el mazo de palos
        
        mazoJuegos = new MazoJuego[NUM_COLUMNAS];   // Array de mazos de juegos
        for(int i=0; i<NUM_COLUMNAS; i++) // Crea los mazos de juegos
            mazoJuegos[i] = new MazoJuego(i*(Carta.ANCHURA+20)+20); // Crea el mazo de juegos
        
        this.setSize(700, 800); // Establece el tamaño del applet
    }

    public void update(Graphics g) { // Actualiza el applet
        paint(g);   // Llama al metodo paint para dibujar el applet
    }
    
    public void paint(Graphics g) { // Dibuja el applet
        noseve.setColor(Color.GREEN); // Establece el color de fondo
        noseve.fillRect(0, 0, 700, 800); // Dibuja el fondo
        noseve.drawImage(reverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this); // Dibuja el reverso de la carta
        
        for(int i=0; i<NUM_PALOS; i++) // Dibuja los mazos de palos
            mazoPalos[i].paint(noseve, this); // Dibuja el mazo de palos
        
        for(int i=0; i<NUM_COLUMNAS; i++) // Dibuja los mazos de juegos
            mazoJuegos[i].paint(noseve, this); // Dibuja el mazo de juegos
        
        mazoSecundario.paint(noseve, this); // Dibuja el mazo secundario
        
        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen en el applet
    }
    
    public boolean mouseDown(Event e, int x, int y) { // evento cuando se hace click en el raton
        if(rectangulo.contains(x,y)) { // Si se hace click en el rectangulo
            if(!baraja.getCartas().isEmpty()) { // Si la baraja no esta vacia
                mazoSecundario.anadir(baraja.sacarCarta()); // Saca una carta de la baraja y la añade al mazo secundario
                mazoSecundario.recolocar(); // Recoloca el mazo secundario
            } else { // Si la baraja esta vacia
                baraja.setCartas(mazoSecundario.getCartas()); // Añade las cartas del mazo secundario a la baraja
                mazoSecundario.setCartas(new ArrayList<Carta>()); // Vacía el mazo secundario
            }
        }
        if(mazoSecundario.extraer().contains(x,y)) { // Si se hace click en el mazo secundario
            activa = mazoSecundario.extraer(); // Saca una carta del mazo secundario
        }
        repaint();  // Dibuja el applet
        return true;    // Devuelve true para indicar que el evento ha sido manejado
    }
    
    public boolean mouseDrag(Event e, int x, int y) { // evento cuando se arrastra el raton
        if(activa != null) { // Si hay una carta activa
            activa.setPosicion(x - (Carta.ANCHURA/2), y - (Carta.ALTURA/2)); // Establece la posicion de la carta activa
            repaint();  // Dibuja el applet
        }
        return true;    // Devuelve true para indicar que el evento ha sido manejado
    }
    
    public boolean mouseUp(Event e, int x, int y) { // evento cuando se suelta el raton
        if(activa != null) { // Si hay una carta activa
            for(int i=0; i<NUM_PALOS; i++) // Recorre los mazos de palos
                if(activa.intersects(mazoPalos[i])) { // Si la carta activa intersecta con el mazo de palos
                    if(mazoPalos[i].anadir(activa)) { // Si se añade la carta al mazo de palos
                        mazoSecundario.eliminar(); // Elimina la carta del mazo secundario 
                        break; // Sale del bucle
                    }
                }
            for(int i=0; i<NUM_COLUMNAS; i++) // Recorre los mazos de juegos
                if(mazoJuegos[i].getCartas().isEmpty()) { // Si el mazo de juegos esta vacio
                    if(activa.intersects(mazoJuegos[i])) { // Si la carta activa intersecta con el mazo de juegos
                        mazoJuegos[i].anadir(activa); // Añade la carta al mazo de juegos
                        mazoSecundario.eliminar(); // Elimina la carta del mazo secundario
                        break;  // Sale del bucle
                    }
                } else if(activa.intersects(mazoJuegos[i].extraer())){  // Si la carta activa intersecta con el mazo de juegos
                    if(mazoJuegos[i].anadir(activa)) { // Si se añade la carta al mazo de juegos
                        mazoSecundario.eliminar(); // Elimina la carta del mazo secundario
                        break; // Sale del bucle
                    }
                    
                }
            mazoSecundario.recolocar(); // Recoloca el mazo secundario
            activa = null; // Elimina la carta activa
            repaint(); // Dibuja el applet
        }
        return true;   // Devuelve true para indicar que el evento ha sido manejado
    }
    }
    