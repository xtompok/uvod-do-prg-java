/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money;

/**
 *
 * @author bayertom
 */
public class Money {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        int c = 14170;
        final int COLD = c;
        final int B5000 = 5000, B2000 = 2000, B1000 = 1000, B500 = 500, B200 = 200, B100 = 100, B50 = 50, B20 = 20, B10 = 10, B5 = 5, B2 = 2, B1 = 1;
        
        
        int n5000=c/B5000;
        c-=n5000*B5000;
        int n2000=c/B2000;
        c-=n2000*B2000;
        int n1000=c/B1000;
        c-=n1000*B1000;
        int n500=c/B500;
        c-=n500*B500;
        int n200=c/B200;
        c-=n200*B200;
        int n100=c/B100;
        c-=n100*B100;
        int n50=c/B50;
        c-=n50*B50;
        int n20=c/B20;
        c-=n20*B20;
        int n10=c/B10;
        c-=n10*B10;  
        int n5=c/B5;
        c-=n5*B5;
        int n2=c/B2;
        c-=n2*B2;
        int n1=c/B1;
        c-=n1*B1;
        int n=n5000+n500+n50+n5+n1000+n100+n10+n1+n2000+n200+n20+n2;
        
        System.out.println("Primary count:"+COLD+"\tn5000="+n5000+"\tn2000="+n2000+"\tn1000="+n1000);
        System.out.println("\tn500="+n500+"\tn200="+n200+"\tn100="+n100);
        System.out.println("\tn50="+n50+"\tn20="+n20+"\tn10="+n10);
        System.out.println("\tn5="+n5+"\tn2="+n2+"\tn1="+n1);
        System.out.println("sum of banknotes="+n);
    }
}
