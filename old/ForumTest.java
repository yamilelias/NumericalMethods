/**
* @(#)Newtonlastest.java
*
* Newtonlastest application
*

* @version	1.00 2008/8/15
*/
import java.io.*;
import java.text.DecimalFormat;

public class ForumTest {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Format to display with six decimal places
		DecimalFormat root = new DecimalFormat("####0.000000");
		
		//Format to display with seven decimal places
		DecimalFormat rootseven = new DecimalFormat("####0.0000000");
		
		//This is the const to select delta
		final double select_delta = 0.5;
		double xnew;
		double fxold;
		double fdashxold;
		double absfxnew;
		int iteration;
		System.out.print("Enter the initial approximation for the root: ");
		double xold = Double.parseDouble(in.readLine());
		iteration =0;
		System.out.print("step	x	fx\n");
		System.out.print("--------------------------------------------------------------------------\n");
	
		do
		{
			// determine f(xold) and f·xold)
			fxold = func(xold);
			// printf temp result 
			System.out.print( "\n");
			System.out.print( iteration );
			System.out.print( " " + root.format(xold) );
			System.out.print( " " + rootseven.format(fxold) );
			iteration = iteration + 1;
			//fdashxold = derivative_func(xold);

			//if calculate by approximate derivative then comment above line, and uncomment below line 
			fdashxold = appro_derivative(xold, select_delta);
			xnew = xold - (fxold/fdashxold);
			absfxnew = func(xnew);
			if(absfxnew < 0)
			{
				absfxnew = -absfxnew;
			}
			xold = xnew;
	
			// check for convergence using the criterion |f(x)| < 0.000001
		}
		while (absfxnew > 0.000001);
	
		System.out.println("\n");
		System.out.print( iteration );
		System.out.print(" " + root.format(xold) );
		System.out.print( " "+ rootseven.format(func(xold)) );
		System.out.println();
		System.out.print("\nroot to six decimal places is :");
		System.out.print(root.format(xnew));
	}

	public static double func(double x)
	{
		return (0.66 *pow_int(x, 5) - 8.7 *pow_int(x, 4) + 42 *pow_int(x, 3) - 90 *x *x + 80 *x -24);
	}

	public static double derivative_func(double x)
	{
		return (3.3 *pow_int(x, 4) - 34.8 *pow_int(x, 3) + 126 *pow_int(x, 2) - 180 *x + 80);
	}

	public static double appro_derivative(double x,	double delta)
	{
		return (func(x+delta) - func(x))/delta;
	}

	public static double pow_int(double x, int n)
	{
		double result = 1;
		int i;

		for(i = 0; i < n; i++)
		{
			result *= x;
		}
		return result;
	}
}