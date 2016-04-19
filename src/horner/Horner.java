/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package horner;

/**
 *
 * @author Yamil Elías
 */
public class Horner {
    
    // Global Variables
    public int dx[]=new int [5];
    
    /**
     * Evaluate the variables from the function
     * @param v5
     * @param v4
     * @param v3
     * @param v2
     * @param v1
     * @param vc
     * @param vi
     * @return 
     */
    public int evaluate (int v5, int v4, int v3, int v2, int v1, int vc,int vi){
        int constant=0;        
        constant= v5 * vi;        
        constant= (v4 + constant) * vi;        
        constant= (v3 + constant) * vi;        
        constant= (v2 + constant) * vi;       
        constant= (v1 + constant) * vi;        
        constant= vc + constant;
        
        return constant;
    }
    
    /**
     * Method to derivate the function that was provided by the user
     * @param v5
     * @param v4
     * @param v3
     * @param v2
     * @param v1
     * @param vi
     * @return 
     */
    public String derivate (int v5, int v4, int v3, int v2, int v1,int vi){
        // Derivated values
        int dv5,dv4,dv3,dv2,dv1;
        
        dv5 = v5 * 5;
        dx[0] = dv5;
        dv4 = v4 * 4;
        dx[1] = dv4;
        dv3 = v3 * 3;
        dx[2] = dv3;
        dv2 = v2 * 2;
        dx[3] = dv2;
        dv1 = v1 * 1;
        dx[4] = dv1;
        String derivated_function=(dv5 + "X^4 + " + dv4 + "X^3 + " + dv3 + "X^2 + " + dv2 + "X + " + dv1);
        return derivated_function;
    }
    
}
