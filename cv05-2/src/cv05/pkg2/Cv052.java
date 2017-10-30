/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05.pkg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jethro
 */
public class Cv052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //vypisPrvocisla(10);
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
