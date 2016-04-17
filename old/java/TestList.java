
import java.util.Arrays;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yamil Elías
 */
public class TestList {
    public static void main(String[] args){
        ArrayList<Double> functionList = new ArrayList<Double>();
        ArrayList<Double> derived_function;
        
        double fx_total, gx_total;
        final double x_init = Double.parseDouble(args[0]);
        
        System.out.println("x_init is:" + x_init);
        for(int k=1;k<functionList.size();k++){
                functionList.add(k, Double.parseDouble(args[k]));
                System.out.println("x"+ (k-1) + " = " +functionList.get(k));
        }
        System.out.println("");
        
        //final double[] normal_function = function;
        
        fx_total = get_fx_value_method(functionList, x_init);
        
        System.out.println("");
        System.out.println("" + Arrays.toString(functionList.toArray()));
        
        derived_function = derive_method(functionList);
        
        System.out.println("" + Arrays.toString(functionList.toArray()));
        System.out.println("" + Arrays.toString(derived_function.toArray()));
        
        gx_total = get_derivated_value_method(derived_function, x_init);
        
        System.out.println("");
        
        //iterator(x_init, 5, functionList);
        //get_iteration_values(10, x_init, normal_function, derived_function);
        
    }
    
    private static ArrayList<Double> derive_method(ArrayList<Double> function){
        ArrayList<Double> derived_function = function;
        
        System.out.println("derived function");
        for(int k=1;k<function.size();k++){
            if(k!=(function.size()-1))
                derived_function.set(k, (derived_function.get(k+1) * k));
            else
                derived_function.set(k,null);
            
            //System.out.println("X" + (k-1) + " = " + derived_function[k]);
        }
        return derived_function;
    }
    
    private static double get_fx_value_method(ArrayList<Double> function, final double x_init){ // LISTO
        double fx_total=0;
        
        for(int k=1;k<function.size();k++){
            //System.out.println("pre "+ function[k]);
            //System.out.println("pre "+ x_init);
            if(k==1)
                fx_total += function.get(k);
            else
                fx_total += Math.pow(x_init,(k-1))*function.get(k);
            
            //System.out.println("fx #" + k + ": " + fx_total);    
            //System.out.println("post "+ function[k]);
        }
        
        //System.out.println("The total is: " + fx_total);
        
        return fx_total;
    }
    
    private static double get_derivated_value_method(ArrayList<Double> function, double x_init){ //LISTO
        double gx_total=0;
        
        for(int k=1;k<function.size();k++){
            //System.out.println("pre "+ function[k]);
            
            if(k==1)
                gx_total += function.get(k);
            else
                gx_total += Math.pow(x_init,(k-1))*function.get(k);
            
            //System.out.println("fx #" + k + ": " + gx_total);    
            //System.out.println("post "+ function[k]);
        }       
        
        //System.out.println("The total is: " + gx_total);
        
        return gx_total;
    }
    
    /*public static void iterator(final double x_init, final int iteration_times, ArrayList<Double> function){
        double[] fx_values = new double[iteration_times+1];
        double[] gx_values = new double[iteration_times+1];
        final double[] method_function = function;
        double x_init_var = x_init;
        
        fx_values[0] = get_fx_value_method(function, x_init);
        gx_values[0] = get_derivated_value_method(derive_method(method_function), x_init);
        
        System.out.println("i \t X \t f(x) \t f'(x) \t err");
        System.out.println("0 \t" + x_init_var + "\t "+fx_values[0]+" \t "+gx_values[0]+" \t");
        
        for(int k=1;k<fx_values.length;k++){
            final double[] for_function = method_function;
            
            x_init_var -= (fx_values[(k-1)] / gx_values[(k-1)]);
            fx_values[k] = get_fx_value_method(function, x_init_var);
            gx_values[k] = get_derivated_value_method(method_function, x_init_var);
            System.out.println("" + k + "\t" + x_init_var + "\t "+fx_values[k]+" \t "+gx_values[k]+" \t" + (Math.abs(((x_init_var-x_init)/x_init_var))*100) + "%");
            //System.out.println("x = " + x_init_var);   
        }
    }*/
}
