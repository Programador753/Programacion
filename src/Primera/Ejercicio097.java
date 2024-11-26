/*
La ley D'Hondt
 */
package Primera;

public class Ejercicio097 {
    public static void main (String arg[]){
        final int ESCANOS = 7; // 'final' es para declarar constantes y sus nombres se declaran siempre en mayusculas.
        int votos[] = {193100,232000,33000,63600,13000};
        int cocientes[] = {1,1,1,1,1};
        String partidos[] = {"PSOE","PP","CHA","VOX","PAR"};
        int posMax;

        for(int i = 0; i < ESCANOS; i++){
            posMax = 0;
            for(int j = 1; j < votos.length; j++)
                if((votos[posMax]/cocientes[posMax]) < (votos[j]/cocientes[j]))
                    posMax = j;
            cocientes[posMax]++;
        }
        for(int i = 0; i < partidos.length; i++)
            System.out.println(partidos[i] + " : " + (cocientes[i]-1) + " escaños.");
    }
}
