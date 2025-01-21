package Segunda.Ejercicio10;

import java.awt.Graphics; // Importo clase Graphics

public class DosPuntos {
    public static final int LINEA = 0; // Constantes de clase para los tipos de figuras en este caso LINEA
    public static final int OVALO = 1; // Constantes de clase para los tipos de figuras en este caso OVALO
    public static final int RECTANGULO = 2; // Constantes de clase para los tipos de figuras en este caso RECTANGULO
    int inicioX, inicioY, finX, finY; // Variables de clase para los puntos de inicio y fin de la figura a dibujar
    int tipo; // Variable de tipo entero para almacenar el tipo de ficgura a dibujar

    public DosPuntos(int inicioX, int inicioY, int finX, int finY, int tipo){ // Metodo constructor para dar valores iniciales
        this.inicioX = inicioX; // Se asigna el valor de inicioX a la variable de clase inicioX
        this.inicioY = inicioY; // Se asigna el valor de inicioY a la variable de clase inicioY
        this.finX = finX; // Se asigna el valor de finX a la variable de clase finX
        this.finY = finY; // Se asigna el valor de finY a la variable de clase finY
        this.tipo = tipo; // Se asigna el valor de tipo a la variable de clase tipo
    }

    public DosPuntos(int inicioX, int inicioY, int tipo){ // Metodo constructor para el punto inicial que sera el mismo que el final 
        this(inicioX, inicioY, inicioX, inicioY, tipo); // Se llama al metodo constructor con los valores de inicioX, inicioY y tipo para poder asignar los valores a las variables de clase inicioX, inicioY, finX, finY y tipo
    }
    
    public DosPuntos(){ // Metodo constructor por defecto
        this(0, 0, LINEA); // Se llama al metodo constructor con los valores de inicioX, inicioY, finX, finY y tipo para poder asignar los valores a las variables de clase inicioX, inicioY, finX, finY y tipo
    }
    
    public void dibujar(Graphics g) {
        int anchura, altura; // Variables de tipo entero para almacenar la anchura y altura de la figura
        anchura = Math.abs(finX - inicioX); // Se calcula la anchura de la figura
        altura = Math.abs(finY - inicioY); // Se calcula la altura de la figura
        switch(tipo){ // Se evalua la variable de clase tipo
            case LINEA: // Si el valor de tipo es igual a LINEA
                g.drawLine(inicioX, inicioY, finX, finY); // Se dibuja una linea con los valores de inicioX, inicioY, finX y finY  
                break; // Se sale del bucle
            case OVALO: // Si el valor de tipo es igual a OVALO
                g.drawOval(inicioX, inicioY, anchura, altura); // Se dibuja un ovalo con los valores de inicioX, inicioY, anchura y altura
                break; // Se sale del bucle
            case RECTANGULO: // Si el valor de tipo es igual a RECTANGULO
                g.drawRect(inicioX, inicioY, anchura, altura); // Se dibuja un rectangulo con los valores de inicioX, inicioY, anchura y altura
        }

    }

}
