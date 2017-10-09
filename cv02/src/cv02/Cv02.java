/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.abs;
import static java.lang.Math.abs;

/**
 *
 * @author jethro
 */
public class Cv02 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Zadej uhel:");
        double a = readDouble();
        int d;
        d = (int)a;
        int m = abs((int) ((a-d)*60));
        double s = abs((a-d) * 3600) - m * 60;
        System.out.format("Je to %d stupnu, %d minut a %12.2f vterin\n", d, m, s);
        if (d < 0){
            System.out.println("Stupne byly zaporne");
        } else {
            System.out.println("Stupne byly nezaporne");
        }
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
