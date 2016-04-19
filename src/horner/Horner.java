/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.metodos;

/**
 *
 * @author astaroth
 */
public class Horner {
    public int evaluar (int v5, int v4, int v3, int v2, int v1, int vc,int vi){
        int c=0;        
        c=v5*vi;        
        c=(v4+c)*vi;        
        c=(v3+c)*vi;        
        c=(v2+c)*vi;       
        c=(v1+c)*vi;        
        c=vc+c;
        
        return c;
    }
    public int dx[]=new int [5];
    public String derivar (int v5, int v4, int v3, int v2, int v1,int vi){
        int dv5,dv4,dv3,dv2,dv1;
        
        dv5=v5*5;
        dx[0]=dv5;
        dv4=v4*4;
        dx[1]=dv4;
        dv3=v3*3;
        dx[2]=dv3;
        dv2=v2*2;
        dx[3]=dv2;
        dv1=v1*1;
        dx[4]=dv1;
        String derivada=(dv5+"X^4+"+dv4+"X^3+"+dv3+"X^2+"+dv2+"X+"+dv1);
        return derivada;
    }
    
}
