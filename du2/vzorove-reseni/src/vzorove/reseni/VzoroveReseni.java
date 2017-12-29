/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vzorove.reseni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.pow;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * IDW interpolation
 *
 * @author jethro
 */
public class VzoroveReseni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double [][] data;
        data = loadData(args[0]);
        double [][] raster;
        raster = idwRaster(data, 2, 0);
        writeResults(raster, args[1]);      
    }
    
    /** Load data from file
     * 
     * @param filename name of the input file
     * @return 2 dimensional array, points in lines
     */
    public static double [][] loadData(String filename){
        double data[][];
        data = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            line = br.readLine();
            int lines;
            lines = Integer.parseInt(line);
            data = new double [lines][3];
            int i;
            i = 0;
            while ((line = br.readLine())!=null){
                String [] items;
                items = line.split(",");
                if (items.length != 3){
                    System.err.format("Wrong number of items (%d) in line %s",items.length,line);
                }
                for (int j=0;j<3;j++){
                    data[i][j] = Double.parseDouble(items[j]);
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.err.format("File %s not found",filename);
            System.exit(1);
        } catch (IOException ex) {
            System.err.print("Error while reading a line");
            System.exit(1);
        } catch (NumberFormatException ex){
            System.err.format("Error parsing number");
            System.exit(1);
        }
        return data;
    }
    
    /** Find bounding box of given points
     * 
     * @param data 2 dimensional array, points in lines
     * @return array {minx,miny,maxx,maxy}
     */
    public static double [] getBBox(double [][] data){
        double minx;
        double miny;
        double maxx;
        double maxy;
        minx = maxx = data[0][0];
        miny = maxy = data[0][1];
        for (int i=1;i<data.length;i++){
            if (minx > data[i][0]){
                minx = data[i][0];
            }
            if (miny > data[i][1]){
                miny = data[i][1];
            }
            
            maxx = (maxx<data[i][0])?data[i][0]:maxx;
            maxy = (maxy<data[i][1])?data[i][1]:maxy;
        }
        double [] bbox;
        bbox = new double[4];
        bbox[0] = minx;
        bbox[1] = miny;
        bbox[2] = maxx;
        bbox[3] = maxy;
        return bbox;
    }
    
    /** Calculate value of IDW interpolation for one point
     * 
     * @param data 2 dimensional array, points in lines
     * @param x x axis coordinate
     * @param y y axis coordinate
     * @param p power of the weighting fuction
     * @param s smoothness coefficient
     * @return value of the interpolated point
     */
    public static double idwPoint(double [][] data, double x, double y, double p, double s){
        double sum;
        double sumw;
        sum = 0;
        sumw = 0;
        for (int i=0;i<data.length;i++){
            double d;
            d = dist(data[i],x,y);
            if (d==0){
                return data[i][2];
            }
            sum+=1/pow((d+s),p) * data[i][2];
            sumw += 1/pow((d+s),p);
        }
        return sum/sumw;
    }
    
    /** Calculate distance between point and coordinates
     * 
     * @param datapoint coordinates of a datapoint [x,y,z]
     * @param x x part of coordinate
     * @param y y part of coordinate
     * @return eucleidan distance between datapoint and given coordinates
     */
    public static double dist(double [] datapoint, double x, double y){
        return Math.sqrt((datapoint[0]-x)*(datapoint[0]-x) + (datapoint[1]-y)*(datapoint[1]-y));
    }
    
    /** Calculate IDW interpolation of the raster
     * 
     * @param data array of a points, points in lines
     * @param p power of the weighting function
     * @param s smoothness coefficient
     * @return array of the interpolated values
     */
    public static double [][] idwRaster (double [][] data, double p, double s){
        double [] bbox;
        bbox = getBBox(data);
        double[][] raster;
        raster = new double[100][100];
        for (int x=0;x<100;x++){
            System.out.println(x*(bbox[2]-bbox[0])/99+bbox[0]);
            for (int y=0;y<100;y++){
                raster[x][y] = idwPoint(data, x*(bbox[2]-bbox[0])/99+bbox[0], y*(bbox[3]-bbox[1])/99+bbox[1], p, s);
            }
        }
        return raster;
    }
    
    /** Write results to the file
     * 
     * @param raster resulting raster
     * @param filename name of the file to write
     */
    public static void writeResults(double [][] raster, String filename){
        PrintWriter writer;
        Locale.setDefault(Locale.US);
        try {
            writer = new PrintWriter(filename);
            for (int x=0;x<raster.length;x++){
                for (int y=0;y<raster[0].length;y++){
                    writer.format("%.2f,", raster[y][x]);
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            System.err.format("File '%s' not found.",filename);
            System.exit(1);
        } 
    }
}
