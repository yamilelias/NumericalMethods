package horner;

/**
 *
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 1.0
 * @since 2016-04-18
 */
public class HornerCalculator {
    
    /**
     * Int Array that will hold the derivated function
     */
    public int dx[]=new int [5];
    
    /**
     * Evaluate the variables from the function
     * @param v5    x^5
     * @param v4    x^4
     * @param v3    x^3
     * @param v2    x^2
     * @param v1    Linear x
     * @param vc    Constant x
     * @param vi    Initial x
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
     * @param v5    x^5
     * @param v4    x^4
     * @param v3    x^3
     * @param v2    x^2
     * @param v1    Linear x
     * @param vi    Initial x
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
