/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.metodos;
import java.util.Arrays;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
/**
 *
 * @author astaroth
 */
public class Derivador {
    public String Derivar (String funcion){
        String derivada="";
        DJep Derivar = new DJep();
        Derivar.addStandardFunctions();
        Derivar.addStandardConstants();
        Derivar.addComplex();
        Derivar.setAllowUndeclared(true);
        Derivar.setAllowAssignment(true);
        Derivar.setImplicitMul(true);
        Derivar.addStandardDiffRules();
        try{
            Node node = Derivar.parse(funcion);
            
            Node diff= Derivar.differentiate(node, "x");
            //Node sim =Derivar.simplify(diff);
            derivada=Derivar.toString(diff);
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        return derivada;
    }
    public String DerivarY (String funcion){
        String derivada="";
        DJep Derivar = new DJep();
        Derivar.addStandardFunctions();
        Derivar.addStandardConstants();
        Derivar.addComplex();
        Derivar.setAllowUndeclared(true);
        Derivar.setAllowAssignment(true);
        Derivar.setImplicitMul(true);
        Derivar.addStandardDiffRules();
        try{
            Node node = Derivar.parse(funcion);
            
            Node diff= Derivar.differentiate(node, "y");
            Node sim =Derivar.simplify(diff);
            derivada=Derivar.toString(sim);
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        return derivada;
    }
    
}
