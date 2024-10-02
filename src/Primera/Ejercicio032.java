/*
Mostrar por pantalla el día en que se vendieron más entradas
y cuántas se vendieron.
Y el día en que se vendieron menos entradas y cuántas se vendieron.
 */
package Primera;

public class Ejercicio032 {
    public static void main(String arg[]){
        int salas[][] = {   {10, 20, 30, 40, 50, 200, 180},
                            {50, 60, 70, 80, 80, 300, 198},
                            {90, 100, 110, 120, 130, 150, 120}};
        String []dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        int entradas[] = {0, 0, 0, 0, 0, 0, 0};
        
        for(int i = 0; i < salas.length; i++)
            for(int j = 0; j < dias.length; j++)
                entradas[j] += salas[i][j];
        
        int posMayor = 0;
        int posMenor = 0;
        for(int i=0; i < entradas.length; i++)
        {
            if(entradas[i] > entradas[posMayor])
                posMayor = i;
            if(entradas[i] < entradas[posMenor])
                posMenor = i;
        }
        System.out.printf("El %s fue dia que mas entradas se vendieron con un total de %d y el %s fue el dia con menos entradas vendidas con un total de %d\n", dias[posMayor], entradas[posMayor], dias[posMenor], entradas[posMenor] );              
    }
}