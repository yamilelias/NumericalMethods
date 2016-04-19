/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.metodos;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 *
 * @author astaroth
 */
public class NewtonRaphson {
    private double J[][]= new double[2][2]; 
    private double F[][]=new double[2][2];
    private double Delta[][]=new double[2][2];
    public double[][] j(String  f1,String  f2, String  dx, String  dy, String dx2, String  dy2, double x, double y){
        //System.out.println(dx+" "+x);
        J[0][0]=evaluar(x,y,dx);
        J[0][1]=evaluar(x,y,dy);
        J[1][0]=evaluar(x,y,dx2);
        J[1][1]=evaluar(x,y,dy2);
        return J;
    }
    
    public double evaluar(double x, double y, String funcion) {
        Expression e = new ExpressionBuilder(funcion)
                .variables("x", "y")
                .build()
                .setVariable("x", x)
                .setVariable("y", y);
        //System.out.println(e.evaluate());
        return e.evaluate();
    }
    
    public double[][] f(String  f1,String  f2, double x, double y){
        F[0][0]=evaluar(x,y,f1);
        F[1][0]=evaluar(x,y,f2);
        F[0][1]=0;
        F[1][1]=0;
        return F;
    }
    
    
    public double[][] delta(){
        double i[][];
         i=inversa(J,J.length);
         for (int j = 0; j < 2; j++) {
                for (int n = 0; n < 2; n++) {
                    Delta[j][n]=0;
                }
            }
         Delta=multiplicacion(i, F, 2);
        return Delta;
    }
    public double proximoValor(double x, double delta){
        double c= x-delta;
        return c;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    public double[][] multiplicacion(double a[][], double b[][], int tamano) {
        double c[][] = new double[tamano][tamano];

        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                for (int k = 0; k < tamano; k++) {

                    c[i][n] += a[i][k] * b[k][n];
                }
            }
        }

        return c;
    }
    double[][] inversa(double x[][], int f) {
		double resp[][]=new double[1][1];
		double resp2[][]=new double[1][1];
		
		try {
			resp=new double [f][f];
			resp2=new double[f][f];
		
			for(int i=0; i<f; i++) {
				resp[i][i]=1.0;
			}
		
			for(int k=0; k<f-1; k++) {
				for(int i=k+1; i<f; i++) {
					for(int s=0; s<f; s++) {
						resp[i][s]-=x[i][k]*resp[k][s]/x[k][k];
					}
					for(int j=k+1; j<f; j++) {
						x[i][j]-=x[i][k]*x[k][j]/x[k][k];
					}
				}
			}
		
			for(int s=0; s<f; s++){
            	resp2[f-1][s]=resp[f-1][s]/x[f-1][f-1];
            	for(int i=f-2; i>=0; i--){
                	resp2[i][s]=resp[i][s]/x[i][i];
                	for(int k=f-1; k>i; k--){
                    	resp2[i][s]-=x[i][k]*resp2[k][s]/x[i][i];
                	}
            	}
        	}
        }catch (NegativeArraySizeException e) {
			System.out.println("\tERROR: TAMANO DE LA MATRIZ NEGATIVO");
		}
        return resp2;
	}
    
}
