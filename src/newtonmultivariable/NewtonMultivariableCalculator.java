package newtonmultivariable;

import javax.swing.JTextArea;

/**
 * In numerical analysis, Newton's method (also known as the Newton–Raphson method), named after Isaac Newton and Joseph Raphson, is a method for finding successively better approximations to the roots (or zeroes) of a real-valued function.
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 1.0
 * @since 2016-04-20
 */
public class NewtonMultivariableCalculator {

    /**
     * Used for iterations inside the program
     */
    private int i = 1;
    /**
     * Grades used for the function
     */
    private int grado1, grado2;
    /**
     * Variables for the functions
     */
    private double x, y;
    /**
     * Functions evaluated in x
     */
    private double fx1, fx2;
    /**
     * Derivated functions evaluated in y
     */
    private double dx1, dx2;
    /**
     * Functions used for the program
     */
    private double[] funcion1, funcion2;
    /**
     * Arrays of the results and the first function and his derivated function
     */
    private double[] resultado1, derivada1;
    /**
     * Arrays of the results and the sencond function and his derivated function
     */
    private double[] resultado2, derivada2;
    /**
     * Two dimensional array used for the calculation of the result
     */
    private double[][] jacob, inversa;
    /**
     * Determinant value
     */
    private double determinante;
    /**
     * Array of delta values
     */
    private double[] delta;
    /**
     * Value of using the Pitagoras formula
     */
    private double pitagoras;
    /**
     * Result of the calculation
     */
    private String result;

    /**
     * Constructor for the calculator
     *
     * @param grado1 First function grade
     * @param grado2 Second function grade
     * @param x Value of x
     * @param y Value of y
     * @param funcion1 First function to be evaluated
     * @param funcion2 Second function to be evaluated
     */
    public NewtonMultivariableCalculator(int grado1, int grado2, double x, double y, double[] funcion1, double[] funcion2) {
        this.grado1 = grado1;
        this.grado2 = grado2;
        this.x = x;
        this.y = y;
        this.funcion1 = funcion1;
        this.funcion2 = funcion2;
    }

    /**
     * Set the iterations and values to be printed
     */
    public void main() {
        result = "";

        do {
            //Make calculations
            evaluateDerivate();
            jacobiano();
            sacarInversa();
            sacarDelta();
            nuevaXY();

            //For printing only
            String px = "" + x;
            String py = "" + y;

            //To avoid very large numbers
            if (px.length() >= 17) {
                px = px.substring(0, 16);
            }

            if (py.length() >= 17) {
                py = py.substring(0, 16);
            }

            result += "     " + i + "\t" + roundDown3(Double.parseDouble(px)) + "\t" + roundDown3(Double.parseDouble(py)) + "\t" + roundDown3(pitagoras) + "\n";

            i++;
        } while (pitagoras > .0001);
    }

    /**
     * This method evaluates the derivated
     */
    private void evaluateDerivate() {
        resultado1 = Horner(x, grado1, funcion1);
        fx1 = resultado1[grado1 - 1] - y;

        derivada1 = Horner(x, grado1, resultado1);
        dx1 = derivada1[grado1 - 2];    // Is grado-2 because is the value of the derivated evaluated in x

        resultado2 = Horner(x, grado2, funcion2);
        fx2 = resultado2[grado2 - 1] - y;

        derivada2 = Horner(x, grado2, resultado2);
        dx2 = derivada2[grado2 - 2];    // Is grado-2 because is the value of the derivated evaluated in x
    }

    /**
     * This method makes the horner calulation for using in the program
     * @param x         Value of x
     * @param grado     Function grade
     * @param funcion   Function to be used
     * @return          Returns the result function that was evaluated by the horner method
     */
    private double[] Horner(double x, int grado, double[] funcion) {
        double[] horner = new double[grado - 1];
        double[] resultado = new double[grado];
        resultado[0] = funcion[0];
        for (int k = 0; k < grado - 1; k++) {
            horner[k] = x * resultado[k];
            resultado[k + 1] = funcion[k + 1] + horner[k];
        }

        return resultado;
    }

    /**
     * Method that will get the jacobian for the program
     */
    private void jacobiano() {
        jacob = new double[2][2];
        //x
        jacob[0][0] = dx1;
        jacob[1][0] = dx2;
        //y
        jacob[0][1] = -1;
        jacob[1][1] = -1;
    }

    /**
     * Gets the inverse to continue with the calculation
     */
    private void sacarInversa() {
        determinante = (jacob[0][0] * jacob[1][1]) - (jacob[0][1] * jacob[1][0]);
        inversa = new double[2][2];
        inversa[0][0] = jacob[1][1] / determinante;
        inversa[0][1] = -jacob[0][1] / determinante;
        inversa[1][0] = -jacob[1][0] / determinante;
        inversa[1][1] = jacob[0][0] / determinante;
    }

    /**
     * Get the delta value for the calculation
     */
    private void sacarDelta() {
        delta = new double[2];
        delta[0] = (inversa[0][0] * fx1) + (inversa[0][1] * fx2);
        //System.out.println("DELTA1: " + delta[0]);
        delta[1] = (inversa[1][0] * fx1) + (inversa[1][1] * fx2);
        //System.out.println("DELTA2: " + delta[1]);
        pitagoras = Math.abs(Math.sqrt(Math.pow(delta[0], 2) + Math.pow(delta[1], 2)));
        //System.out.println(pitagoras);
    }

    /**
     * Gets the new values for x and y
     */
    private void nuevaXY() {
        x = x - delta[0];
        y = y - delta[1];
    }

    /**
     * Method for rounding up numbers
     * @param d Number to round up
     * @return  Returns the number rounded up
     */
    private static double roundDown3(double d) {
        return (long) (d * 1e3) / 1e3;
    }

    /**
     * Getter of the printing result
     * @return Returns the string that contains the information to print
     */
    public String getResult() {
        return result;
    }
}
