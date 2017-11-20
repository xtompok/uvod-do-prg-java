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
        int [] arr;
        int len = 1000000;
        arr = genArray(len);
        //int elem;
        //elem = randInt(10);
        //for (int i=0;i<len;i++){
        //    System.out.format("%d ",arr[i]);
        //}
        //System.out.println();
        //System.out.println(elem);
        //System.out.println(binSearch(arr,elem,0,len-1));
        int found;
        found = 0;
        for (int i=0;i<20000;i++){
            if (binSearch(arr,randInt(1000000),0,len-1)!=-1){
            //if (stupidSearch(arr,randInt(1000000),0,len-1)!=-1){
                found++;
            }
        }
        System.out.println(found);
    }
    
    public static int [] genArray(int n){
        int [] arr;
        arr = new int[n];
        arr[0] = randInt(10);
        for (int i=1;i<n;i++){
            arr[i] = arr[i-1]+randInt(10);
        }
        return arr;
    }
    
    public static int binSearch(int [] arr, int elem, int from, int to){
        if (to-from <=1){
            if (arr[from]==elem){
                return from;
            }
            if (arr[to] == elem){
                return to;
            }
            return -1;
        }
        if (arr[(from+to)/2] > elem){
            return binSearch(arr,elem,from,(from+to)/2);
        }else{
            return binSearch(arr,elem,(from+to)/2,to);
        }
    }
    
    public static int stupidSearch(int [] arr, int elem, int from, int to){
        for (int i=from; i<=to;i++){
            if (arr[i]==elem){
                return i;
            }
        }
        return -1;
    }
    
    public static int randInt(int max){
        return rnd.nextInt(max);
    }
    
}
