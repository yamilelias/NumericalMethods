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
public class Matrices {

    public int[][] suma(int a[][], int b[][], int tamano) {
        int c[][] = new int[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = 0;
            }
        }
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = a[i][n] + b[i][n];
            }
        }

        return c;
    }

    public int[][] resta(int a[][], int b[][], int tamano) {
        int c[][] = new int[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = 0;
            }
        }
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = a[i][n] - b[i][n];
            }
        }

        return c;
    }

    public int[][] multiplicacion(int a[][], int b[][], int tamano) {
        int c[][] = new int[tamano][tamano];

        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                for (int k = 0; k < tamano; k++) {

                    c[i][n] += a[i][k] * b[k][n];
                }
            }
        }

        return c;
    }

    public int[][] escalar(int a[][], int b, int tamano) {
        int c[][] = new int[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = 0;
            }
        }
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = a[i][n] * b;
            }
        }

        return c;
    }

    public int[][] operacion(int a[][], int b[][], int tamano, String funcion) {
        int c[][] = new int[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int n = 0; n < tamano; n++) {
                c[i][n] = 0;
            }
        }
        char f[] = funcion.toCharArray();
        int num[] = {0, 0};
        int n = 1;
        boolean error=true;
        String asd="";
        if(f[0]=='-' || f[0]=='+')
            asd="1";
        int ra[][], rb[][];
        for (int i = 0; i < f.length; i++) {
            if (f[i] == '-') {
                n = n * -1;
                ;
            } else if (f[i] == '+') {
                n = n;
                
            } else if (f[i] == 'a') {
                num[0] = n;
                n=1;
                asd="1";
                error=false;
            } else if (f[i] == 'b') {
                num[1] = n;
                n=1;
                asd="1";
                error=false;
            } else {
                if(!error)
                    asd="";
                if(f[i]=='0' || f[i]=='1' || f[i]=='2' || f[i]=='3' || f[i]=='4' || f[i]=='5' || f[i]=='6' || f[i]=='7' || f[i]=='8' || f[i]=='9')
                    asd+=Character.toString(f[i]);
                else
                    asd="1";
            }
            n*=Integer.parseInt(asd);
        }
        System.out.println(num[0]+" "+num[1]);
        ra=escalar(a,num[0],tamano);
        rb=escalar(b,num[1],tamano);
        c=suma(ra,rb,tamano);


        return c;
    }

}
