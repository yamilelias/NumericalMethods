
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMatrixMethod implements ActionListener {

    private static int col, row;  //dimentions
    private static double myMatrix[][];
    private static double tempMatrix[][];
    private static JTextField inputField[][];
    private static int result;
    private static JButton minusB, plusB, inverseB,
            multiplyB, nMultiplyB, nDivisionB,
            getValueB, showMatrix, transposing,
            newMatrix;
    private static JPanel choosePanel[] = new JPanel[8];
    private static int lastCol, lastRow;

    /**
     * Constructor for the matrix program
     */
    GUIMatrixMethod() {
        col = row = 0;
        myMatrix = new double[0][0];
        ChooseOperation();
    }

    /**
     * for taking matrix's dimensitions
     */
    private static void getDimension() {
        JTextField lField = new JTextField(5); //lenght field 
        JTextField wField = new JTextField(5); //col field

        //design input line
        JPanel choosePanel[] = new JPanel[2];
        choosePanel[0] = new JPanel();
        choosePanel[1] = new JPanel();
        choosePanel[0].add(new JLabel("Ingresa las dimensiones"));
        choosePanel[1].add(new JLabel("Filas:"));
        choosePanel[1].add(lField);
        choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer
        choosePanel[1].add(new JLabel("Columnas:"));
        choosePanel[1].add(wField);

        result = JOptionPane.showConfirmDialog(null, choosePanel, null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        //save last dimensions
        lastCol = col;
        lastRow = row;

        //ok option
        if (result == 0) {

            if (wField.getText().equals("")) {
                col = 0;
            } else {
                if (isInt(wField.getText())) {
                    col = Integer.parseInt(wField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Dimensiones incorrectas");
                    col = lastCol;
                    row = lastRow;
                    return;
                }

                if (isInt(lField.getText())) {
                    row = Integer.parseInt(lField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Dimensiones erroneas");
                    col = lastCol;
                    row = lastRow;
                    return;
                }
            }
            if (col < 1 || row < 1) {
                JOptionPane.showConfirmDialog(null, "Ingresaste dimensiones erroneas", "Error", JOptionPane.PLAIN_MESSAGE);
                col = lastCol;
                row = lastRow;
            } else {
                tempMatrix = myMatrix;
                myMatrix = new double[row][col];
                if (!setElements(myMatrix, "Llena la nueva matriz")) { // Filling the new matrix
                    myMatrix = tempMatrix; // backup
                }
            }
        } else if (result == 1) {
            col = lastCol;
            row = lastRow;
        }
    }//end get Dimension

    /**
     * for filling matrix's elements  
     * @param matrix
     * @param title
     * @return 
     */
    private static boolean setElements(double matrix[][], String title) {
        int temp, temp1;             //temprature variable
        String tempString;

        JPanel choosePanel[] = new JPanel[row + 2];
        choosePanel[0] = new JPanel();
        choosePanel[0].add(new Label(title));
        choosePanel[choosePanel.length - 1] = new JPanel();
        choosePanel[choosePanel.length - 1].add(new Label("Se consideran espacios en blanco como cero"));
        inputField = new JTextField[matrix.length][matrix[0].length];

        //lenght loop
        for (temp = 1; temp <= matrix.length; temp++) {
            choosePanel[temp] = new JPanel();

            for (temp1 = 0; temp1 < matrix[0].length; temp1++) {
                inputField[temp - 1][temp1] = new JTextField(3);
                choosePanel[temp].add(inputField[temp - 1][temp1]);

                if (temp1 < matrix[0].length - 1) {
                    choosePanel[temp].add(Box.createHorizontalStrut(15)); // a spacer
                }
            }// end col loop
        }// end row loop

        result = JOptionPane.showConfirmDialog(null, choosePanel, null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == 0) {
            checkTextField(inputField);
            for (temp = 0; temp < matrix.length; temp++) {
                for (temp1 = 0; temp1 < matrix[0].length; temp1++) {
                    tempString = inputField[temp][temp1].getText();

                    if (isDouble(tempString)) {
                        matrix[temp][temp1] = Double.parseDouble(inputField[temp][temp1].getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresaste elementos erroneos");

                        //backup
                        col = lastCol;
                        row = lastRow;
                        return false;
                    }
                }
            }

            return true;
        } // End of if
        else {
            return false;
        }
    }// end get Inputs

    /**
     * For setting spaced fields as zeros
     * @param field 
     */
    private static void checkTextField(JTextField field[][]) {
        for (int temp = 0; temp < field.length; temp++) {
            for (int temp1 = 0; temp1 < field[0].length; temp1++) {
                if (field[temp][temp1].getText().equals("")) {
                    field[temp][temp1].setText("0");
                }
            }
        }
    }//end reset

    /**
     * for choosing an operation to be applied to the matrix
     */
    private void ChooseOperation() {
        int temp;

        for (temp = 0; temp < choosePanel.length; temp++) {
            choosePanel[temp] = new JPanel();
        }

        JLabel chooseLabel = new JLabel("Matrices");
        chooseLabel.setFont(new java.awt.Font("Tahoma", 1, 36));
        choosePanel[0].add(chooseLabel);

        choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer

        choosePanel[6].add(Box.createHorizontalStrut(15)); // a spacer

        showMatrix = new JButton("Mostrar Matriz");
        showMatrix.setPreferredSize(new Dimension(175, 35));
        showMatrix.addActionListener(this);
        choosePanel[2].add(showMatrix);

        plusB = new JButton("Sumar con Matriz");
        plusB.setPreferredSize(new Dimension(175, 35));
        plusB.addActionListener(this);
        choosePanel[2].add(plusB);

        minusB = new JButton("Restar con Matriz");
        minusB.setPreferredSize(new Dimension(175, 35));
        minusB.addActionListener(this);
        choosePanel[2].add(minusB);

        multiplyB = new JButton("Multiplicar con Matriz");
        multiplyB.setPreferredSize(new Dimension(175, 35));
        multiplyB.addActionListener(this);
        choosePanel[3].add(multiplyB);

        nMultiplyB = new JButton("Multiplicar por escalar");
        nMultiplyB.setPreferredSize(new Dimension(175, 35));
        nMultiplyB.addActionListener(this);
        choosePanel[3].add(nMultiplyB);

        nDivisionB = new JButton("Dividir por escalar");
        nDivisionB.setPreferredSize(new Dimension(175, 35));
        nDivisionB.addActionListener(this);
        choosePanel[3].add(nDivisionB);

        transposing = new JButton("Transponer");
        transposing.setPreferredSize(new Dimension(175, 35));
        transposing.addActionListener(this);
        choosePanel[4].add(transposing);

        if (col == row) {
            getValueB = new JButton("Sacar determinante");
            getValueB.setPreferredSize(new Dimension(175, 35));
            getValueB.addActionListener(this);
            choosePanel[4].add(getValueB);

            inverseB = new JButton("Invertir Matriz");
            inverseB.setPreferredSize(new Dimension(175, 35));
            inverseB.addActionListener(this);
            choosePanel[4].add(inverseB);
        }

        newMatrix = new JButton("Nueva Matriz");
        newMatrix.setPreferredSize(new Dimension(275, 35));
        newMatrix.addActionListener(this);
        choosePanel[5].add(newMatrix);

        Object[] object = {"Principal"};
        //JOptionPane.showConfirmDialog(null, choosePanel, "Matrices", JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);
        int choice = JOptionPane.showOptionDialog(null,
                   choosePanel,
                   "Matrices",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.PLAIN_MESSAGE,
                   null,
                   object, object[0]);
        if(choice == 0){
            GUI gui = new GUI();
            gui.setVisible(true);
        }
    }

    /**
     * Method that inherit actionPerformed for button
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == showMatrix) {
            showMatrix(myMatrix, "Your Matrix");
        }
        if (e.getSource() == plusB) {
            matrixPlusMatrix();
        } else if (e.getSource() == minusB) {
            matrixMinusMatrix();
        } else if (e.getSource() == multiplyB) {
            multiplyByMatrix();
        } else if (e.getSource() == inverseB) {
            inverse();
        } else if (e.getSource() == nMultiplyB) {
            guiMultliplyByScaler();
        } else if (e.getSource() == nDivisionB) {
            divideByScaler();
        } else if (e.getSource() == transposing) {
            guiTransposing(myMatrix);
        } else if (e.getSource() == getValueB) {
            guiGetValue();
        } else if (e.getSource() == newMatrix) {
            newMatrix();
        }
    }//end action performed

    /**
     * for showing the matrix (matrix) with the title (title)
     * @param matrix
     * @param title 
     */
    private static void showMatrix(double[][] matrix, String title) {
        int temp, temp1;             //temprature variable

        JPanel choosePanel[] = new JPanel[matrix.length + 1];
        choosePanel[0] = new JPanel();
        choosePanel[0].add(new JLabel(title));

        for (temp = 1; temp <= matrix.length; temp++) {
            choosePanel[temp] = new JPanel();

            for (temp1 = 0; temp1 < matrix[0].length; temp1++) {
                if (matrix[temp - 1][temp1] == -0) {
                    matrix[temp - 1][temp1] = 0;
                }

                choosePanel[temp].add(new JLabel(String.format("%.2f", matrix[temp - 1][temp1])));

                if (temp1 < matrix[0].length - 1) {
                    choosePanel[temp].add(Box.createHorizontalStrut(15)); // a spacer
                }
            }//end col loop
        }//end row loop

        if (col == 0 || row == 0) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
        } else {
            JOptionPane.showMessageDialog(null, choosePanel, null, JOptionPane.PLAIN_MESSAGE, null);
        }
    }//end show Matrix

    /**
     * Do a plusing operation of matrix with other matrix
     */
    private static void matrixPlusMatrix() {
        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
        } else {
            double m2[][] = new double[row][col];
            double sum[][] = new double[row][col];

            if (setElements(m2, "Llena una matriz adicional")) {

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        sum[i][j] = myMatrix[i][j] + m2[i][j];
                    }
                }

                showMatrix(sum, "Resultado");
            }
        }//end else checking
    }// End plus matrix

    /**
     * Do a subtracting operation of matrix and other matrix
     */
    private static void matrixMinusMatrix() {
        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
        } else {
            double m2[][] = new double[row][col];
            double sub[][] = new double[row][col];
            double temp[][] = new double[row][col];

            if (setElements(m2, "Llena la matriz de resta")) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        temp[i][j] = (-1 * m2[i][j]);
                        sub[i][j] = myMatrix[i][j] + temp[i][j];
                    }
                }

                showMatrix(sub, "Resultado");
            }
        }//end else of checking
    }// End minus matrix

    /**
     * Do a multiplication operation between principal matrix and other matrix 
     */
    private static void multiplyByMatrix() {
        JTextField wField = new JTextField(5); //col field
        int col2 = 0;
        double m2[][], results[][];
        int sum;

        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
        } else {
            //design input line
            JPanel choosePanel[] = new JPanel[2];
            choosePanel[0] = new JPanel();
            choosePanel[1] = new JPanel();

            choosePanel[0].add(new JLabel("Ingresa dimensiones"));

            choosePanel[1].add(new JLabel("Filas:"));
            choosePanel[1].add(new JLabel("" + col)); // Set rows as columns (to be able to multiply)
            choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer
            choosePanel[1].add(new JLabel("Columnas:"));
            choosePanel[1].add(wField);
            result = JOptionPane.showConfirmDialog(null, choosePanel, null, JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);

            if (result == 0) {
                if (wField.getText().equals("")) {
                    col2 = 0;
                } else if (isInt(wField.getText())) {
                    col2 = Integer.parseInt(wField.getText());
                }

                m2 = new double[col][col2];
                results = new double[row][col2];
                if (setElements(m2, "Ingresa la matriz a multiplicar")) {
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col2; j++) {
                            sum = 0;
                            for (int k = 0; k < col; k++) {
                                sum += myMatrix[i][k] * m2[k][j];
                            }

                            results[i][j] = sum;
                        }
                    }

                    showMatrix(results, "Resultado");
                }// elements checking
            }// dimensions checking
            else {
                return;
            }
        }// end else of checking
    }// end multiply by matrix method

    /**
     * Do a multiplication operation between matrix and a number by using multliplyByScaler method and show that for the user
     * @see multiplyByScaler
     */
    private static void guiMultliplyByScaler() {
        double[][] results = new double[row][col];
        double x;
        String tempString;

        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
            return;
        }

        tempString = JOptionPane.showInputDialog(null, "Ingresa el escalar a multiplicar");

        if (tempString == null) { //cancel option
            return;
        } else if (!tempString.equals("")) {
            x = Double.parseDouble(tempString);
        } else {
            JOptionPane.showMessageDialog(null, "No has ingresado un escalar");
            return;
        }

        results = multliplyByScaler(myMatrix, x);
        showMatrix(results, "Resultado de la multiplicacion");
    }// end multiply by number

    /**
     * Inner method to multiply the matrix by a scaler
     * @param matrix
     * @param x
     * @return 
     */
    private static double[][] multliplyByScaler(double[][] matrix, double x) {
        double[][] results = new double[row][col];
        int i, j;

        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                results[i][j] = x * matrix[i][j];
            }
        }
        return results;
    }//end multiply by number

    /**
     * Do a dividing operation of matrix and a scaler
     */
    private static void divideByScaler() {
        double[][] results = new double[row][col];
        int i, j;
        double x;
        String tempString;

        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado ninguna matriz");
            return;
        }

        // prompting for the scaler
        tempString = JOptionPane.showInputDialog("Ingresa el escalar para dividir");

        if (tempString == null) { // cancel option
            return;
        } else if (!tempString.equals("")) {
            x = Double.parseDouble(tempString);
        } else {
            JOptionPane.showMessageDialog(null, "No has ingresado el escalar");
            return;
        }

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "Disculpa, no es posible dividir entre 0");
            return;
        }

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                results[i][j] = myMatrix[i][j] / x; // Divide the entire matrix
            }
        }
        showMatrix(results, "Resultado de la division");
    }//end dividing by number

    /**
     * Getting determination's values by using getValue method and show it to the user 
     */
    private static void guiGetValue() {
        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado una matriz");
        } else if (col != row) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una matriz cuadrada");
        } else {
            double result = getValue(myMatrix);

            JOptionPane.showMessageDialog(null, String.format("Determinante = %.2f", getValue(myMatrix)), null, JOptionPane.PLAIN_MESSAGE, null);
        }
    }//end guiGetValue

    /**
     * For swaping two rows in order using to to get determination's value 
     * @param res1
     * @param res2 
     */
    private static void swap(double[] res1, double[] res2) {
        int temp;
        double tempDouble;

        for (temp = 0; temp < res1.length; temp++) {
            tempDouble = res1[temp];
            res1[temp] = res2[temp];
            res2[temp] = tempDouble;
        }

    }

    /**
     * Return determination's values but only inner the program
     * @param matrix
     * @return 
     */
    private static double getValue(double[][] matrix) {
        int temp, temp1, temp2;
        double coeficient;
        double result = 1;
        int sign = 1;       //1 for positive
        //-1 for negative
        int zeroCounter;

        double res[][] = new double[matrix.length][matrix[0].length];

        //copy matrix
        for (temp = 0; temp < matrix.length; temp++) {
            for (temp1 = 0; temp1 < matrix[0].length; temp1++) {
                res[temp][temp1] = matrix[temp][temp1];;
            }

        }

        //rearrange rows
        for (temp = 0; temp < res.length; temp++) {
            if (res[temp][temp] != 0) {
                continue;
            }

            for (temp1 = 1; temp1 < res.length - 1; temp1++) {
                if (res[(temp1 + temp) % matrix.length][temp] != 0) {       //swapping
                    swap(res[temp], res[(temp1 + temp) % res.length]);
                    sign *= -1;
                    break;
                }
            }
        }

        //starting simplifing with gaues method
        for (temp = 1; temp < res.length; temp++) {
            for (temp1 = 0; temp1 < temp; temp1++) {
                //if required element = 0 || division = 0
                if (res[temp][temp1] == 0 || res[temp1][temp1] == 0) {
                    continue;
                } else {
                    zeroCounter = 0;
                    coeficient = res[temp][temp1] / res[temp1][temp1];
                }
                for (temp2 = 0; temp2 < res.length; temp2++) {
                    res[temp][temp2] = res[temp][temp2]
                            - res[temp1][temp2] * coeficient;

                    if (res[temp][temp2] == 0) {
                        zeroCounter++;
                    }
                }
                //over flow zeros
                if (temp < res.length - 1 && zeroCounter > temp) {
                    swap(res[temp], res[temp + 1]);
                    sign *= -1;
                    temp--;
                }
            }
        }

        for (temp = 0; temp < res.length; temp++) {
            result *= res[temp][temp];
        }
        return result * sign;
    }//end getValue

    /**
     * getting determination's values by using transporter method and show it the user
     * @param matrix 
     */
    private static void guiTransposing(double[][] matrix) {
        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado una matriz");
            return;
        }

        double[][] transMatrix = new double[matrix[0].length][matrix.length];

        transMatrix = transposing(matrix);

        showMatrix(transMatrix, "Matriz transpuesta");
    }

    /**
     * Return determinations's transporter but only inner the program
     * @param matrix
     * @return 
     */
    private static double[][] transposing(double[][] matrix) {
        double[][] transportMatrix = new double[matrix[0].length][matrix.length];
        int temp1, temp; //termprature variable

        for (temp = 0; temp < matrix[0].length; temp++) {
            for (temp1 = 0; temp1 < matrix.length; temp1++) {
                transportMatrix[temp][temp1] = matrix[temp1][temp]; //swap (temp, temp1)
            }
        }
        return transportMatrix;
    }

    /**
     * Return the minor of cofactors in order to get inversing matrix
     * @param i
     * @param j
     * @return 
     */
    private static double[][] getMinor(int i, int j) {
        // i for order in row
        //j for order in col
        double[][] results = new double[row - 1][col - 1];
        int row_count = 0, col_count = 0;
        int temp, temp1;

        for (temp = 0; temp < row; temp++) {
            for (temp1 = 0; temp1 < col; temp1++) {
                if (temp != i && temp1 != j) {
                    results[row_count][col_count] = myMatrix[temp][temp1];
                    col_count++;
                }
            }//end col loop
            col_count = 0;
            if (i != temp) {
                row_count++;
            }
        }//end row loop

        return results;
    }

    /**
     * Do inversing operation for determinations
     */
    private static void inverse() {
        if (myMatrix.length < 1) {
            JOptionPane.showMessageDialog(null, "No has ingresado una Matriz");
            return;
        } else if (col != row) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una matriz cuadrada");
            return;
        } else if (getValue(myMatrix) == 0) {
            JOptionPane.showMessageDialog(null, "Tu matriz no tiene una inversa\n\n porque su valor es cero");
            return;
        }

        double[][] inverseMatrix = new double[row][col];
        double[][] minor = new double[row - 1][col - 1];
        double[][] cofactor = new double[row][col];
        double delta; //myMatrix value
        int temp, temp1;

        //get cofactor
        for (temp = 0; temp < row; temp++) {
            for (temp1 = 0; temp1 < col; temp1++) {
                minor = getMinor(temp, temp1);
                double minorValue = getValue(minor);
                cofactor[temp][temp1] = Math.pow(-1.0, temp + temp1) * getValue(minor);
            }
        }//end cofactor looping

        //transport cofactor to get ADJ
        cofactor = transposing(cofactor);
        delta = getValue(myMatrix);       //count Matrix's 

        for (temp = 0; temp < row; temp++) {
            for (temp1 = 0; temp1 < col; temp1++) {
                inverseMatrix[temp][temp1] = cofactor[temp][temp1] / delta;
            }
        }

        showMatrix(inverseMatrix, "Matriz inversa");

    }//end inverse

    private static boolean isInt(String str) {
        int temp;
        if (str.length() == '0') {
            return false;
        }

        for (temp = 0; temp < str.length(); temp++) {
            if (str.charAt(temp) != '+' && str.charAt(temp) != '-'
                    && !Character.isDigit(str.charAt(temp))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDouble(String str) {
        int temp;
        if (str.length() == '0') {
            return false;
        }

        for (temp = 0; temp < str.length(); temp++) {
            if (str.charAt(temp) != '+' && str.charAt(temp) != '-'
                    && str.charAt(temp) != '.'
                    && !Character.isDigit(str.charAt(temp))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Enable the user to enter a new matrix and use the program's features on it
     */
    private static void newMatrix() {
        getDimension();
    }
}//end class

