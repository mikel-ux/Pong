/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class TableroJuego extends JPanel{
    
    Pelota pelota = new Pelota(0,0);
    Raqueta r1 = new Raqueta((Ventana.ANCHO/2)-(Raqueta.ANCHO/2), Ventana.ALTO-Raqueta.ALTO-50);
    
    Raqueta r2 = new Raqueta(Ventana.ANCHO-Raqueta.ANCHO-50, (Ventana.ALTO/2)-Raqueta.ALTO);
    
    public TableroJuego(){
        this.setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        dibujarPuntaje(g2);
        dibujar(g2);
        actualizar();
    }
    
    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        //g.fill(r2.getRaqueta());
    }
    
    public void actualizar(){
        pelota.mover(getBounds(),colision(r1.getRaqueta()), colision(r2.getRaqueta()));
        r1.moverR1(getBounds());
    }
    
    public void iterarJuego(){
        while(true){
            repaint();
            
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean colision(Rectangle2D r){
        return pelota.getPelota().intersects(r);
    }
    
    public void dibujarPuntaje(Graphics2D g){
        
        Graphics2D g1=g, g2=g, vidas=g, cancha=g;
        
        Font puntaje = new Font("Arial", Font.BOLD, 30);
        g.setFont(puntaje);
        
        g1.drawString("Score: "+Integer.toString(pelota.getScore1()), (float)getBounds().getCenterX()+125, 30);
        vidas.drawString("Lives: "+Integer.toString(pelota.getVidas1()), (float)getBounds().getCenterX()-175, 30);
        cancha.fill(new Rectangle2D.Double(-30, (float)getBounds().getCenterY(), 1000, 1));
        
        //g2.drawString(Integer.toString(pelota.getScore2()), (float)getBounds().getCenterX()+40, 30);
        if(pelota.getScore1()==5){
            g.drawString("GANASTE!", (float) (Ventana.ANCHO/2)-75, (float)getBounds().getCenterY());
            Pelota.finJuego=true;
        }
        if(pelota.getVidas1()<=0){
            g.drawString("PERDISTE!", (float) (Ventana.ANCHO/2)-75, (float)getBounds().getCenterY());
            Pelota.finJuego=true;
        }
        
        
    }
            
}
