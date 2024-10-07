/*
Saca el listado de dieces con el nombre de los alumnos
 */
package Primera;

public class Ejercicio036 {
    public static void main(String arg[]){
        int notas[][] = {   {7, 9, 3, 8},
                            {10, 9, 9, 8},
                            {9, 10, 7, 1},
                            {3, 10, 5, 6},
                            {8, 5, 4, 5} };
        String alumnos[] = {"Javier Marías", "Antonio Muñoz", "Javier Crespo", "David Hernández", "Ignacio Garcia"};
        String asignaturas[] = {"Programación", "Leng.Marcas", "Bases.Datos", "Ingles"};
        
        for(int i = 0; i < notas.length; i++)
            for(int j = 0; j < notas[i].length; j++){
                if(notas[i][j] == 10)
                    System.out.printf("El alumno %s saco un 10 en la asignatura %s\n", alumnos[i], asignaturas[j]);
                
            }
    }    
}
