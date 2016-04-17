public class InvokeNewton {
  // Define the given constants
  static double g = 9.81, Ds = 0.198, uj = 805.9, W = 0.0557;
  // Combine the constants into to coefficients of the polynomial
  // Executed during class creation
  static double A=0.024*Math.pow(g*Ds/(uj*uj), 1.0/3), B=0.2, C= Math.pow(2.85/W,2.0/3);
  /* The original problem asks for the solution of 
   * A*y^(5/3)+B*y^(2/3)-C, introduce x=y^(1/3) <=> y=x^3
   * The equation to solve now is f(x)=Ax^5+Bx^2-C=0, 
   * a polynomial with derivative f'(x)=5Ax^4+2Bx
   */


  public static void main(String argv[]) {
    // set the precision with some buffer to the full 1e-16
    double del = 1e-12;
    double xx = 0 ;
    double dx =0;
    /* -------------------
     * initial point obtained by solving Ax^5-C=0
     * Now f(0)<0, f(x)>0 and f is convex monotone increasing
     * for x>0, so Newtons method produces a decreasing 
     * sequence of points quadratically converging to
     * the root of the equation.
     */
    double x= Math.pow(C/A,1.0/5);
    int k = 0;
    while (Math.abs(xx-x) > del && k<20) {
      // Standard Newton method
      dx = f(x)/d(x);
      xx=x;
      x =x - dx;
      k++;

      System.out.println("Iteration number: " + k);
      System.out.print("Root obtained: " + x);
      // the number of interest is y=x^3
      System.out.println(" solution Y="+Math.pow(x,3));
      System.out.println("Estimated error: " + Math.abs(xx-x));
    }
  }

  // Method to provide function f(x)

  public static double f(double x) {
    return A*Math.pow(x,5)+B*Math.pow(x,2)-C;
  }

  // Method to provide the derivative f'(x).

  public static double d(double x) { 
    return 5*A*Math.pow(x,4)+2*B*x;
  }

}