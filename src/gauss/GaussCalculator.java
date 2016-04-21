package gauss;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 1.0
 * @since 2016-04-20
 */
public class GaussCalculator {

    private int size;
    private double[][] matrix;
    JTextArea area;

    /**
     * Constructor
     *
     * @param size      Size of the matrix
     * @param matrix    Matrix that will be used to calculate values
     * @param area      JTextArea where we will print everything
     * @see JTextArea
     */
    public GaussCalculator(int size, double[][] matrix, JTextArea area) {
        this.size = size;
        this.matrix = matrix;
        this.area = area;
    }

    /**
     * This method calculates the matrix and the result values
     */
    public void calculateValues() {

        area.append("V \t W \t X \t Y \t Z \t R \n"); // Set title

        double[] value = new double[6];
        double values_making_zero; // Represents the different values that will be made zero below the pivot
        double pivot_first_value; // First value of the element, that will serve as pivot

        /*
         * The next part is repetitive, it depends on the size of the Matrix.
         * So if you are reviewing this code, you only need to read the first part,
         * the next parts are only the same but with more iterations.
         */
        pivot_first_value = matrix[0][0];
        for (int i = 0; i < 6; i++) {
            matrix[0][i] = matrix[0][i] / pivot_first_value;
        }

        values_making_zero = matrix[1][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * -values_making_zero;
            matrix[1][i] = value[i] + matrix[1][i];
        }
        values_making_zero = matrix[2][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * -values_making_zero;
            matrix[2][i] = value[i] + matrix[2][i];
        }
        values_making_zero = matrix[3][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * -values_making_zero;
            matrix[3][i] = value[i] + matrix[3][i];
        }
        values_making_zero = matrix[4][0];
        for (int i = 0; i < 6; i++) {
            value[i] = matrix[0][i] * -values_making_zero;
            matrix[4][i] = value[i] + matrix[4][i];
        }
        printTextArea();

        pivot_first_value = matrix[1][1];
        if (pivot_first_value == 0) // If the pivot value is 0, then there will be multiple solutions
        {
            multipleSolutionMethod(size);
        } else {
            for (int i = 0; i < 6; i++) {
                matrix[1][i] = matrix[1][i] / pivot_first_value;
            }
            values_making_zero = matrix[0][1];

            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[0][i] = value[i] + matrix[0][i];
            }
            values_making_zero = matrix[2][1];

            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[2][i] = value[i] + matrix[2][i];
            }
            values_making_zero = matrix[3][1];

            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[3][i] = value[i] + matrix[3][i];
            }
            values_making_zero = matrix[4][1];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[4][i] = value[i] + matrix[4][i];
            }
            printTextArea();
        }

        pivot_first_value = matrix[1][1];
        if (pivot_first_value == 0) {
            multipleSolutionMethod(size);
        } else {
            for (int i = 0; i < 6; i++) {
                matrix[1][i] = matrix[1][i] / pivot_first_value;
            }

            values_making_zero = matrix[0][1];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;

                matrix[0][i] = value[i] + matrix[0][i];

            }

            values_making_zero = matrix[2][1];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[2][i] = value[i] + matrix[2][i];

            }
            values_making_zero = matrix[3][1];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[3][i] = value[i] + matrix[3][i];

            }
            values_making_zero = matrix[4][1];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[1][i] * -values_making_zero;
                matrix[4][i] = value[i] + matrix[4][i];

            }
            printTextArea();    // So it will print in the text area
        }

        pivot_first_value = matrix[(size - 1)][(size - 1)];
        if (pivot_first_value == 0) {
            multipleSolutionMethod(size);
        } else {
            for (int i = 0; i < 6; i++) {
                matrix[3][i] = matrix[3][i] / pivot_first_value;
            }
            values_making_zero = matrix[0][(size - 1)];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * -values_making_zero;
                matrix[0][i] = value[i] + matrix[0][i];

            }
            values_making_zero = matrix[1][(size - 1)];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * -values_making_zero;
                matrix[1][i] = value[i] + matrix[1][i];

            }

            values_making_zero = matrix[2][(size - 1)];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * -values_making_zero;
                matrix[2][i] = value[i] + matrix[2][i];

            }
            values_making_zero = matrix[4][(size - 1)];
            for (int i = 0; i < 6; i++) {
                value[i] = matrix[3][i] * -values_making_zero;
                matrix[4][i] = value[i] + matrix[4][i];

            }
            printTextArea();
        }

        //This switch is to show the result depending on the matrix size
        switch (size) {
            case 2: {
                if (matrix[0][0] == 1 && matrix[1][1] == 1) {
                    area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5]);
                } else if (matrix[1][0] == 0 && matrix[1][1] == 0 && matrix[1][5] > 0) {
                    area.append("Inconsistencia");
                }
                break;
            }
            case 3: {
                if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1) {
                    area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                            + matrix[2][5]);
                } else if (matrix[2][0] == 0 && matrix[2][1] == 0 && matrix[2][2] == 0
                        && matrix[2][5] > 0) {
                    area.append("Inconsistencia");
                }
                break;
            }
            case 4: {
                if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1 && matrix[3][3] == 1) {
                    area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                            + matrix[2][5] + "\n Y= " + matrix[3][5]);
                } else if (matrix[3][0] == 0 && matrix[3][1] == 0 && matrix[3][2] == 0 && matrix[3][3] == 0
                        && matrix[3][5] > 0) {
                    area.append("Inconsistencia");
                }
                break;
            }
            case 5: {
                if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1 && matrix[3][3] == 1 && matrix[4][4] == 1) {
                    area.append(" V= " + matrix[0][5] + "\n W= " + matrix[1][5] + "\n X= "
                            + matrix[2][2] + "\n Y= " + matrix[3][5] + "\n Z= " + matrix[4][5]);
                } else if (matrix[4][0] == 0 && matrix[4][1] == 0 && matrix[4][2] == 0 && matrix[4][3] == 0
                        && matrix[4][4] == 0 && matrix[4][5] > 0) {
                    area.append("Inconsistencia");
                }
                break;
            }
            default: {
                area.append("Algo fue mal...");
                break;
            }
        }
    }

    /**
     * This method is for printing on the Text Area
     */
    public void printTextArea() {
        DecimalFormat decimals = new DecimalFormat("0.000");
        String result = "";

        for (int i = 0; i < 5; i++) {
            for (int m = 0; m < 6; m++) {
                result += decimals.format(matrix[i][m]) + " \t ";
            }
            result += "\n"; // Next line
        }
        result += "\n";
        area.append(result);

    }

    /**
     * When a matrix has multiple solutions, then this method take place
     *
     * @param size Size of the original matrix
     */
    public void multipleSolutionMethod(int size) {
        int i = Integer.parseInt(JOptionPane.showInputDialog("Multiple solucion Ingrese un numero: "));
        double[] m = new double[5];
        m[size - 1] = i;
        for (int n = size - 1; n > 0; n--) {
            m[n - 1] = matrix[n - 1][5] - matrix[n][size - 1] * i;
        }
        for (int n = 0; n < size; n++) {
            area.append(m[n] + "\n");
        }
        area.append("\n");
    }
}
