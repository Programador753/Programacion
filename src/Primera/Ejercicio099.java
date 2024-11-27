/*
Ejercicio 2 examen 23-24
*/
package Primera;

public class Ejercicio099 {
    public static void main(String[] arg) {
        int notas[][] = {   {3, 4, 8, 9},
                            {4, 5, 7, 10},
                            {2, 7, 10, 8},
                            {5, 3, 6, 7},
                            {4, 2, 5, 8}};
        String asignaturas[] = {"Programación", "Marcas", "Entornos", "Base Datos"};
        String alumnos[] = {"Alumno 1", "Alumno 2", "Alumno 3", "Alumno 4", "Alumno 5"};
        
        Suspendidos(asignaturas, notas, alumnos); 
        
        mediaMenor5(notas);

        System.out.println("Alumnos con una media superior a 5:\n");
        mediaMayor5(notas, alumnos);
     }

    public static void Suspendidos(String[] asignaturas, int notas[][], String alumnos[]) {
        // Alumnos suspendidos por asignatura
        int suspensos;
        for (int j = 0; j < asignaturas.length; j++){
            suspensos = 0;
            for (int i = 0; i < alumnos.length; i++)
                if (notas[i][j] < 5)
                    suspensos++;
            System.out.printf("En la asignatura %s han suspendido %d alumnos\n", asignaturas[j], suspensos);
        }
    }
    
    public static void mediaMenor5(int notas[][]) {
        double menor5 = 0;
        int contador = 0;
        for (int i = 0; i < notas.length; i++)
            for (int j = 0; j < notas[i].length; j++)
                if (notas[i][j] < 5){
                    menor5 += notas[i][j];
                    contador++;
                }
        System.out.printf("La media de las notas menores que 5 es: %.2f\n", menor5/contador);
    }
    
    public static void mediaMayor5(int[][] notas,  String alumnos[]) {
        double acumula;
        for (int i = 0; i < notas.length; i++) {
            acumula = 0;
            for (int j = 0; j < notas[i].length; j++)
                acumula += notas[i][j];
            if ((acumula / notas[i].length) >= 5) {
                System.out.printf("%s \n", alumnos[i]);
            }
        }
    }
}
