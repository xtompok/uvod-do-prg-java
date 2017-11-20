/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv07.pkg1;

/**
 *
 * @author jethro
 */
public class Cv071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i=0;i<45;i++){
            System.out.format("%d:",i);
            System.out.format("%d ",fibRec(i));
     //       System.out.format("%d\n",fibCycle(i));
        }
    }
    
    
    public static int fibRec(int n){
        if(n<=1){
            return 1;
        }
        return fibRec(n-1)+fibRec(n-2);
    }
    
    public static int fibCycle(int n){
        if (n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        int fa = 1;
        int fb = 1;
        for (int i=1;i<n;i++){
            int fc = fa+fb;
            fa = fb;
            fb = fc;
        }
        return fb;
    }
    
}
