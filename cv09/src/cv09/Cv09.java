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
    // TODO: implementovat
    public Polyline generalize(){
        Polyline p = new Polyline();
        for (int i=0;i<xs.size();i++){
            p.addPoint(xs.get(i)+5, ys.get(i)+5);
        }
        return p;
    }
}
