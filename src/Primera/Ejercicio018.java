/*
Transformar los elementos del vector, de manera que los valores negativos 
se conviertan en positivos y los que ya eran positivos se multipliquen por 2
 */
package Primera;

public class Ejercicio018 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50};
        for(int i=0; i < datos.length; i++)
            if(datos[i] < 0 )
                datos[i] *= -1;
            else
                datos[i] *= 2;
        
        //Ahora mostramos como queda el contenido del vector
        for(int i=0; i < datos.length; i++)
            System.out.println(datos[i]);
    }
}
