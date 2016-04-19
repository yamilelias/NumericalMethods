/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonmultivariable;

import javax.swing.JTextArea;

/**
 *
 * @author Yamil Elías
 */
public class NewtonMultivariableCalculator {
    
    //Variables globales
    int i = 1;
    int grado1, grado2;
    double x, y;
    double fx1, fx2;     //funcion evaluada en x
    double dx1, dx2;     //derivada evaluada en x
    double[] funcion1, funcion2;
    double[] resultado1, derivada1;    //este array tiene el resultado de la primera division sintetica
    double[] resultado2, derivada2;   //este array tiene el resultado de la segunda division sintetica
    double[][] jacob, inversa;
    double determinante;
    double[] delta;
    double pitagoras;

    public NewtonMultivariableCalculator(int grado1, int grado2, double x, double y, double[] funcion1, double[] funcion2) {
        this.grado1 = grado1;
        this.grado2 = grado2;
        this.x = x;
        this.y = y;
        this.funcion1 = funcion1;
        this.funcion2 = funcion2;
    }
      
    public String main() 
    {
        String resultArea = "";
        
        resultArea = "    i \t x \t\t\t y \t\t\t ||Delta||\n";
        resultArea += "______________________________________________________________________________________________________________________\n";
        
        do
        { 
            //Realizar cálculos
            evaluarDerivar();
            jacobiano();
            sacarInversa();
            sacarDelta();
            nuevaXY();
            
            //Para motivos de impresión
            String px = ""+x;
            String py = ""+y;
            
            //Para evitar números demasiado largos
            if(px.length()>=17)
                px = px.substring(0,16);
            
            if(py.length()>=17)
                py = py.substring(0,16);
            
            //Para una impresión bonita
            if(px.length()<=6)
            {
                if(py.length()<=7)
                {
                    resultArea += "    " + i + "\t" + px + "\t\t\t" + py + "\t\t\t"+ pitagoras + "\n";
                }
                else
                {
                    resultArea += "    " + i + "\t" + px + "\t\t\t" + py + "\t\t"+ pitagoras + "\n";
                }
            }
            else if(py.length()<=7)
            {
               if(px.length()<=7)
                {
                    resultArea += "    " + i + "\t" + px + "\t\t\t" + py + "\t\t\t"+ pitagoras + "\n";
                }
                else
                {
                    resultArea += "    " + i + "\t" + px + "\t\t" + py + "\t\t\t"+ pitagoras + "\n";
                }
            }
            else
            {
                resultArea += "    " + i + "\t" + px + "\t\t" + py + "\t\t"+ pitagoras + "\n";
            }
                
                
            
            i++;
        }while(pitagoras > .0001);
        
        return resultArea;
    }
	
    private void evaluarDerivar() {
		resultado1 = Horner(x, grado1, funcion1);
		fx1 = resultado1[grado1-1] - y;
		//System.out.println("La funcion evaluada en x:" + x + ", y:" + y + " es igual a " + fx1);
		
		derivada1 = Horner(x, grado1, resultado1);
		dx1 = derivada1[grado1-2];    //es grado-2 porque ese viene siendo el valor de la derivada evaluada en x.
		//System.out.println("La derivada evaluada en x:" + x + " es igual a " + dx1);
	
		resultado2 = Horner(x, grado2, funcion2);
		fx2 = resultado2[grado2-1] - y;
		//System.out.println("La funcion evaluada en x:" + x + ", y:" + y + " es igual a " + fx2);
		
		derivada2 = Horner(x, grado2, resultado2);
		dx2 = derivada2[grado2-2];    //es grado-2 porque ese viene siendo el valor de la derivada evaluada en x.
		//System.out.println("La derivada evaluada en x:" + x + " es igual a " + dx2);  
	}
	
	private double[] Horner(double x, int grado, double[] funcion) {
		double[] horner = new double[grado-1];
		double[] resultado = new double[grado];
		resultado[0] = funcion[0];
                //System.out.println("resultado[0]"+resultado[0]);
		for(int k=0; k<grado-1; k++) {
			horner[k] = x * resultado[k];
                        //System.out.println("horner[" + (k) + "]: " + horner[k]);
			resultado[k+1] = funcion[k+1] + horner[k];
                        //System.out.println("resultado[" + (k+1) + "]: " + resultado[k+1]);
		}
                
                //System.out.println(""+Arrays.toString(resultado));
		return resultado;
	}
	
	private void jacobiano() {
		jacob = new double[2][2];
		//x
		jacob[0][0] = dx1;
		jacob[1][0] = dx2;
		//y
		jacob[0][1] = -1;
		jacob[1][1] = -1;
	}
	
	private void sacarInversa() {
		determinante = (jacob[0][0]*jacob[1][1])-(jacob[0][1]*jacob[1][0]);
		inversa = new double[2][2];
		inversa[0][0] = jacob[1][1]/determinante;
		inversa[0][1] = -jacob[0][1]/determinante;
		inversa[1][0] = -jacob[1][0]/determinante;
		inversa[1][1] = jacob[0][0]/determinante;
	}

	private void sacarDelta() {
		delta = new double[2];
		delta[0] = (inversa[0][0]*fx1)+(inversa[0][1]*fx2);
		//System.out.println("DELTA1: " + delta[0]);
		delta[1] = (inversa[1][0]*fx1)+(inversa[1][1]*fx2);
		//System.out.println("DELTA2: " + delta[1]);
		pitagoras = Math.abs(Math.sqrt(Math.pow(delta[0],2)+Math.pow(delta[1],2)));
		//System.out.println(pitagoras);
	}
	
	private void nuevaXY() {
		x = x - delta[0];
		y = y - delta[1];
	}
    
}
