/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv6.pkg1;

import java.util.Arrays;

/**
 *
 * @author jethro
 */
public class Cv61 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double [] array;
        array = new double[10];
        for (int i=0;i<array.length;i++){
            array[i] = Math.random();
        }
        for (int i=0;i<array.length;i++){
            System.out.print(String.format("%f ", array[i]));
        }
        
        System.out.println();
        System.out.println("Minimum je "+min(array));
        System.out.println("Maximum je "+max(array));
        System.out.println("Průměr je "+avg(array));
        System.out.println("Medián je "+med(array));

    }
    
    public static double min(double [] arr){
        double min = arr[0];
        for (int i=0;i<arr.length;i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
    
    public static double max(double [] arr){
        double max = arr[0];
        for (int i=0;i<arr.length;i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
        
    public static double avg(double [] arr){
        double sum = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum/arr.length;
    }
    
    public static double med(double [] arr){
        Arrays.sort(arr);
        if (arr.length %2 == 1){
            return arr[arr.length/2+1];
        }
        return (arr[arr.length/2]+arr[arr.length/2-1])/2;
    }
    
    
}
