/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import clases.TableroJuego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saust
 */
public class Pelota {

    private float x;
    private float y;
    private float dx = (float) 1, dy = (float) 1;
    private int ANCHO = 15, ALTO = 15;

    private Integer puntaje1 = 0, puntaje2 = 0;
    int vidas1 = 3;
    public static boolean finJuego = false;

    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;

        if (colisionR1) {
            dx = -dx;
            x = TableroJuego.XposicionRaqueta1 + 15;
            puntaje1++;
        }
        if (colisionR2) {
            dx = -dx;
            x = TableroJuego.XposicionRaqueta2 - 21;
        }

//____________________________________________________________
        //Rebotes contra las paredes
        if (x > (limites.getMaxX() - ANCHO)) {
            dx = -dx;
            //rebote_2.play();
        }
//____________________________________________________________
        //Rebotes contra techo y piso
        if (y > (limites.getMaxY() - ALTO)) {
            dy = -dy;
        }
        if (y < 0) {
            //x = (int) limites.getMinX();
            dy = -dy;
            //rebote_2.play();  
        }
//____________________________________________________________        
        //
        if (x < limites.getMinX()-this.ANCHO) {
            vidas1--;
            puntaje2++;

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            x = (int) limites.width - 20;
            y = (int) limites.getCenterY();

            dx = -dx;         
        }

    }
    
    public int getScore1(){
        return puntaje1;
    }
    public int getVidas1(){
        return vidas1;
    }
    
    public int getScore2(){
        return puntaje2;
    }
}
