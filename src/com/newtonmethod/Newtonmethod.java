/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newtonmethod;

/**
 *
 * @author Yamil Elías
 */
public class Newtonmethod {
    
    double x_init, err, percentage_err;
    double fx_total, gx_total;
    double[] function;

    public Newtonmethod(double x_4, double x_3, double x_2, double x_1, double x, double x_init, double err) {
        function = new double[5];
        
        function[4] = x_4;
        function[3] = x_3;
        function[2] = x_2;
        function[1] = x_1;
        function[0] = x;
        this.x_init = x_init;
        this.err = err;
        
        derive_method(function);
    }
    
    public void get_fx_value_method(){
        for(int k=0;k<function.length;k++){
            if(k==0)
                fx_total += function[k];
            
            fx_total += function[k]*(x_init*k);
        }       
    }
    
    public void get_gx_value_method(){
        for(int k=0;k<function.length;k++){
            if(k==0)
                gx_total += function[k];
            else
                gx_total += Math.pow(x_init,k-1)*function[k];
        }     
    }
    
    protected double[] derive_method(final double[] function){
        double[] derived_function = function;
        
        for(int k=0;k<function.length;k++){
            derived_function[k]= Math.pow(derived_function[k], k);
        }
        return derived_function;
    }
    
    protected double get_x_value_method(double x_init){
        
        return this.x_init;
    }
}
