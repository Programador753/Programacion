package Segunda.Ejercicio16;

// Crear una lsita de naves con 10 naves y cada cierto tiempo añades una nueva nave

import java.applet.Applet;
import java.awt.Color;  
import java.awt.Event;
import java.awt.Graphics; 
import java.awt.Image;
import java.util.ArrayList;

public class Marcianitos  extends Applet implements Runnable {
    public static final int TIEMPO = 35;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Gun gun;
    ArrayList<Bala> balas;
    ArrayList<Nave> naves;
    
    boolean continua = true;
    int contador = 0;
    
    public void init(){ 
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics();
        gun = new Gun();
        balas = new ArrayList<Bala>();
        naves = new ArrayList<Nave>();
        for(int i = 0; i < 10; i++)
            naves.add(new Nave());
        this.setSize(300,300);
    }
       
    public void update(Graphics g){
        paint(g);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        gun.dibujar(noseve);
        for(Bala bala : balas)
            bala.paint(noseve);
        
        for(Nave nave : naves)
            nave.paint(noseve);
        
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run(){
        do{   
            contador += TIEMPO;
            for(Bala bala : balas)
                if(bala.update()){
                    balas.remove(bala);
                    break;
                }
            
            for(Nave nave : naves)
                nave.update(); 
            
            if(!continua){
                repaint();
                animacion.stop();
            }
            
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
    
    
    public boolean mouseMove(Event e, int x, int y){
        gun.actualizar(x);
        return true;
    }
    public boolean mouseDown(Event e, int x, int y){ //Los evs de ratón reciben x e y siempre
        balas.add(new Bala(x));
        return true;
    }
}