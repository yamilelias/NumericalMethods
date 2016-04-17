/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yamil Elías
 */
public class NewtonCalculator {
    
    private String result;
        
    /**
     * Unique constructor 
     * 
     */
    public NewtonCalculator(String[] args, int iterations){
        double[] function = new double[args.length]; // Create new space function
        double[] derived_function; // Create new space for derived function
        double x_init = Double.parseDouble(args[0]);
        
        // Save all values of function in the function array
        for(int k=1;k<function.length;k++){function[k] = Double.parseDouble(args[k]);}
        
        derived_function = function.clone(); // This is the most important...
        derived_function = derive_method(derived_function); // Derive function
        
        iterator(x_init, iterations, function, derived_function); // Print function
    }
    
    /**
     * Derive method to obtain f'(x)
     * 
     */
    private double[] derive_method(double[] function){
        double[] derived_function = function; // Generate a new array
        
        // Derivation loop, so every variable will be derived
        for(int k=1;k<function.length;k++){
            if(k!=(function.length-1))
                derived_function[k] = derived_function[k+1] * (k);
            else // When is the first value dx = 0
            derived_function[k] = 0;
        }
        return derived_function; // Return a derived array from the introduced one
    }
    
    /**
     * Get f(x) values
     * 
     */
    private double get_fx_value_method(double[] function, double x_init){ //
        double fx_total=0;
        
        for(int k=1;k<function.length;k++){
            if(k==1)
                fx_total += function[k]; // If there is no x to multiply with
            else
                fx_total += Math.pow(x_init,(k-1))*function[k];
        }
        
        return fx_total; // Return the RESULT of the function, not the function
    }
    
    /**
     * Get g(x) values
     * 
     */
    private double get_derivated_value_method(double[] function, double x_init){
        double gx_total=0;
        
        for(int k=1;k<function.length;k++){
            if(k==1)
                gx_total += function[k]; // If there is no x to multiply with
            else
                gx_total += Math.pow(x_init,(k-1))*function[k];
        }       
        
        return gx_total; // Return the RESULT of the derived function, not the function
    }
    
    
    /**
     * Values printer
     * 
     */
    public void iterator(final double x_init, int iteration_times, double[] function, double[] derived_function){
        double[] fx_values = new double[iteration_times+1];
        double[] gx_values = new double[iteration_times+1];
        double x_init_var = x_init;
        
        fx_values[0] = get_fx_value_method(function, x_init);
        gx_values[0] = get_derivated_value_method(derived_function, x_init);
        
        // First print (header)
        //result= "i \t X \t\t f(x) \t\t f'(x) \t\t err \n";
        result= "0 \t" + x_init_var + "\t\t "+fx_values[0]+" \t\t "+gx_values[0]+" \n";
        
        //System.out.println("i \t X \t f(x) \t f'(x) \t err");
        //System.out.println("0 \t" + x_init_var + "\t "+fx_values[0]+" \t "+gx_values[0]+" \t");
        
        // Loop for printing (depending on the iteration_times set)
        for(int k=1;k<fx_values.length;k++){
            double previous_x = x_init_var;
            x_init_var -= (fx_values[(k-1)] / gx_values[(k-1)]);
            fx_values[k] = get_fx_value_method(function, x_init_var);
            gx_values[k] = get_derivated_value_method(derived_function, x_init_var);
            result += "" + k + "\t" + roundDown3(x_init_var) + "\t\t "+roundDown3(fx_values[k])+" \t\t "+roundDown3(gx_values[k])+" \t\t" + roundDown3(Math.abs(((x_init_var-previous_x)/x_init_var))*100) + "%\n";
        }
    }
    
    /**
     * Auxiliary method to round down double variables
     * 
     */
    private static double roundDown3(double d) {
    return (long) (d * 1e3) / 1e3;
    }

    public String getResult() {
        return result;
    }
}
