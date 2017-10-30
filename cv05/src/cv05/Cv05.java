/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jethro
 */
public class Cv05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Vystup
        // A    B   NOT A   AND     OR
        // 0    0       1       0       0
        // 0    1       1       0       1
        // ...
        
        boolean A[] = {false,false,true,true};
        boolean B[] = {false,true,false,true};
        
        System.out.format("%6s | %6s | %6s | %6s | %6s\n","a","b","not a","and","or");
        for (int i=0;i<4;i++){
            System.out.format("%6b | %6b | %6b | %6b | %6b\n", A[i],B[i],!A[i],A[i]&&B[i],A[i]||B[i]);
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
