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
        printPrimes(260);
    }
    
    public static void printPrimes(int n){
        for (int i=2;i<n;i++){
            boolean prime = true;
            for (int j=2;j<=i/2;j++){
                if (i%j==0){
                    prime = false;
                    break;
                }
            }
            if (prime){
                System.out.println(i);
            }
        }
    }
    
    public static void printPrimes2(int n){
        for (int i=2;i<n;i++){
            boolean prime = true;
            for (int j=2;j<=i/2;j++){
                prime = prime && (i%j != 0);
            }
            if (prime){
                System.out.println(i);
            }
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
