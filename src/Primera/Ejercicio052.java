/*
Implementar una función que sume los elementos de un vector 
unidimensional de enteros y devuelva un entero con la suma.
Desde el programa principal llamaremos a esta función una 
vez por cada empleado y mostraremos su nombre y la suma de sus 
salarios.
 */
package Primera;

public class Ejercicio052 {
    public static void main(String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1978, 2200, 2100} 
                            };
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Javier Crespo", "David Hernández"};
        
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("El empleado %s ha cobrado %d €\n",empleados[i], suma(salarios[i]));
    }
    public static int suma(int vector[]){
        int acum = 0;
        for(int i = 0; i < vector.length; i++)
                acum += vector[i];
        return acum;
    }
}
