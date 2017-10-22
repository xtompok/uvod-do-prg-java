/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package round;

/**
 *
 * @author bayertom
 */
public class Round {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    double c = -13.6578;
    int d = 2;
    double m = (int) Math.pow(10, d-1);
            
    double c_round = (int)(c*m+0.5)/m;
    
    System.out.println (c_round);
    }
}
