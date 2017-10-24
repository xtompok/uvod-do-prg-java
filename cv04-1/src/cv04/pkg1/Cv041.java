/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv04.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.sqrt;

/**
 *
 * @author jethro
 */
public class Cv041 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ukazka nepresnosti floatu ve velkych cislech
        float f;
        f= 100000000;
        if (f+1 == f){
        System.out.println("Rovna se");
        } else {
        System.out.println("Nerovna se");
        }
        
        // Vypocet vzdalenosti
        double d;
        d = dist(10,10,20,20);
        System.out.println(d);
        System.out.println(dist(10,10,13,14));
        
        quadEqPrint(4,4,1);
        
        double res[];
        //res = quadEq(4,4,1);
        //res = quadEq(1,0,1);
        res = quadEq(4,-5,1);

        System.out.format("Rovnice má %d řešení\n",res.length);
        if (res.length >= 1){
            System.out.println(res[0]);
        }
        if (res.length == 2){
            System.out.println(res[1]);
        }
        
    }
    
    public static void quadEqPrint(double a, double b, double c){
        double d;
        d = b*b - 4*a*c;
        if (d<0){
            System.out.println("Nemá řešení");
        } else if (d==0){
            System.out.println("Má 1 řešení");
            System.out.println((-b+sqrt(d))/(2*a));
        } else {
            System.out.println("Má dvě řešení");
            System.out.println((-b+sqrt(d))/(2*a));
            System.out.println((-b-sqrt(d))/(2*a));

        }
    }
        public static double[] quadEq(double a, double b, double c){
        double d;
        d = b*b - 4*a*c;
        if (d<0){
            return new double[0];
        } else if (d==0){
            double res[];
            res = new double[1];
            res[0] = (-b+sqrt(d))/(2*a);
            return res;
        } else {
            double res[];
            res = new double[2];
            res[0] = (-b+sqrt(d))/(2*a);
            res[1] = (-b-sqrt(d))/(2*a);
            return res;
        }
    }
    
    public static double dist(double ax, double ay, double bx, double by){
        double dx;
        double dy;
        dx = bx-ax;
        dy = by-ay;
        double d;
        d = sqrt(dx*dx + dy*dy);
        return d;
    }
    public static int readInt() throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }
    
    public static double readDouble() throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }

    
}
