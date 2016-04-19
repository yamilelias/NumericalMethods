/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package horner;

/**
 *
 * @author astaroth
 */
public class MetodoHorner {
    public MetodoHorner(){
    
    }
    private final char numeros []= {'0','1','2','3','4','5','6','7','8','9'};
    public String Calcular(String funcion, String valor){
        funcion+=",,";
        char f[]= funcion.toCharArray();
        int c[]={0,0,0,0,0,0},countX[]={-1,-1,-1,-1,-1},cx=funcion.indexOf("x");
        System.out.println(cx);
        for(int i=0;i<funcion.length()-2;i++){
            cx=funcion.indexOf("x", cx);
            if(f[cx+2]=='5' && f[cx+1]=='^'){
                countX[0]=cx;
                System.out.println(cx+" 5");
            }else if(f[cx+2]=='4' && f[cx+1]=='^'){
                countX[1]=cx;
                System.out.println(cx+" 4");
            }else if(f[cx+2]=='3' && f[cx+1]=='^'){
                countX[2]=cx;
                System.out.println(cx+" 3");
            }else if(f[cx+2]=='2' && f[cx+1]=='^'){
                countX[3]=cx;
                System.out.println(cx+" 2");
            }else if(f[cx+2]=='1' && f[cx+1]=='^'){
                countX[4]=cx;
                System.out.println(countX[4]+" 1");
            }else if(cx!=-1 && f[cx]=='x' && f[cx+1]!='^'){
                countX[4]=cx;
                System.out.println(cx+" 1");
            }     
            if(cx<0)
               i=funcion.length();
            else
                cx++;
        }
        cx=0;
        
        for(int i=0;i<=4;i++){
            boolean continuar=true, signo=true;
            String numero="";           
            if(countX[i]!=-1){
                cx=countX[i];
                if(cx==0)
                    numero+=""+1;
            }            
            if(cx>0){
            System.out.println(i+" "+cx);
            while(continuar){                
                    if(f[cx]!='+' && f[cx]!='-'){
                        System.out.println(f[cx]+" holasd");
                        if(cx>0)
                            cx--;
                        else
                            continuar=false;
                    }else{
                        continuar=false;
                    }               
            }
            
            System.out.println(""+cx);
            boolean solo=true;
            for(int n=cx;n<=countX[i];n++){
                
                System.out.println("n "+n+" y x en "+countX[i]);
                if(f[n]=='-'){
                    signo=false;
                    solo=false;
                }
                else if(f[n]=='+'){
                    signo=true;
                    solo=false;
                }
                else if(f[n]!='x'){
                    numero+=""+f[n];
                    solo=false;
                }
                else if(solo==true){
                    numero+=""+1;
                    solo=true;
                }
            }
            System.out.println("numero "+numero);
            if(signo==true)
                c[i]=Integer.parseInt(numero);
            else
                c[i]=(Integer.parseInt(numero))*-1;
            System.out.println(c[i]+" guardado en "+i);
        }}
        
        return " ";
    }
    
}
