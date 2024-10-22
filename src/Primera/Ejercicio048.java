/*
1. Implementar un método que reciba el array de salarios y nos 
devuelva un vector unidimensional de 6 enteros con los salarios 
acumulados por mes.
2. Sacar sueldo por empleado en total.  
Polimorfismo es que admite mismos nombre pero con diferente morfologia,
dependera de si llamas a uno u otro segun los parametros que le pases
 */
package Primera;

public class Ejercicio048 {
    public static void main(String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1978, 2200, 2100} };
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Javier Crespo", "David Hernández"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        
        for(int i = 0; i < SalariosSemestral(salarios).length; i++)
            System.out.printf("El acumulado del mes de %s es : %d €\n",meses[i], (SalariosSemestral(salarios)[i]));
        
        int vPorMes[] = {0, 0, 0, 0, 0, 0};
        SalariosSemestral(salarios, vPorMes);
        
        System.out.println();
        for(int i = 0; i < vPorMes.length; i++)
            System.out.printf("El acumulado del mes de %s es : %d €\n",meses[i], vPorMes[i]);
        
        System.out.println();
        for(int i = 0; i < SalarioEmpleado(salarios).length; i++)
            System.out.printf("El empleado %s ha cobrado %d €\n",empleados[i], (SalarioEmpleado(salarios)[i]));
        
        int salarioEmp[] = {0, 0, 0, 0};
        SalarioEmpleado(salarios, salarioEmp);
                
        System.out.println();
        for(int i = 0; i < salarioEmp.length; i++)
            System.out.printf("El empleado %s ha cobrado %d €\n",empleados[i], salarioEmp[i]);        
    }
    
    public static int[] SalariosSemestral(int v1[][]){
        int salariosMes[] = {0, 0, 0, 0, 0, 0};
        
        for(int i = 0; i < v1.length; i++)
            for(int j = 0; j < v1[i].length; j++)
                salariosMes[j] += v1[i][j];
        return salariosMes;
    }
    
    public static void SalariosSemestral(int v1[][], int vPM[]){
        for(int i = 0; i < v1.length; i++)
            for(int j = 0; j < v1[i].length; j++)
                vPM[j] += v1[i][j];
    }
    
    public static int[] SalarioEmpleado(int v1[][]){
        int salarioEmp[] = {0, 0, 0, 0};
        
        for(int i = 0; i < v1.length; i++)
            for(int j = 0; j < v1[i].length; j++)
                salarioEmp[i] += v1[i][j];
        return salarioEmp;
    }
    
    public static void SalarioEmpleado(int v1[][], int vEMP[]) {
        for(int i = 0; i < v1.length; i++)
            for(int j = 0; j < v1[i].length; j++)
                vEMP[i] += v1[i][j];
    }
}
