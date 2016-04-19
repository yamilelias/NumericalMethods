package polynomial;

import java.util.ArrayList;
import java.util.Iterator;
import polynomial.Pair;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class MatrixFunctions {
    /**
     * Constructor
     */    
    private MatrixFunctions() {
    }

    private static void gj_divide(double[][] A, int i, int j, int m) {
        int q = j + 1;
        while (q < m) {
            double[] arrd = A[i];
            int n = q++;
            arrd[n] = arrd[n] / A[i][j];
        }
        A[i][j] = 1.0;
    }

    private static void gj_eliminate(double[][] A, int i, int j, int n, int m) {
        for (int k = 0; k < n; ++k) {
            if (k == i || A[k][j] == 0.0) continue;
            for (int q = j + 1; q < m; ++q) {
                double[] arrd = A[k];
                int n2 = q;
                arrd[n2] = arrd[n2] - A[k][j] * A[i][q];
            }
            A[k][j] = 0.0;
        }
    }

    private static void gj_echelonize(double[][] A) {
        int n = A.length;
        int m = A[0].length;
        int i = 0;
        for (int j = 0; i < n && j < m; ++j) {
            int k;
            for (k = i; k < n && A[k][j] == 0.0; ++k) {
            }
            if (k >= n) continue;
            if (k != i) {
                double[] swap = A[i];
                A[i] = A[k];
                A[k] = swap;
            }
            if (A[i][j] != 1.0) {
                MatrixFunctions.gj_divide(A, i, j, m);
            }
            MatrixFunctions.gj_eliminate(A, i, j, n, m);
            ++i;
        }
    }

    public static double regress(double x, ArrayList<Double> terms) {
        double a = 0.0;
        int exp = 0;
        Iterator<Double> i$ = terms.iterator();
        while (i$.hasNext()) {
            double term = i$.next();
            a += term * Math.pow(x, exp);
            ++exp;
        }
        return a;
    }

    public static double corr_coeff(ArrayList<Pair> data, ArrayList<Double> terms) {
        double r = 0.0;
        int n = data.size();
        double sx = 0.0;
        double sx2 = 0.0;
        double sy = 0.0;
        double sy2 = 0.0;
        double sxy = 0.0;
        for (Pair pr : data) {
            double x = MatrixFunctions.regress(pr.x, terms);
            double y = pr.y;
            sx += x;
            sy += y;
            sxy += x * y;
            sx2 += x * x;
            sy2 += y * y;
        }
        double div = Math.sqrt((sx2 - sx * sx / (double)n) * (sy2 - sy * sy / (double)n));
        if (div != 0.0) {
            r = Math.pow((sxy - sx * sy / (double)n) / div, 2.0);
        }
        return r;
    }

    public static double std_error(ArrayList<Pair> data, ArrayList<Double> terms) {
        double r = 0.0;
        int n = data.size();
        if (n > 2) {
            double a = 0.0;
            for (Pair pr : data) {
                a += Math.pow(MatrixFunctions.regress(pr.x, terms) - pr.y, 2.0);
            }
            r = Math.sqrt(a / (double)(n - 2));
        }
        return r;
    }

    /**
     * Method that compute coefficients
     * @param data ArrayList<Pair>
     * @param p integer value
     * @return ArrayList<Double>
     */
    public static ArrayList<Double> compute_coefficients(ArrayList<Pair> data, int p) {
        int r; // Aux int
        int n = data.size(); // Size of the ArrayList
        int rs = 2 * ++p - 1; // (2 * (p+1)) THEN p-1
        double[][] m = new double[p][p + 1]; // Multidimension array
        double[] mpc = new double[rs]; 
        mpc[0] = n; // First of double[] will be equal to data size
        for (Pair pr : data) { // For every pair in data
            for (r = 1; r < rs; ++r) {
                double[] arrd = mpc;
                int n2 = r;
                arrd[n2] = arrd[n2] + Math.pow(pr.x, r);
            }
            double[] arrd = m[0];
            int n3 = p;
            arrd[n3] = arrd[n3] + pr.y;
            for (r = 1; r < p; ++r) {
                double[] arrd2 = m[r];
                int n4 = p;
                arrd2[n4] = arrd2[n4] + Math.pow(pr.x, r) * pr.y;
            }
        }
        for (r = 0; r < p; ++r) {
            for (int c = 0; c < p; ++c) {
                m[r][c] = mpc[r + c];
            }
        }
        MatrixFunctions.gj_echelonize(m);
        ArrayList<Double> terms = new ArrayList<Double>();
        boolean j = false;
        for (double[] mc : m) {
            terms.add(mc[p]);
        }
        return terms;
    }
}

