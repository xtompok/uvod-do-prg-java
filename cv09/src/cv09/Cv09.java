/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv09;

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

public class Cv09 {
   
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

    Polyline oldPoly;
    Polyline newPoly;
    
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        oldPoly = Polyline.defaultPolyline();
        newPoly = oldPoly.generalize();
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000,800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        drawPolyline(g,oldPoly);
        g.setColor(Color.red);
        drawPolyline(g,newPoly);
        
    }
    private void drawPolyline(Graphics g, Polyline p){
        for (int i=1;i<p.xs.size();i++){
            g.drawLine(p.xs.get(i-1),p.ys.get(i-1),p.xs.get(i),p.ys.get(i));
        }
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
