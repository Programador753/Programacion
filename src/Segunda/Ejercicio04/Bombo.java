package Segunda.Ejercicio04;

import java.util.Random;
// aleatorio.nextInt(numBolas); -> Devuelve un entero positivo entre 0 y el numero que le pasas.
public class Bombo {
    int bolas[];
    Random aleatorio; // Random es una clase de java 
    int numBolas = 48; // Numero de bolas en el bombo 

    
    // Metodo constructor de la clase Bombo.
    public Bombo() {
        bolas = new int[numBolas]; // Instancias el vector bolas
        for(int i = 0; i < numBolas; i++) // Bucle para cargar el vector bolas con los valores de esas bolas.
            bolas[i] = i+1;  // Empiezo cargando la bola 1 
        aleatorio = new Random(); // Instancio el objeto aleatorio para que cargue un random cuando le llame.
        }
    
    public int sacaBola() {
        int numAleatorio = aleatorio.nextInt(numBolas); // Genero el numero 
        int bola = bolas[numAleatorio]; // Guardo el valor de la bola correspondiente
        bolas[numAleatorio] = bolas[numBolas - 1]; //  Cargo donde estaba la bola que ha salido la ultima bola
        numBolas--; // Reduzco la longitud en 1.
        return bola; // Devuelvo la bola.
    }
}

