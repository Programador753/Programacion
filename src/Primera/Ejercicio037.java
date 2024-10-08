/*
Mostrar por pantalla el nombre del empleado que más cobra y su media mensual. 
Y el que menos cobra y su media mensual.
Mostrar por pantalla el nombre del mes que más se cobra y su media por empleado. 
Y el mes en que menos se cobra y su media por empleado.
 */
package Primera;

public class Ejercicio037 {
    public static void main(String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1978, 2200, 2100} };
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Javier Crespo", "David Hernández"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        double empleadosAcum[] = {0, 0, 0, 0};
        double mesesAcum[] = {0, 0, 0, 0, 0, 0};
        
        for(int i = 0; i < salarios.length; i++)
            for(int j = 0; j < salarios[i].length; j++){
                empleadosAcum[i] += salarios[i][j];
                mesesAcum[j] += salarios[i][j];
            }
        
        int MasCobraEmp = 0;
        int MenosCobraEmp = 0;
        for (int i = 0; i < empleadosAcum.length; i++){
            if (empleadosAcum[i] > empleadosAcum[MasCobraEmp])
                MasCobraEmp = i;
            if (empleadosAcum[i] < empleadosAcum[MenosCobraEmp])
                MenosCobraEmp = i;
        }
        int MasCobraMes = 0;
        int MenosCobraMes = 0;
        for (int i = 0; i < mesesAcum.length; i++){
            if (mesesAcum[i] > mesesAcum[MasCobraMes])
                MasCobraMes = i;
            if (mesesAcum[i] < mesesAcum[MenosCobraMes])
                MenosCobraMes = i;
        }
        System.out.printf("El empleado que mas cobra es %s y su media es %.2f\n", empleados[MasCobraEmp], (empleadosAcum[MasCobraEmp]/meses.length) );
        System.out.printf("El empleado que menos cobra es %s y su media es %.2f\n", empleados[MenosCobraEmp], (empleadosAcum[MenosCobraEmp]/meses.length) );
        System.out.printf("El mes que mas se cobra es %s y su media es %.2f\n", meses[MasCobraMes], (mesesAcum[MasCobraMes]/empleados.length) );
        System.out.printf("El mes que menos se cobra es %s y su media es %.2f\n", meses[MenosCobraMes], (mesesAcum[MenosCobraMes]/empleados.length) );
        
    }
}
