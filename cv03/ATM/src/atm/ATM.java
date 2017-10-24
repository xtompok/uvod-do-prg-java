/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author bayertom
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int b1 = 1;
//        int b2 = 2;
//        int b5 = 5;
//        int b10 = 10;
//        int b20 = 20;
//        int b50 = 50;
//        int b100 = 100;
//        int b200 = 200;
//        int b500 = 500;
//        int b1000 = 1000;
//        int b2000 = 2000;
//        int b5000 = 5000;
        int c = 17280;
        int d = c;
        int []b = {5000,2000,1000,500,200,100,50,20,10,5,2,1};
        
        int k1 = c / b[0];
        c -= k1 * b[0];
        int k2 = c / b[1];
        c -= k2 * b[1];
        int k3 = c / b[2];
        c -= k3 * b[2];
        int k4 = c / b[3];
        c -= (k4 * b[3]);
        int k5 = c / b[4];
        c -= (k5 * b[4]);
        int k6 = c / b[5];
        c -= (k6 * b[5]);
        int k7 = c / b[6];
        c -= (k7 * b[6]);
        int k8 = c / b[7];
        c -= (k8 * b[7]);
        int k9 = c / b[8];
        c -= (k9 * b[8]);
        int k10 = c / b[9];
        c -= (k10 * b[9]);
        int k11 = c / b[10];
        c -= (k11 * b[10]);
        int k12 = c / b[11];
        c -= (k12 * b[11]);

        System.out.println("Required cash:" + d + "CZK");
        if (k1>0) 
            System.out.format("%d x %d CZK\n", b[0], k1); 
        if (k2>0)
            System.out.format("%d x %d CZK\n", b[1], k2);
        if (k3>0)
            System.out.format("%d x %d CZK\n", b[2], k3);
        if (k4>0)
            System.out.format("%d x %d CZK\n", b[3], k4);
        if (k5>0)
            System.out.format("%d x %d CZK\n", b[4], k5);
        if (k6>0)
            System.out.format("%d x %d CZK\n", b[5], k6);
        if (k7>0)
            System.out.format("%d x %d CZK\n", b[6], k7);
        if (k8>0)
            System.out.format("%d x %d CZK\n", b[7], k8);
        if (k9>0)
            System.out.format("%d x %d CZK\n", b[8], k9);
        if (k10>0)
            System.out.format("%d x %d CZK\n", b[9], k10);
        if (k11>0)
            System.out.format("%d x %d CZK\n", b[10], k11);
        if (k12>0)
            System.out.format("%d x %d CZK\n", b[11], k12);
        
//        int k1 = c / b5000;
//        c -= (k1 * b5000);
//        int k2 = c / b2000;
//        c -= (k2 * b2000);
//        int k3 = c / b1000;
//        c -= (k3 * b1000);
//        int k4 = c / b500;
//        c -= (k4 * b500);
//        int k5 = c / b200;
//        c -= (k5 * b200);
//        int k6 = c / b100;
//        c -= (k6 * b100);
//        int k7 = c / b50;
//        c -= (k7 * b50);
//        int k8 = c / b20;
//        c -= (k8 * b20);
//        int k9 = c / b10;
//        c -= (k9 * b10);
//        int k10 = c / b5;
//        c -= (k10 * b5);
//        int k11 = c / b2;
//        c -= (k11 * b2);
//        int k12 = c / b1;
//        c -= (k12 * b1);
//        
//        System.out.println("Required cash:" + d + "CZK");
//        System.out.println(k1 + "x 5000 CZK");
//        System.out.println(k2 + "x 2000 CZK");
//        System.out.println(k3 + "x 1000 CZK");
//        System.out.format("%d x %d CZK\n", b500, k4);
//        System.out.format("%d x %d CZK\n", b200, k5);
//        System.out.format("%d x %d CZK\n", b100, k6);
//        System.out.format("%d x %d CZK\n", b50, k7);
//        System.out.format("%d x %d CZK\n", b20, k8);
//        System.out.format("%d x %d CZK\n", b10, k9);
//        System.out.format("%d x %d CZK\n", b5, k10);
//        System.out.format("%d x %d CZK\n", b2, k11);
//        System.out.format("%d x %d CZK\n", b1, k12);
        
        
        
    }
    
}
