/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundnumber;
import static java.lang.Math.*;

/**
 *
 * @author bayertom
 */
public class RoundNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = -12.5488289;
        int digits = 4;
        double pow_ten = pow(10, digits);
        a = a * pow_ten;
        a = (int)(a + 0.5);
        a = a / pow_ten;
        System.out.println(a);
        
    }
    
}
