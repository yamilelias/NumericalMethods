/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Yamil Elías
 */
public class GaussCalculator {
    private int size;
    private double[][] matrix;
    JTextArea area;

    public GaussCalculator(int size, double[][] matrix, JTextArea area) {
        this.size = size;
        this.matrix = matrix;
        this.area = area;
    }
    
    public void calculateValues(){
        
        double[] value = new double[6];
        double values_making_zero;
        double pivot_first_value;
//Desarrollo del mètodo como tal. Aqùi se va haciendo 1 el pivote y se sigue con el proceso propio
        // n es el primer valor del elemento que servira de pivote, val2 representa los diferentes valores
        //que se van haciendo cero debajo del pivote. NO SE DECLARARON MAS VALORES PARA DECLARAR
        //LA MENOR CANTIDAD DE LINEAS POSIBLES
        
        // Los "if(n==0)" son para cuando hay mùltiple soluciòn, se ejecuta el còdigo con el cual se toma
        // el valor que se solicita al usuario para dar una solucion. El "if(tamaño)" sirve para indicar 
        //hasta donde se tiene que ejecutar el còdigo, delimita que tanto debe usarse para poder solucionar la matriz 
        //generada en funciòn del nùmero de incògnitas
        pivot_first_value = matrix[0][0];
        for (int i = 0; i < 6; i++) {
            matrix[0][i] = matrix[0][i] / pivot_first_value;
        }

        values_making_zero = matrix[1][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * - values_making_zero;
            matrix[1][i] = value[i] + matrix[1][i];
        }
        values_making_zero = matrix[2][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * - values_making_zero;
            matrix[2][i] = value[i] + matrix[2][i];
        }
        values_making_zero = matrix[3][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * - values_making_zero;
            matrix[3][i] = value[i] + matrix[3][i];
        }
        values_making_zero = matrix[4][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * - values_making_zero;
            matrix[4][i] = value[i] + matrix[4][i];
        }
        printTextArea(matrix);

        pivot_first_value = matrix[1][1];
        if (pivot_first_value==0){
                multipleSolutionMethod(matrix,size);
            }
            else{
        for (int i = 0; i < 6; i++) {
            matrix[1][i] = matrix[1][i] / pivot_first_value;
        }

        values_making_zero = matrix[0][1];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[1][i] * - values_making_zero;

            matrix[0][i] = value[i] + matrix[0][i];

        }

        values_making_zero = matrix[2][1];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[1][i] * - values_making_zero;
            matrix[2][i] = value[i] + matrix[2][i];

        }
        values_making_zero = matrix[3][1];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[1][i] * - values_making_zero;
            matrix[3][i] = value[i] + matrix[3][i];

        }
        values_making_zero = matrix[4][1];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[1][i] * - values_making_zero;
            matrix[4][i] = value[i] + matrix[4][i];

        }
        printTextArea(matrix);
        }

        if (size >= 3) {
            pivot_first_value = matrix[2][2];
            if (pivot_first_value==0){
                multipleSolutionMethod(matrix,size);
            }
            else{
            for (int i = 0; i < 6; i++) {
                matrix[2][i] = matrix[2][i] / pivot_first_value;
            }
            values_making_zero = matrix[0][2];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[2][i] * - values_making_zero;
                matrix[0][i] = value[i] + matrix[0][i];

            }
            values_making_zero = matrix[1][2];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[2][i] * - values_making_zero;
                matrix[1][i] = value[i] + matrix[1][i];

            }

            values_making_zero = matrix[3][2];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[2][i] * - values_making_zero;
                matrix[3][i] = value[i] + matrix[3][i];

            }
            values_making_zero = matrix[4][2];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[2][i] * - values_making_zero;
                matrix[4][i] = value[i] + matrix[4][i];

            }
            printTextArea(matrix);
            }
        }
        if (size >= 4) {
            pivot_first_value = matrix[3][3];
            if (pivot_first_value==0){
                multipleSolutionMethod(matrix,size);
            }
            else{
            for (int i = 0; i < 6; i++) {
                matrix[3][i] = matrix[3][i] / pivot_first_value;
            }
            values_making_zero = matrix[0][3];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * - values_making_zero;
                matrix[0][i] = value[i] + matrix[0][i];

            }
            values_making_zero = matrix[1][3];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * - values_making_zero;
                matrix[1][i] = value[i] + matrix[1][i];

            }

            values_making_zero = matrix[2][3];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * - values_making_zero;
                matrix[2][i] = value[i] + matrix[2][i];

            }
            values_making_zero = matrix[4][3];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * - values_making_zero;
                matrix[4][i] = value[i] + matrix[4][i];

            }
            printTextArea(matrix);}
        }
        if (size == 5) {
            pivot_first_value = matrix[4][4];
            if (pivot_first_value==0){
                multipleSolutionMethod(matrix,size);
            }
            else{
            for (int i = 0; i < 6; i++) {
                matrix[4][i] = matrix[4][i] / pivot_first_value;
            }
            values_making_zero = matrix[0][4];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[4][i] * - values_making_zero;
                matrix[0][i] = value[i] + matrix[0][i];

            }
            values_making_zero = matrix[1][4];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[4][i] * - values_making_zero;
                matrix[1][i] = value[i] + matrix[1][i];

            }

            values_making_zero = matrix[2][4];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[4][i] * - values_making_zero;
                matrix[2][i] = value[i] + matrix[2][i];

            }
            values_making_zero = matrix[3][4];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[4][i] * - values_making_zero;
                matrix[3][i] = value[i] + matrix[3][i];

            }
            printTextArea(matrix);}

        }
        //Los siguientes "if" son para mostrar el resultado de acuerdo al tamañó de la matriz
        //pues una de cico incògnitas muestra mas resultados que una de 3, por ejemplo :)
        if(size==2){
            if (matrix[0][0] == 1 && matrix[1][1] == 1) {
                area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5]);
            } else if (matrix[1][0] == 0 && matrix[1][1] == 0 && matrix[1][5] > 0) {
                area.append("Inconsistencia");
            } 
        }
        if (size == 3) {
            if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1) {
                area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                        + matrix[2][5]);
            } else if (matrix[2][0] == 0 && matrix[2][1] == 0 && matrix[2][2] == 0
                    && matrix[2][5] > 0) {
                area.append("Inconsistencia");
            } 
        }
        if (size == 4) {
            if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1 && matrix[3][3] == 1) {
                area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                        + matrix[2][5] + "\n Y= " + matrix[3][5]);
            } else if (matrix[3][0] == 0 && matrix[3][1] == 0 && matrix[3][2] == 0 && matrix[3][3] == 0
                    && matrix[3][5] > 0) {
                area.append("Inconsistencia");
            } 

        }
        if (size == 5) {
            if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1 && matrix[3][3] == 1
                    && matrix[4][4] == 1) {
                area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                        + matrix[2][2] + "\n Y= " + matrix[3][5] + "\n Z= " + matrix[4][5]);
            } else if (matrix[4][0] == 0 && matrix[4][1] == 0 && matrix[4][2] == 0 && matrix[4][3] == 0
                    && matrix[4][4] == 0 && matrix[4][5]>0) {
                area.append("Inconsistencia");
            } 

        }


    }
    
    public void printTextArea(double[][] ma){
                // Este còdigo muestra al usuario la forma en la cual se va resolviendo la matriz
        //es decir que muestra el desarrollo del mètodo como tal 
        DecimalFormat decimales = new DecimalFormat("0.000");
        String r = "";
        for (int i = 0; i < 5; i++) {
            for (int m = 0; m < 6; m++) {
                r += decimales.format(matrix[i][m]) + " // ";
            }
            r += "\n";
        }
        r += "\n";
        area.append(r);

    }
    
    //ESTA SECCIÒN SE ENCARGA DEL CÀLCULO CUANDO SE ESTA TRABAJANDO CON UNA MATRIZ DF 
    //MULTIPLE SOLUCION 
    public void multipleSolutionMethod(double ma[][], int tam){
        int i=Integer.parseInt(JOptionPane.showInputDialog("Multiple solucion Ingrese un numero: "));
        double [] m= new double [5];
        m[tam-1]=i;
        for(int n=tam-1;n>0;n--){
            m[n-1]=matrix[n-1][5]-matrix[n][tam-1]*i;
        }
        for(int n=0;n<tam;n++){
            area.append(m[n]+"\n");
        }
        
        
    }
    
}
