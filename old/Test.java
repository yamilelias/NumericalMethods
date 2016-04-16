/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

/**
 *
 * @author Yamil Elías
 */
public class Test {
    
    public static void main(String[] args){
        double[] function = new double[args.length];
        double[] derived_function;
        double fx_total, gx_total;
        double x_init = Double.parseDouble(args[0]);
        
        System.out.println("x_init is:" + x_init);
        for(int k=1;k<function.length;k++){
                function[k] = Double.parseDouble(args[k]);
                System.out.println("x"+ (k-1) + " = " +function[k]);
        }
        System.out.println("");
        
        derived_function = function.clone();
        
        fx_total = get_fx_value_method(function, x_init);
        
        System.out.println("");
        System.out.println("" + Arrays.toString(function));
        System.out.println("" + Arrays.toString(derived_function));
        
        derived_function = derive_method(derived_function);
        
        System.out.println("" + Arrays.toString(function));
        System.out.println("" + Arrays.toString(derived_function));
        
        gx_total = get_derivated_value_method(derived_function, x_init);
        
        System.out.println("");
        
        iterator(x_init, 30, function, derived_function);
        //get_iteration_values(10, x_init, normal_function, derived_function);
        
    }
    
    /*public static void get_iteration_values(final int iteration_times,final double x_init,final double[] function,final double[] derived_function){
        
        double x_var = x_init;
        System.out.println("" + Arrays.toString(function));
        System.out.println("" + Arrays.toString(derived_function));
        System.out.println("i \t X \t f(x) \t f'(x) \t err");
        System.out.println( 0 + "\t"+ x_var +"\t"+ get_fx_value_method(function, x_var) +"\t"+ get_derivated_value_method(function, x_var) +"\t");
        
        for(int k=1; k<(iteration_times+1);k++){
            x_var -= (fx_values[(k-1)] / gx_values[(k-1)]);
            System.out.println( k + "\t"+ x_var +"\t"+ get_fx_value_method(function, x_var) +"\t"+ get_derivated_value_method(function, x_var) +"\t");
        }
    }*/
    
    private static double[] derive_method(double[] function){
        double[] derived_function = function;
        
        System.out.println("derived function");
        for(int k=1;k<function.length;k++){
            if(k!=(function.length-1))
                derived_function[k] = derived_function[k+1] * (k);
            else
            derived_function[k] = 0;
            
            //System.out.println("X" + (k-1) + " = " + derived_function[k]);
        }
        return derived_function;
    }
    
    private static double get_fx_value_method(double[] function, double x_init){ // LISTO
        double fx_total=0;
        
        for(int k=1;k<function.length;k++){
            //System.out.println("pre "+ function[k]);
            //System.out.println("pre "+ x_init);
            if(k==1)
                fx_total += function[k];
            else
                fx_total += Math.pow(x_init,(k-1))*function[k];
            
            //System.out.println("fx #" + k + ": " + fx_total);    
            //System.out.println("post "+ function[k]);
        }
        
        //System.out.println("The total is: " + fx_total);
        
        return fx_total;
    }
    
    private static double get_derivated_value_method(double[] function, double x_init){ //LISTO
        double gx_total=0;
        
        for(int k=1;k<function.length;k++){
            //System.out.println("pre "+ function[k]);
            
            if(k==1)
                gx_total += function[k];
            else
                gx_total += Math.pow(x_init,(k-1))*function[k];
            
            //System.out.println("fx #" + k + ": " + gx_total);    
            //System.out.println("post "+ function[k]);
        }       
        
        //System.out.println("The total is: " + gx_total);
        
        return gx_total;
    }
    
    public static void iterator(final double x_init, int iteration_times, double[] function, double[] derived_function){
        double[] fx_values = new double[iteration_times+1];
        double[] gx_values = new double[iteration_times+1];
        double x_init_var = x_init;
        
        fx_values[0] = get_fx_value_method(function, x_init);
        gx_values[0] = get_derivated_value_method(derived_function, x_init);
        
        System.out.println("i \t X \t f(x) \t f'(x) \t err");
        System.out.println("0 \t" + x_init_var + "\t "+fx_values[0]+" \t "+gx_values[0]+" \t");
        
        for(int k=1;k<fx_values.length;k++){
            double previous_x = x_init_var;
            x_init_var -= (fx_values[(k-1)] / gx_values[(k-1)]);
            fx_values[k] = get_fx_value_method(function, x_init_var);
            gx_values[k] = get_derivated_value_method(derived_function, x_init_var);
            System.out.println("" + k + "\t" + roundDown3(x_init_var) + "\t "+roundDown3(fx_values[k])+" \t "+roundDown3(gx_values[k])+" \t" + roundDown3(Math.abs(((x_init_var-previous_x)/x_init_var))*100) + "%");
            //System.out.println("x = " + x_init_var);   
        }
    }
    
    public static double roundDown3(double d) {
    return (long) (d * 1e3) / 1e3;
}
}
