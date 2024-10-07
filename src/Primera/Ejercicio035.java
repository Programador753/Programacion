/*
Mostrar por pantalla el nombre del alumno que ha obtenido las
mejores notas y su media de notas.
También el nombre del alumno con peores notas y su media.
El nombre de la asignatura con mejores notas y su media.
El nombre de la asignatuara con peores notas y su media.
 */
package Primera;

public class Ejercicio035 {
    public static void main(String arg[]){
        int notas[][] = {   {7, 9, 3, 8},
                            {10, 9, 9, 8},
                            {9, 10, 7, 1},
                            {3, 10, 5, 6},
                            {8, 5, 4, 5} };
        String alumnos[] = {"Javier Marías", "Antonio Muñoz", "Javier Crespo", "David Hernández", "Ignacio Garcia"};
        String asignaturas[] = {"Programación", "Leng.Marcas", "Bases.Datos", "Ingles"};
        double vAlumnosNota[] = {0, 0, 0, 0, 0};
        double vAsigNota[] = {0, 0, 0, 0};
        
        
        for(int i = 0; i < notas.length; i++)
            for(int j = 0; j < notas[i].length; j++){
                vAlumnosNota[i] += notas[i][j];
                vAsigNota[j] += notas[i][j];
            }
        int posMayor = 0;
        int posMenor = 0;
        for(int i=0; i < vAlumnosNota.length; i++){
            if(vAlumnosNota[i] > vAlumnosNota[posMayor])
                posMayor = i;
            if(vAlumnosNota[i] < vAlumnosNota[posMenor])
                posMenor = i;
        }
        int Min = 0;
        int Max = 0;
        for(int i=0; i < vAsigNota.length; i++){
            if(vAsigNota[i] > vAsigNota[Max])
                Max = i;
            if(vAsigNota[i] < vAsigNota[Min])
                Min = i;
        }
        
        System.out.printf("El alumno con mejor notas es %s y su media es %.2f\n", alumnos[posMayor], (vAlumnosNota[posMayor]/asignaturas.length) );
        System.out.printf("El alumno con peores notas es %s y su media es %.2f\n", alumnos[posMenor], (vAlumnosNota[posMenor]/asignaturas.length) );
        System.out.printf("La asignatura con mejores notas es %s y su media es %.2f\n", asignaturas[Max], (vAsigNota[Max]/alumnos.length) );
        System.out.printf("La asignatura con peores notas es %s y su media es %.2f\n", asignaturas[Min], (vAsigNota[Min]/alumnos.length) );
    }
}
