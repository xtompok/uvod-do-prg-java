/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv13;

/**
 *
 * @author tutorial on Oracle docs
 */

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cv13 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }

    
}

class MyPanel extends JPanel {

    Line[] edges;
    Point[] points;
    
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        points = Point.defaultPoints();
        edges = Point.skeleton(points);
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000,800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        drawLines(g,edges);
        drawPoints(g,points);

    }
    private void drawLines(Graphics g, Line [] la){
        for (int i=1;i<la.length;i++){
            g.drawLine(la[i].x1,la[i].y1,la[i].x2,la[i].y2);
        }
    }
    
    private void drawPoints(Graphics g, Point[] points){
        for (int i=0;i<points.length;i++){
            g.drawOval(points[i].x-2, points[i].y-2, 4, 4);
        }
    }
    

}

class Point{
    public int x;
    public int y;
    
    // Vytvori nahodne hejno bodu
    public static Point[] defaultPoints(){
        Random rnd;
        rnd = new Random();
        Point [] points;
        points = new Point[100];
        for (int i=0;i<100;i++){
                points[i] = new Point(rnd.nextInt(500)+10,rnd.nextInt(500)+10);
        }
        return points;
    }
    
    // Vytvori bod 0,0
    public Point(){
        x = 0;
        y = 0;
    }
    
    
    // Vytvori bod ax,ay
    public Point(int ax, int ay){
        x = ax;
        y = ay;
    }
    
    public static Line[] skeleton(Point [] points){
        Line [] edges;
        edges = new Line[points.length-1];
        for (int i=0;i<points.length-1;i++){
            edges[i] = new Line(points[0].x,points[0].y,points[i].x,points[i].y);
        }
        return edges;
    }
    
}

class Line {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Line(int x1,int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    public Line(int [] pt1, int [] pt2){
        this.x1 = pt1[0];
        this.x2 = pt1[1];
        this.y1 = pt2[0];
        this.y2 = pt2[1];
    }

}
