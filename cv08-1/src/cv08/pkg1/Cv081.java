/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08.pkg1;

import java.util.Random;

/**
 *
 * @author jethro
 */
public class Cv081 {
    public static Random rnd;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        rnd = new Random();
        // TODO code application logic here
 
    }
    
    public static int randInt(int max){
        return rnd.nextInt(max);
    }
    
}
