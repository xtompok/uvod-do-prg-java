/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv11;

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

public class Cv11 {

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

    Polyline hull;
    Point[] points;
    
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        points = Point.defaultPoints();
        hull = Point.convexHull(points);
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000,800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        drawPolyline(g,hull);
        drawPoints(g,points);

    }
    private void drawPolyline(Graphics g, Polyline p){
        for (int i=1;i<p.xs.size();i++){
            g.drawLine(p.xs.get(i-1),p.ys.get(i-1),p.xs.get(i),p.ys.get(i));
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
    
    // Vrati konvexni obal pole bodu
    public static Polyline convexHull(Point [] points){
        Polyline hull;
        hull = new Polyline();
       
        Point left;
        Point right;
        
        left = leftmost(points);
        right = rightmost(points);
        
        Point next;
        next = left;
        hull.addPoint(next);
        while (next!=right){
            next = downHull(next, points);
            hull.addPoint(next);
        }
        while (next!=left){
            next = upHull(next,points);
            hull.addPoint(next);
        }
        
        return hull;
    }
    
    // Vrati nejlevejsi bod
    public static Point leftmost(Point [] points){
        Point leftmost;
        int minx;
        minx = points[0].x;
        leftmost = points[0];
        for (int i=0;i<points.length;i++){
            if (minx > points[i].x){
                minx = points[i].x;
                leftmost = points[i];
            }
        }
        return leftmost;
    }
    
    // Vrati nejpravejsi bod
    public static Point rightmost(Point [] points){
        Point rightmost;
        int maxx;
        maxx = points[0].x;
        rightmost = points[0];
        for (int i=0;i<points.length;i++){
            if (maxx < points[i].x){
                maxx = points[i].x;
                rightmost = points[i];
            }
        }
        return rightmost;
    }
    
    // Vrati status bodu b proti bodu a pri dolni pulce obalu
    // -1 - nezajimej se o nej (nad nebo za bodem a)
    //  0 - pridej ho do porovnani podle uhlu
    //  1 - vezmi ho hned, je to nejlepsi kandidat (svisle dolu)
    public static int downstatus(Point a, Point b){
        if (a==b){
            return -1;
        }
        if (a.x > b.x){
            return -1;
        }
        if ((a.x==b.x)&&(b.y <= a.y)){
            return -1;
        }
        if ((a.x==b.x)&&(b.y > a.y)){
            return 1;
        }
        return 0;   
    }
    
    //  Vrati status bodu b proti bodu a pri horni pulce obalu
    //  Viz downstatus
    public static int upstatus(Point a, Point b){
        if (a==b){
            return -1;
        }
        if (a.x < b.x){
            return -1;
        }
        if ((a.x==b.x)&&(b.y < a.y)){
            return 1;
        }
        if ((a.x==b.x)&&(b.y >= a.y)){
            return -1;
        }
        return 0;   
    }
    
    // Vrati pomer dy/dx, coz aproximuje uhel pro porovnavani
    public static double angle(Point a, Point b){
        return (((double)b.y-a.y)/((double)b.x-a.x));
    }
    
    // Najde dolni pulku konvexniho obalu
    public static Point downHull(Point p, Point [] points){
        Point next;
        double angmax = Double.NEGATIVE_INFINITY;
        next = null;
        for (int i=0;i<points.length;i++){
            int st;
            st = downstatus(p,points[i]);
            if (st==1){
                return points[i];
            }
            if (st==-1){
                continue;
            }
            double ang;
            ang = angle(p, points[i]);
            if (ang > angmax){
                angmax = ang;
                next = points[i];
            }
        }
        return next;
    }
    
    // Najde horni pulku konvexniho obalu
     public static Point upHull(Point p, Point [] points){
        Point next;
        double angmax = Double.NEGATIVE_INFINITY;
        next = null;
        for (int i=0;i<points.length;i++){
            int st;
            st = upstatus(p,points[i]);
            if (st==1){
                return points[i];
            }
            if (st==-1){
                continue;
            }
            double ang;
            ang = angle(p, points[i]);
            if (ang > angmax){
                angmax = ang;
                next = points[i];
            }
        }
        return next;
    }
}

class Polyline {
    public List<Integer> xs;
    public List<Integer> ys;
    
    // Vytvori preddefinovanou lomenou caru
    public static Polyline defaultPolyline(){
        Polyline p;
        p = new Polyline();
        p.addPoint(10,0);
        p.addPoint(10,62);
        p.addPoint(190,125);
        p.addPoint(220,83);
        p.addPoint(240,300);
        p.addPoint(440,275);
        p.addPoint(550,150);
        p.addPoint(600,-60);
        p.addPoint(485,-230);
        p.addPoint(455,-210);
        p.addPoint(512,-165);
        p.addPoint(370,-109);
        p.addPoint(243,-170);
        p.addPoint(71,-32);
        for (int i=0;i<p.xs.size();i++){
            p.ys.set(i, p.ys.get(i)+300);
        }
        return p;
    }
    
    // Vytvori prazdnou lomenou caru, konstruktor
    public Polyline(){
        xs = new LinkedList<>();
        ys = new LinkedList<>();
    }
    
    // Prida bod na konec lomene cary
    public void addPoint(int x, int y){
        xs.add(x);
        ys.add(y);
    }
    
    // Prida bod na konec lomene cary
    public void addPoint(int [] p){
        xs.add(p[0]);
        ys.add(p[1]);
    }
    
    public void addPoint(Point p){
        xs.add(p.x);
        ys.add(p.y);
    }
    
    // Vrati i-ty bod na lomene care jako pole o 2 prvcich
    public int[] getPoint(int i){
        int p[] = new int[2];
        p[0] = xs.get(i);
        p[1] = ys.get(i);
        return p;
    }
    
    
    // Smaze i-ty bod na lomene care
    public void removePoint(int i){
        xs.remove(i);
        ys.remove(i);
    }
    
    // Generalizuje lomenou caru
    public Polyline generalize(){
        return gen_rec(this,0,xs.size()-1,100);
      /*  Polyline p = new Polyline();
        for (int i=0;i<xs.size();i++){
            p.addPoint(xs.get(i)+5, ys.get(i)+5);
        }
        return p;*/
    }
    
    public static double dist(int []p1, int []p2, int []p0){
        double upper = abs((p2[1]-p1[1])*p0[1] - (p2[0]-p1[0])*p0[1] +
                p2[0]*p1[1] - p1[0]*p2[1]);
        double lower = sqrt((p2[1]-p1[1])*(p2[1]-p1[1]) + (p2[0]-p1[0])*(p2[0]-p1[0]));
        return upper/lower;
       
    }
    
    public static Polyline concat(Polyline a, Polyline b){
        Polyline p;
        p = new Polyline();
        p.xs.addAll(a.xs);
        p.xs.addAll(b.xs);
        p.ys.addAll(a.ys);
        p.ys.addAll(b.ys);
        return p;
    }
    
    /*
    Kroky k vítězství:
    - počítání vzdálenosti bodu od přímky
    - hledání maximální vzdálenosti
    - rekurze podle výsledků předchozího
        - pokud jsem pod maximem, jen vrátím úsečku
        - jinak dělím v maximálním bodu a rekurzím
            - Polyline vrácené z rekurze slepím a vrátím
    */
    public static Polyline gen_rec(Polyline p, int start, int end, int h){
        double maxdist = 0;
        int maxdistidx = -1;
        for (int i=start+1; i<=end-1;i++){
            double d;
            d = dist(p.getPoint(start),p.getPoint(end),p.getPoint(i));
            System.out.println(d);
            if (d > maxdist){
                maxdist = d;
                maxdistidx = i;
            }
        }
        System.out.format("Max dist: %f\n",maxdist);
        if (maxdist < h){
            Polyline out;
            out = new Polyline();
            out.addPoint(p.getPoint(start));
            out.addPoint(p.getPoint(end));
            
            return out;
        }
        Polyline p1;
        Polyline p2;
        p1 = gen_rec(p,start,maxdistidx,h);
        p2 = gen_rec(p,maxdistidx,end,h);
        return concat(p1,p2);
    }
    
    // Nelze xs[5]
    // a = xs.get(5), xs.set(5,b) <=> xs[5]=b
    // xs.add(c)
}
